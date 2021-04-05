package com.example.sessiontracker.liseners;

import com.example.sessiontracker.controller.Controller;
import com.example.sessiontracker.messages.Message;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@EnableRabbit
@Component
@AllArgsConstructor
public class RabbitMqListener {
    Controller controller;

    @RabbitListener(queues = "queue1")
    public void processQueue1(Message message) {
        switch (message.getCommand()){
            case START:
                controller.startSessionProcessor(message);
                break;
            case STOP:
                controller.stopSessionProcessor(message);
                break;
        }
    }
}
