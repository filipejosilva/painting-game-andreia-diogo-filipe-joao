import Player.KeyboardLogic;
import org.academiadecodigo.simplegraphics.graphics.Canvas;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import Player.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Canvas.setMaxX(1490);
        Canvas.setMaxY(790);

        Rectangle background = new Rectangle(0,0,1500,800);
        //background.draw();
        background.setColor(Color.GRAY);
        background.fill();

        KeyboardLogic keyboardLogic = new KeyboardLogic();
        HumanPlayer humanPlayer = new HumanPlayer(background, 10, 10);
        keyboardLogic.setPlayer(humanPlayer);

        AiPlayer ai1 = new AiPlayer(background, 750, 450);

        while(true) {

            Thread.sleep(50);
            ai1.move();
        }
    }
}