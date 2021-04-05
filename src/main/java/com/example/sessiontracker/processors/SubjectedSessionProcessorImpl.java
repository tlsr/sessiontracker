package com.example.sessiontracker.processors;

import com.example.sessiontracker.services.SessionService;
import com.example.sessiontracker.services.SubjectedSessionService;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

import static java.time.LocalTime.now;

@Component
@Scope("prototype")
public class SubjectedSessionProcessorImpl implements SessionProcessor{
    @Setter
    private String subject;
    private SubjectedSessionService subjectedSessionService;
    private LocalTime start;
    private LocalTime end;

    public SubjectedSessionProcessorImpl(SubjectedSessionService subjectedSessionService) {
        this.subjectedSessionService = subjectedSessionService;
    }

    @Override
    public void start() {
        start = now();
    }

    @Override
    public void stop() {
        end = now();
        subjectedSessionService.createAndSaveSubjectedSession(start,end,subject);
    }
}
