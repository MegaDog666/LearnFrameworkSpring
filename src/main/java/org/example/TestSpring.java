package org.example;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml"
        );

//        MusicPlayer musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
//        musicPlayer.playMusic();
//        Computer computer = context.getBean("computer", Computer.class);
//        System.out.println(computer);

        MusicPlayer musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
        MusicPlayer.MusicStyles rock = MusicPlayer.MusicStyles.ROCK;
        MusicPlayer.MusicStyles classical = MusicPlayer.MusicStyles.CLASSICAL;
        musicPlayer.playMusic(rock);
        musicPlayer.playMusic(classical);

        context.close();
    }
}