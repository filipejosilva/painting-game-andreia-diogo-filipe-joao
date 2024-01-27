import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class KeyboardLogic implements KeyboardHandler {

    private Keyboard keyboard;
    private Player player;

    private String direction;
    public KeyboardLogic(Player player){
        keyboard = new Keyboard(this);
        this.player = player;
        init();
    }

    public void init(){

        //Right
        KeyboardEvent right = new KeyboardEvent();
        right.setKey(KeyboardEvent.KEY_RIGHT);
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(right);

        //Left
        KeyboardEvent left = new KeyboardEvent();
        left.setKey(KeyboardEvent.KEY_LEFT);
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(left);

        //Down
        KeyboardEvent down = new KeyboardEvent();
        down.setKey(KeyboardEvent.KEY_DOWN);
        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(down);

        //Up
        KeyboardEvent up = new KeyboardEvent();
        up.setKey(KeyboardEvent.KEY_UP);
        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(up);


    }
    public void setDirection(String direction){
        this.direction = direction;
    }
    public String getDirection(){
        return direction;
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        if(keyboardEvent.getKey() == KeyboardEvent.KEY_UP){
            //player.move();
        }
        if(keyboardEvent.getKey() == KeyboardEvent.KEY_DOWN){
            setDirection("down");
            System.out.println("down");
        }
        if(keyboardEvent.getKey() == KeyboardEvent.KEY_LEFT){
            setDirection("left");
            System.out.println("left");
        }
        if(keyboardEvent.getKey() == KeyboardEvent.KEY_RIGHT){
            setDirection("right");
            System.out.println("right");
        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
