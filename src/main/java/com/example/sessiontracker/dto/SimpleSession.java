package com.example.sessiontracker.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.Duration;
import java.time.LocalTime;

@Getter
@EqualsAndHashCode
@Entity
public class SimpleSession {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "start_session_time")
    private LocalTime start;
    @Column(name = "end_session_time")
    private LocalTime end;
    @Column(name = "duration")
    private Duration duration;

    public SimpleSession() {
    }

    public SimpleSession(LocalTime start, LocalTime end) {
        this.start = start;
        this.end = end;
        this.duration = Duration.between(start,end);
    }

    @Override
    public String toString() {
        return "SimpleSession{" +
                "start=" + start +
                ", end=" + end +
                ", duration=" + duration.toMinutes() +
                '}';
    }
}
