package com.example.sessiontracker.messages;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@AllArgsConstructor
@Getter
public class Message implements Serializable {
    private String name;
    private String subject;
    private Command command;
}
