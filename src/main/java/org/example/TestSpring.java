package org.example;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml"
        );
        Music classicalMusic = context.getBean("classicalMusic", Music.class);
        Music rockMusic = context.getBean("rockMusic", Music.class);
        Music rapMusic = context.getBean("rapMusic", Music.class);
        MusicPlayer firstPlayer = new MusicPlayer(classicalMusic);
        MusicPlayer secondPlayer = new MusicPlayer(rockMusic);
        MusicPlayer thirdPlayer = new MusicPlayer(rapMusic);

        firstPlayer.playMusic();
        secondPlayer.playMusic();
        thirdPlayer.playMusic();

        context.close();
    }
}