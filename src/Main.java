
import org.gamepainting.Background;
import org.gamepainting.Game;
import org.academiadecodigo.simplegraphics.graphics.Canvas;
import org.gamepainting.Player.*;
import org.gamepainting.Score;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Canvas.setMaxX(1014);
        Canvas.setMaxY(758);


        Background background = new Background();
        Game game = new Game(background, 40);//delay 50



        game.init();
        game.start();


    }
}
