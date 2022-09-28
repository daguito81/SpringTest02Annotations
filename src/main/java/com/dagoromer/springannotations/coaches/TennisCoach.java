package com.dagoromer.springannotations.coaches;

import com.dagoromer.springannotations.utils.FortuneService;
import com.dagoromer.springannotations.utils.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


// You can leave @Component blank and the default name will be the class name with first letter lowered
// Or you can specify the name explicitly
@Component("tennisCoach")
public class TennisCoach implements Coach {
    // This dependency will be autowired from a @Component that implements FortuneService
    private final FortuneService fortuneService;

    @Autowired
    public void setWorkoutService(WorkoutService workoutService) {
        this.workoutService = workoutService;
    }

    private WorkoutService workoutService;

    @Autowired
    public TennisCoach(FortuneService theFortuneService) {
        this.fortuneService = theFortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return workoutService.getDailyWorkout();
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getDailyFortune();
    }
}
