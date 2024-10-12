package org.example;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml"
        );

        ClassicalMusic classicalMusic = context.getBean("musicBean", ClassicalMusic.class);
        System.out.println(classicalMusic.getSong());

//        Music music = context.getBean("musicBean", Music.class);
//        MusicPlayer player = new MusicPlayer(music);
//
//        MusicPlayer firstPlayer = context.getBean("musicPlayer", MusicPlayer.class);
//        MusicPlayer secondPlayer = context.getBean("musicPlayer", MusicPlayer.class);
//
//        boolean result = firstPlayer == secondPlayer;
//        System.out.println("Is firstPlayer == secondPlayer? " + result);
//
//        System.out.println(firstPlayer);
//        System.out.println(secondPlayer);
//
//        firstPlayer.setVolume(10);
//        System.out.println(firstPlayer.getVolume());
//        System.out.println(secondPlayer.getVolume());

        context.close();
    }
}
