package com.example.sessiontracker.processors;

import com.example.sessiontracker.services.SessionService;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

import static java.time.LocalTime.now;
@Component
@Scope("prototype")
public class AnonSessionProcessorImpl implements SessionProcessor{
    private SessionService sessionService;
    private LocalTime start;
    private LocalTime end;

    public AnonSessionProcessorImpl(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @Override
    public void start() {
        start = now();
    }

    @Override
    public void stop() {
        end = now();
        sessionService.createAndSaveSession(start,end);
    }
}
