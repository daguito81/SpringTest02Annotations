package com.dagoromer.springannotations.utils;


//@Component
public class HappyFortuneService implements FortuneService{
    @Override
    public String getDailyFortune() {
        return "This is a Happy Fortune!";
    }
}
