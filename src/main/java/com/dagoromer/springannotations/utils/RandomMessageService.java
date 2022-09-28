package com.dagoromer.springannotations.utils;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomMessageService implements MessageService{
    private final String[] possibleMessages = {
            "You go Team!",
            "Let's give it our all!",
            "Remember to have fun!",
    };
    private final Random rng = new Random();

    @Override
    public String getDailyMessage() {
        return possibleMessages[rng.nextInt(possibleMessages.length)];
    }
}
