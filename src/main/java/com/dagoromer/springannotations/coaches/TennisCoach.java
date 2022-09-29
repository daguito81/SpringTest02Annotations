package com.dagoromer.springannotations.coaches;

import com.dagoromer.springannotations.utils.FortuneService;
import com.dagoromer.springannotations.utils.MessageService;
import com.dagoromer.springannotations.utils.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


// You can leave @Component blank and the default name will be the class name with first letter lowered
// Or you can specify the name explicitly
@Component("tennisCoach") // Constructor Dependency Injection
@Scope("prototype")
public class TennisCoach implements Coach {
    // This dependency will be autowired from a @Component that implements FortuneService
    private final FortuneService fortuneService;

    @SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
    @Autowired // Field Injector
    private MessageService messageService;

    @Value("${prop.email}")
    public void setCoachEmail(String coachEmail) {
        this.coachEmail = coachEmail;
    }

    @Value("${prop.team}")
    public void setCoachTeam(String coachTeam) {
        this.coachTeam = coachTeam;
    }

    // Setting up properties from a file
    private String coachEmail;
    private String coachTeam;

    @Autowired //Setter Injector
    public void setWorkoutService(WorkoutService workoutService) {
        this.workoutService = workoutService;
    }

    private WorkoutService workoutService;

    @Autowired // Constructor Injector
    public TennisCoach(@Qualifier("textFortuneService") FortuneService theFortuneService) {
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

    @PostConstruct
    public void startComponent() {
        System.out.println("This is starting container: " + this.getClass() + " @ " + this.hashCode());
    }
    // PreDestroy doesn't run in the case of 'prototype' scopes
    @PreDestroy
    public void killComponent() {
        System.out.println("This is destroying the instance: " + this.hashCode());
    }

    @Override
    public String toString() {
        return "TennisCoach{" +
                "coachEmail='" + coachEmail + '\'' +
                ", coachTeam='" + coachTeam + '\'' +
                '}';
    }
}
