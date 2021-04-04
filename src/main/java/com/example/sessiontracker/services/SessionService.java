package com.example.sessiontracker.services;

import com.example.sessiontracker.dto.SimpleSession;

import java.time.LocalTime;
import java.time.temporal.Temporal;

public interface SessionService {

    SimpleSession createAndSaveSession(LocalTime start, LocalTime end);
}
