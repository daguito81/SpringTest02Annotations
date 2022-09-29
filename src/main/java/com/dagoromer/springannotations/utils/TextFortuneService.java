package com.dagoromer.springannotations.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class TextFortuneService implements FortuneService {

    private String[] possibleFortunes;
    private final Random rng = new Random();

    @Value("possibleFortunes.txt")
    private String possibleFortunesFilePath;

    @PostConstruct
    public void setPossibleFortunes() {

        List<String> lines = new ArrayList<>();
        String line;

        try (FileReader fileReader =
                     new FileReader(ResourceUtils.getFile(
                             "classpath:" + possibleFortunesFilePath));
             BufferedReader buffer = new BufferedReader(fileReader)) {
            while ((line = buffer.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.possibleFortunes = lines.toArray(new String[0]);
    }

    @Override
    public String getDailyFortune() {
        return possibleFortunes[rng.nextInt(possibleFortunes.length)];
    }
}
