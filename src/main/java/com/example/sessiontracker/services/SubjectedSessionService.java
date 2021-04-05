package com.example.sessiontracker.services;

import com.example.sessiontracker.dto.SubjectedSession;
import com.example.sessiontracker.repositories.SubjectedSessionRepo;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
public class SubjectedSessionService {
    SubjectedSessionRepo subjectedSessionRepo;

    public SubjectedSessionService(SubjectedSessionRepo subjectedSessionRepo) {
        this.subjectedSessionRepo = subjectedSessionRepo;
    }

    public void createAndSaveSubjectedSession(LocalTime start,LocalTime end,String subject){
        SubjectedSession subjectedSession = new SubjectedSession(start,end,subject);
        subjectedSessionRepo.save(subjectedSession);
    }
}
