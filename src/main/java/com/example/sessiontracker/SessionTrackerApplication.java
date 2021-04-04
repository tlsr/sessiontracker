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

/*    @Override
    public void run(String... args) throws Exception {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Enter command");
            String command = sc.nextLine();
            switch (command) {
                case "START":
                    sessionProcessor.start();
                    break;
                case "STOP":
                    sessionProcessor.stop();
                    break;
            }
        }
    }*/
}
