package com.example.sessiontracker.processors;

import com.example.sessiontracker.messages.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SessionProcessorsFactoryImpl implements SessionProcessorsFactory{
    @Autowired
    private AnonSessionProcessorImpl anonSessionProcessor;
    @Autowired
    private NamedSessionProcessorImpl namedSessionProcessor;

    @Override
    public SessionProcessor createSessionProcessor(Message message) {
        if(message.getSubject().isEmpty()){
            return anonSessionProcessor;
        }else{
            return namedSessionProcessor;
        }
    }

}
