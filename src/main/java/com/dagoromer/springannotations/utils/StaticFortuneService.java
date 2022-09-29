package com.dagoromer.springannotations.utils;

import org.springframework.stereotype.Component;

@Component
public class StaticFortuneService implements FortuneService{
    @Override
    public String getDailyFortune() {
        return "This is a static Fortune";
    }
}
