import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class HumanPlayer extends Player implements KeyboardHandler{
    private Keyboard keyboard;
    private String direction = "up";

    public HumanPlayer(Background background, Color color, int[] coordinates) {
        super(background, color, coordinates);
        keyboard = new Keyboard(this);

        init();
    }

    @Override
    public void move(Background background) {
        switch (getDirection()){
            case "up":
                if((this.getPos().getRow() - 1) >= 0) {
                    this.getPos().moveUp(1, background.getCellSize());
                }
                break;
            case "down":
                if((this.getPos().getRow() + 1) < background.getRows()) {
                    this.getPos().moveDown(1, background.getCellSize());
                }
                break;
            case "right":
                if((this.getPos().getCol() + 1) < background.getCols()) {
                    this.getPos().moveRight(1, background.getCellSize());
                }
                break;
            case "left":
                if((this.getPos().getCol() - 1) >= 0) {
                    this.getPos().moveLeft(1, background.getCellSize());
                }
                break;
        }
        paint(background);
    }

    public void setDirection(String direction){
        this.direction = direction;
    }

    public String getDirection(){
        return direction;
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
    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        if(keyboardEvent.getKey() == KeyboardEvent.KEY_UP){
            setDirection("up");
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
