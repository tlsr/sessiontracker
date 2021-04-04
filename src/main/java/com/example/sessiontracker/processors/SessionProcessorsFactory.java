package com.example.sessiontracker.processors;

import com.example.sessiontracker.messages.Message;
import org.springframework.stereotype.Component;

@Component
public interface SessionProcessorsFactory {
    SessionProcessor createSessionProcessor(Message message);
}
