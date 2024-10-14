package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

public class MusicPlayer {
    @Value("${musicPlayer.name}")
    private String name;
    @Value("${musicPlayer.volume}")
    private int volume;
    private List<Music> musicList;

    public String getName() {
        return name;
    }

    public int getVolume() {
        return volume;
    }

    public List<Music> getMusicList() {
        return musicList;
    }


    public MusicPlayer(List<Music> musicList) {
        this.musicList = musicList;
    }

    public void playMusic(List<Music> musicList) {
        Random random = new Random();

        int randomIndex = random.nextInt(musicList.size());
        Music music = musicList.get(randomIndex);
        System.out.println("Playing: " + music.getSong());
    }
}
