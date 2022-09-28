package com.dagoromer.springannotations.coaches;

import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Practice pitching 50 times";
    }

    @Override
    public String getDailyFortune() {
        return null;
    }

    @Override
    public String getDailyMessage() {
        return null;
    }
}
