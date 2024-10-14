package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MusicPlayer {
    @Value("${musicPlayer.name}")
    private String name;
    @Value("${musicPlayer.volume}")
    private int volume;

    public String getName() {
        return name;
    }

    public int getVolume() {
        return volume;
    }

    private Music music1;
    private Music music2;


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

    public void playMusic(Music music1, Music music2) {
        System.out.println("Playing: " + music1.getSong());
        System.out.println("Playing: " + music2.getSong());
    }
}
