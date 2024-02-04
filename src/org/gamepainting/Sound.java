package org.gamepainting;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import java.io.File;

public class Sound {

    private Clip clip;
    File gameSound = new File(Game.RESOURCES_PREFIX + "sound-test.wav");

    public void playSound() {
        try{
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(gameSound));
            clip.start();
            volumeDown();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void stopSound() {
        try{
            clip.stop();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void volumeDown(){
        FloatControl volumeDown = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        volumeDown.setValue(-30.0f);;
    }
}
