package com.dagoromer.springannotations.utils;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomFortuneService implements FortuneService{
    private final String[] possibleFortunes = {
            "Today is a Horrible Day",
            "Today is meh!",
            "Today is your lucky day! Time to seize it!",
    };
    private final Random rng = new Random();

    @Override
    public String getDailyFortune() {
        return possibleFortunes[rng.nextInt(possibleFortunes.length)];
    }
}

