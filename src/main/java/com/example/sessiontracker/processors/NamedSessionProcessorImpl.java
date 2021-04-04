package com.example.sessiontracker.processors;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class NamedSessionProcessorImpl implements SessionProcessor{
    private String subject;

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }
}
