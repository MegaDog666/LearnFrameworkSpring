package org.example;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class ClassicalMusic implements Music {
    static String[] listMusic = {"Hungarian Rhapsody", "Moonlight Sonata", "The Magic Flute"};
    @Override
    public String getSong() {
        Random random = new Random();
        return listMusic[random.nextInt(listMusic.length)];
    }
}
