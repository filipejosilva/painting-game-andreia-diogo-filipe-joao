package org.gamepainting;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class Sound {

    File gameSound = new File(Game.RESOURCES_PREFIX + "sound-test.wav");

    public void playSound() {
        try{
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(gameSound));
            clip.start();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void stopSound() {
        try{
            Clip clip = AudioSystem.getClip();
            clip.stop();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
