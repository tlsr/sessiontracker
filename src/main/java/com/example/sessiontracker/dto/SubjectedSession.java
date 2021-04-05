package com.example.sessiontracker.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalTime;

@Entity
@EqualsAndHashCode
@Getter
@NoArgsConstructor
public class SubjectedSession extends SimpleSession {
    @Column(name = "subject")
    private String subject;

    public SubjectedSession(LocalTime start,LocalTime end,String subject){
        super(start,end);
        this.subject=subject;
    }
}
