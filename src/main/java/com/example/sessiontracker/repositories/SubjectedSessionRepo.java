package com.example.sessiontracker.repositories;

import com.example.sessiontracker.dto.SubjectedSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectedSessionRepo extends JpaRepository<SubjectedSession,Long> {
}
