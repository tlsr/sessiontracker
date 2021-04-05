package com.example.sessiontracker.controller;

import com.example.sessiontracker.messages.Command;
import com.example.sessiontracker.messages.Message;
import com.example.sessiontracker.processors.AnonSessionProcessorImpl;
import com.example.sessiontracker.processors.SessionProcessorsFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ControllerImplTest {
    @Mock
    SessionProcessorsFactory sessionProcessorsFactory;
    @InjectMocks
    ControllerImpl controller;

    @Test
    void legalStartSessionProcessor() {
        Message message = new Message("user","", Command.START);
        AnonSessionProcessorImpl mock = mock(AnonSessionProcessorImpl.class);
        when(sessionProcessorsFactory.createSessionProcessor(message)).thenReturn(mock);
        controller.startSessionProcessor(message);
        verify(sessionProcessorsFactory).createSessionProcessor(message);
        verify(mock).start();
    }

    @Test
    void tryStartSessionProcessorWithSameUser() {
        Message message = new Message("user","", Command.START);
        Message message1 = new Message("user","java", Command.START);
        AnonSessionProcessorImpl mock = mock(AnonSessionProcessorImpl.class);
        when(sessionProcessorsFactory.createSessionProcessor(message)).thenReturn(mock);
        controller.startSessionProcessor(message);
        assertThrows(IllegalArgumentException.class,()->controller.startSessionProcessor(message1));
    }

    @Test
    void stopSessionProcessor() {
        Message message = new Message("user","", Command.START);
        AnonSessionProcessorImpl mock = mock(AnonSessionProcessorImpl.class);
        when(sessionProcessorsFactory.createSessionProcessor(message)).thenReturn(mock);
        controller.startSessionProcessor(message);
        controller.stopSessionProcessor(message);
        verify(mock).stop();
    }

    @Test
    void tryStopUnexcitingSessionProcessor() {
        Message message = new Message("user","", Command.START);
        assertThrows(IllegalArgumentException.class,()->controller.stopSessionProcessor(message));
    }
}