package com.example.sessiontracker.services;

import com.example.sessiontracker.dto.SimpleSession;
import com.example.sessiontracker.repositories.SimpleSessionRepo;
import org.springframework.stereotype.Service;
import java.time.LocalTime;

@Service
public class AnonSessionServiceImpl implements SessionService {
    private final SimpleSessionRepo simpleSessionRepo;

    public AnonSessionServiceImpl(SimpleSessionRepo simpleSessionRepo) {
        this.simpleSessionRepo = simpleSessionRepo;
    }

    @Override
    public SimpleSession createAndSaveSession(LocalTime start, LocalTime end) {
        SimpleSession session = new SimpleSession(start,end);
        return simpleSessionRepo.save(session);
    }
}
