package com.example.sessiontracker.services;

import com.example.sessiontracker.dto.SimpleSession;
import com.example.sessiontracker.repositories.SimpleSessionRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class SessionServiceImplTest {
    @Mock
    SimpleSessionRepo simpleSessionRepo;

    @InjectMocks
    AnonSessionServiceImpl sessionService ;

    @Test
    public void test(){
        LocalTime start = LocalTime.ofSecondOfDay(0);
        LocalTime end = LocalTime.ofSecondOfDay(10);
        SimpleSession session = new SimpleSession(start,end);
        Mockito.when(simpleSessionRepo.save(session)).thenReturn(session);
        assertEquals(session,sessionService.createAndSaveSession(start,end));
        Mockito.verify(simpleSessionRepo,Mockito.times(1)).save(session);
    }
}