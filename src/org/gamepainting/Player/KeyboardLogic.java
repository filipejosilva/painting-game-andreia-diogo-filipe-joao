package org.gamepainting.Player;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class KeyboardLogic implements KeyboardHandler {

    private Keyboard keyboard;
    private HumanPlayer humanPlayer;
    KeyboardEvent right;
    KeyboardEvent right1;
    KeyboardEvent left;
    KeyboardEvent left1;
    KeyboardEvent down;
    KeyboardEvent down1;
    KeyboardEvent up;
    KeyboardEvent up1;
    KeyboardEvent space;

    public KeyboardLogic(){
        keyboard = new Keyboard(this);
        init();
    }

    public void init(){
        //right
        right = new KeyboardEvent();
        right.setKey(KeyboardEvent.KEY_D);
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(right);

        right1 = new KeyboardEvent();
        right1.setKey(KeyboardEvent.KEY_RIGHT);
        right1.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(right1);


        //left
        left = new KeyboardEvent();
        left.setKey(KeyboardEvent.KEY_A);
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(left);

        left1 = new KeyboardEvent();
        left1.setKey(KeyboardEvent.KEY_LEFT);
        left1.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(left1);


        //Down
        down = new KeyboardEvent();
        down.setKey(KeyboardEvent.KEY_S);
        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(down);

        down1 = new KeyboardEvent();
        down1.setKey(KeyboardEvent.KEY_DOWN);
        down1.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(down1);

        //Up
        up = new KeyboardEvent();
        up.setKey(KeyboardEvent.KEY_W);
        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(up);

        up1 = new KeyboardEvent();
        up1.setKey(KeyboardEvent.KEY_UP);
        up1.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(up1);

        //Space
        space = new KeyboardEvent();
        space.setKey(KeyboardEvent.KEY_SPACE);
        space.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(space);
    }

    public void setPlayer(HumanPlayer humanPlayer){
        this.humanPlayer = humanPlayer;
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        if(humanPlayer.isStunned()) {
            humanPlayer.stunnedCount--;
            if(humanPlayer.stunnedCount == 0) {
                humanPlayer.stunned = false;
            }

        } else {
            //Right
            if(keyboardEvent.getKey() == keyboardEvent.KEY_D || keyboardEvent.getKey() == keyboardEvent.KEY_RIGHT){
                humanPlayer.moveRight(humanPlayer.multiplier);
            }

            //left
            if(keyboardEvent.getKey() == keyboardEvent.KEY_A || keyboardEvent.getKey() == keyboardEvent.KEY_LEFT){
                humanPlayer.moveLeft(humanPlayer.multiplier);
            }

            //Up
            if(keyboardEvent.getKey() == keyboardEvent.KEY_W || keyboardEvent.getKey() == keyboardEvent.KEY_UP){
                humanPlayer.moveUp(humanPlayer.multiplier);
            }

            //Down
            if(keyboardEvent.getKey() == keyboardEvent.KEY_S || keyboardEvent.getKey() == keyboardEvent.KEY_DOWN){
                humanPlayer.moveDown(humanPlayer.multiplier);
            }

            //Space cheat
            if(keyboardEvent.getKey() == keyboardEvent.KEY_SPACE){
                humanPlayer.setSpeed();
            }
        }
    }

    public void keyboardStopped(){
        keyboard.removeEventListener(right);
        keyboard.removeEventListener(right1);
        keyboard.removeEventListener(left);
        keyboard.removeEventListener(left1);
        keyboard.removeEventListener(up);
        keyboard.removeEventListener(up1);
        keyboard.removeEventListener(down);
        keyboard.removeEventListener(down1);
    }
    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
