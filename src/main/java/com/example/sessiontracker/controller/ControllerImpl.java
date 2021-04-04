package com.example.sessiontracker.controller;

import com.example.sessiontracker.messages.Message;
import com.example.sessiontracker.processors.SessionProcessor;
import com.example.sessiontracker.processors.SessionProcessorsFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ControllerImpl implements Controller{
    private final SessionProcessorsFactory sessionProcessorsFactory;
    private Map<String, SessionProcessor> sessionProcessorStorage;

    public ControllerImpl(SessionProcessorsFactory sessionProcessorsFactory) {
        this.sessionProcessorsFactory = sessionProcessorsFactory;
        sessionProcessorStorage = new HashMap<>();
    }

    @Override
    public void startSessionProcessor(Message message) {
        String userName = message.getName();
        if(!sessionProcessorStorage.containsKey(userName)) {
            SessionProcessor sessionProcessor = sessionProcessorsFactory.createSessionProcessor(message);
            sessionProcessor.start();
            sessionProcessorStorage.put(userName, sessionProcessor);
        }else throw new IllegalArgumentException("Such user performing task already");
    }

    @Override
    public void stopSessionProcessor(Message message) {
        String userName = message.getName();
        if(sessionProcessorStorage.containsKey(userName)) {
            SessionProcessor sessionProcessor = sessionProcessorStorage.remove(userName);
            sessionProcessor.stop();
        }else throw new IllegalArgumentException("No active task for this user");
    }
}
