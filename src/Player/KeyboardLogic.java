package Player;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class KeyboardLogic implements KeyboardHandler {

    private Keyboard keyboard;
    private HumanPlayer humanPlayer;

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

        //left
        KeyboardEvent left = new KeyboardEvent();
        left.setKey(KeyboardEvent.KEY_A);
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(left);

        //Down
        KeyboardEvent down = new KeyboardEvent();
        down.setKey(KeyboardEvent.KEY_S);
        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(down);

        //Up
        KeyboardEvent up = new KeyboardEvent();
        up.setKey(KeyboardEvent.KEY_W);
        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(up);
    }

    public void setPlayer(HumanPlayer humanPlayer){
        this.humanPlayer = humanPlayer;
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        //Right
        if(keyboardEvent.getKey() == keyboardEvent.KEY_D){
            humanPlayer.moveRight();
        }

        //left
        if(keyboardEvent.getKey() == keyboardEvent.KEY_A){
            humanPlayer.moveLeft();
        }

        //Up
        if(keyboardEvent.getKey() == keyboardEvent.KEY_W){
            humanPlayer.moveUp();
        }

        //Down
        if(keyboardEvent.getKey() == keyboardEvent.KEY_S){
            humanPlayer.moveDown();
        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
