package com.example.sessiontracker.processors;

import org.springframework.stereotype.Component;

@Component
public interface SessionProcessor {

    void start();
    void stop();

}
