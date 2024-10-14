package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.Arrays;
import java.util.List;

@Configuration
@PropertySource("classpath:musicPlayer.properties")
public class SpringConfig {
    @Bean
    public ClassicalMusic classicalMusic() {
        return new ClassicalMusic();
    }
    @Bean
    public RockMusic rockMusic() {
        return new RockMusic();
    }
    @Bean
    public RapMusic rapMusic() {
        return new RapMusic();
    }
    @Bean
    Computer computer(MusicPlayer musicPlayer) {
        return new Computer(musicPlayer);
    }
    @Bean
    public List<Music> musicList() {
        return Arrays.asList(rockMusic(), classicalMusic(), rapMusic());
    }

    @Bean
    public MusicPlayer musicPlayer(List<Music> MusicList) {
        return new MusicPlayer(MusicList);
    }

}
