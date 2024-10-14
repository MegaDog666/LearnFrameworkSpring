package org.example;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RockMusic implements Music {
    public String[] listMusic = {"Rock", "Jazz", "Classic"};

    @Override
    public String getSong() {
        Random random = new Random();
        return listMusic[random.nextInt(listMusic.length)];
    }
}
