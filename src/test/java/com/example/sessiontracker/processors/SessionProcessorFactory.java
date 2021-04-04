package com.example.sessiontracker.processors;

import com.example.sessiontracker.messages.Message;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class SessionProcessorFactory {
    @Mock
    AnonSessionProcessorImpl anonSessionProcessor;
    @Mock
    NamedSessionProcessorImpl namedSessionProcessor;
    @InjectMocks
    SessionProcessorsFactoryImpl sessionProcessorsFactory;

    @Test
    public void anonSessionProcessorCreationTest(){
        Message message = new Message("user1","");
        SessionProcessor s = sessionProcessorsFactory.createSessionProcessor(message);
        assertTrue(s instanceof AnonSessionProcessorImpl);
    }

    @Test
    public void namedSessionProcessorCreationTest(){
        Message message = new Message("user1","Java");
        SessionProcessor s = sessionProcessorsFactory.createSessionProcessor(message);
        assertTrue(s instanceof NamedSessionProcessorImpl);
    }
}
