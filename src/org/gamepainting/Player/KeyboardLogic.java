package org.gamepainting.Player;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class KeyboardLogic implements KeyboardHandler {

    private Keyboard keyboard;
    private Player humanPlayer;

    public KeyboardLogic(){
        keyboard = new Keyboard(this);
        init();
    }

    public void init(){
        //right
        KeyboardEvent right = new KeyboardEvent();
        right.setKey(KeyboardEvent.KEY_D);
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(right);

        KeyboardEvent right1 = new KeyboardEvent();
        right1.setKey(KeyboardEvent.KEY_RIGHT);
        right1.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(right1);


        //left
        KeyboardEvent left = new KeyboardEvent();
        left.setKey(KeyboardEvent.KEY_A);
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(left);

        KeyboardEvent left1 = new KeyboardEvent();
        left1.setKey(KeyboardEvent.KEY_LEFT);
        left1.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(left1);


        //Down
        KeyboardEvent down = new KeyboardEvent();
        down.setKey(KeyboardEvent.KEY_S);
        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(down);

        KeyboardEvent down1 = new KeyboardEvent();
        down1.setKey(KeyboardEvent.KEY_DOWN);
        down1.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(down1);

        //Up
        KeyboardEvent up = new KeyboardEvent();
        up.setKey(KeyboardEvent.KEY_W);
        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(up);

        KeyboardEvent up1 = new KeyboardEvent();
        up1.setKey(KeyboardEvent.KEY_UP);
        up1.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(up1);
    }

    public void setPlayer(Player humanPlayer){
        this.humanPlayer = humanPlayer;
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        //Right
        if(keyboardEvent.getKey() == keyboardEvent.KEY_D || keyboardEvent.getKey() == keyboardEvent.KEY_RIGHT){
            humanPlayer.moveRight();
        }

        //left
        if(keyboardEvent.getKey() == keyboardEvent.KEY_A || keyboardEvent.getKey() == keyboardEvent.KEY_LEFT){
            humanPlayer.moveLeft();
        }

        //Up
        if(keyboardEvent.getKey() == keyboardEvent.KEY_W || keyboardEvent.getKey() == keyboardEvent.KEY_UP){
            humanPlayer.moveUp();
        }

        //Down
        if(keyboardEvent.getKey() == keyboardEvent.KEY_S || keyboardEvent.getKey() == keyboardEvent.KEY_DOWN){
            humanPlayer.moveDown();
        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
