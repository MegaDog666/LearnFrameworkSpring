package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MusicPlayer {
    private Music music1;
    private Music music2;

    enum MusicStyles
    {
        CLASSICAL,
        ROCK
    }

//    @Autowired
//    public MusicPlayer(@Qualifier("rockMusic") Music music1,
//                       @Qualifier("classicalMusic") Music music2) {
//        this.music1 = music1;
//        this.music2 = music2;
//    }

    @Autowired
    public void setMusic1(@Qualifier("rockMusic") Music music1) {
        this.music1 = music1;
    }

    @Autowired
    public void setMusic2(@Qualifier("classicalMusic") Music music2) {
        this.music2 = music2;
    }

    public void playMusic(MusicStyles musicStyles) {
        switch (musicStyles) {
            case CLASSICAL -> System.out.println("Playing classical music: " + music2.getSong());
            case ROCK -> System.out.println("Playing rock music: " + music1.getSong());
            default -> System.out.println("Error");
        }
    }
}
