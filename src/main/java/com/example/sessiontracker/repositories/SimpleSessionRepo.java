package com.example.sessiontracker.repositories;

import com.example.sessiontracker.dto.SimpleSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SimpleSessionRepo extends JpaRepository<SimpleSession,Long> {
}
