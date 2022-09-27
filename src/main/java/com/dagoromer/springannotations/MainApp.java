package com.dagoromer.springannotations;

import com.dagoromer.springannotations.coaches.Coach;
import com.dagoromer.springannotations.coaches.TennisCoach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        Coach theCoach = context.getBean("tennisCoach", Coach.class);

        System.out.println(theCoach.getDailyWorkout());
        System.out.println(theCoach);

        context.close();

    }
}
