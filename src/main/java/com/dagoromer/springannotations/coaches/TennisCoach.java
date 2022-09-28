package com.dagoromer.springannotations.coaches;

import com.dagoromer.springannotations.utils.FortuneService;
import com.dagoromer.springannotations.utils.MessageService;
import com.dagoromer.springannotations.utils.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


// You can leave @Component blank and the default name will be the class name with first letter lowered
// Or you can specify the name explicitly
@Component("tennisCoach") // Constructor Dependency Injection
public class TennisCoach implements Coach {
    // This dependency will be autowired from a @Component that implements FortuneService
    private final FortuneService fortuneService;

    @Autowired // Field Injector
    private MessageService messageService;


    @Autowired //Setter Injector
    public void setWorkoutService(WorkoutService workoutService) {
        System.out.println("Inside the Setter");
        this.workoutService = workoutService;
    }

    private WorkoutService workoutService;

    @Autowired // Constructor Injector
    public TennisCoach(FortuneService theFortuneService) {
        System.out.println("Inside the Constructor");
        this.fortuneService = theFortuneService;
    }

    @Override
    public String getDailyMessage() {
        return messageService.getDailyMessage();
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
