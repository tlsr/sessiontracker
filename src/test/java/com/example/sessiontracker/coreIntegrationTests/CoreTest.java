package com.example.sessiontracker.coreIntegrationTests;

import com.example.sessiontracker.dto.SimpleSession;
import com.example.sessiontracker.dto.SubjectedSession;
import com.example.sessiontracker.liseners.RabbitMqListener;
import com.example.sessiontracker.messages.Command;
import com.example.sessiontracker.messages.Message;
import com.example.sessiontracker.repositories.SimpleSessionRepo;
import com.example.sessiontracker.repositories.SubjectedSessionRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestPropertySource("/application-test.properties")
public class CoreTest {
    @Autowired
    RabbitMqListener rabbitMqListener;
    @Autowired
    SimpleSessionRepo simpleSessionRepo;
    @Autowired
    SubjectedSessionRepo subjectedSessionRepo;

    @Test
    public void oneAnonSessionTest() {
        Message messageStart = new Message("", "", Command.START);
        Message messageStop = new Message("", "", Command.STOP);
        rabbitMqListener.processQueue1(messageStart);
        rabbitMqListener.processQueue1(messageStop);
        List<SimpleSession> all = simpleSessionRepo.findAll();
        assertEquals(1, all.size());
        SimpleSession session = all.get(0);
        assertFalse(session.getDuration().isZero());
    }

    @Test
    public void manyAnonSessionTest() {
        Message messageStart = new Message("", "", Command.START);
        Message messageStop = new Message("", "", Command.STOP);
        rabbitMqListener.processQueue1(messageStart);
        rabbitMqListener.processQueue1(messageStop);
        rabbitMqListener.processQueue1(messageStart);
        rabbitMqListener.processQueue1(messageStop);
        List<SimpleSession> all = simpleSessionRepo.findAll();
        assertEquals(2, all.size());
        SimpleSession session = all.get(0);
        assertFalse(session.getDuration().isZero());
    }

    @Test
    public void namedSessionTest() {
        Message messageStart = new Message("", "Java", Command.START);
        Message messageStop = new Message("", "Java", Command.STOP);
        rabbitMqListener.processQueue1(messageStart);
        rabbitMqListener.processQueue1(messageStop);
        List<SubjectedSession> all = subjectedSessionRepo.findAll();
        assertEquals(1, all.size());
        SubjectedSession session = all.get(0);
        assertFalse(session.getDuration().isZero());
        assertEquals("Java",session.getSubject());
    }
}
