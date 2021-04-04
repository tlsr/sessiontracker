package com.example.sessiontracker.controller;

import com.example.sessiontracker.messages.Message;
import org.springframework.stereotype.Component;

@Component
public interface Controller {

    void startSessionProcessor(Message message);
    void stopSessionProcessor(Message message);
}
