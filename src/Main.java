import org.academiadecodigo.simplegraphics.graphics.Canvas;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Main {
    public static void main(String[] args) {
        Canvas.setMaxX(1490);
        Canvas.setMaxY(790);

        Rectangle background = new Rectangle(0,0,1500,800);
        //background.draw();
        background.setColor(Color.GRAY);
        background.fill();

        KeyboardLogic keyboardLogic = new KeyboardLogic();
        Player player = new Player(background);
        keyboardLogic.setPlayer(player);

    }
}