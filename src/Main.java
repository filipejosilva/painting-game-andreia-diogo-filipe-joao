
import org.gamepainting.Background;
import org.gamepainting.Game;
import org.academiadecodigo.simplegraphics.graphics.Canvas;
import org.gamepainting.Player.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Canvas.setMaxX(1490);
        Canvas.setMaxY(790);

       Background background = new Background();

        Game game = new Game(background, 30); //delay 50

        game.init();
        game.start();


    }
}