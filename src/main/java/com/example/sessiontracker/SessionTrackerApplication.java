package com.example.sessiontracker;

import com.example.sessiontracker.processors.SessionProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class SessionTrackerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SessionTrackerApplication.class, args);
    }

}
