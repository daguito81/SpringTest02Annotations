package com.dagoromer.springannotations.utils;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomWorkoutService implements WorkoutService{
    private final String[] possibleWorkouts = {
            "Practice your forehand for 30 minutes",
            "Practice Serving for 1 hour",
            "Practice your backhand for 15 minutes",
    };
    private final Random rng = new Random();


    @Override
    public String getDailyWorkout() {
        return possibleWorkouts[rng.nextInt(possibleWorkouts.length)];
    }
}
