package com.example.sessiontracker.controller;

import com.example.sessiontracker.messages.Message;
import com.example.sessiontracker.processors.SessionProcessor;
import com.example.sessiontracker.processors.SessionProcessorsFactory;
import org.springframework.stereotype.Component;
import java.util.Map;

@Component
public class ControllerImpl implements Controller{
    private final SessionProcessorsFactory sessionProcessorsFactory;
    private Map<String, SessionProcessor> sessionProcessorStorage;

    public ControllerImpl(SessionProcessorsFactory sessionProcessorsFactory) {
        this.sessionProcessorsFactory = sessionProcessorsFactory;
    }

    @Override
    public void startSessionProcessor(Message message) {
        SessionProcessor sessionProcessor = sessionProcessorsFactory.createSessionProcessor(message);
        sessionProcessor.start();
        String userName = message.getName();
        sessionProcessorStorage.put(userName,sessionProcessor);
    }

    @Override
    public void stopSessionProcessor(Message message) {
        String userName = message.getName();
        SessionProcessor sessionProcessor = sessionProcessorStorage.remove(userName);
        sessionProcessor.stop();
    }
}
