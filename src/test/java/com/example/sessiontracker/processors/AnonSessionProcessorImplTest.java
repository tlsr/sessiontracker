package com.example.sessiontracker.processors;

import com.example.sessiontracker.services.SessionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class AnonSessionProcessorImplTest {
    @Mock
    SessionService sessionService;
    @InjectMocks
    AnonSessionProcessorImpl anonSessionProcessor;

    @Test
    void stop() {
        anonSessionProcessor.stop();
        Mockito.verify(sessionService).createAndSaveSession(Mockito.any(),Mockito.any());
    }
}