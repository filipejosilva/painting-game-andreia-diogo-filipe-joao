
import org.gamepainting.Background;
import org.gamepainting.Game;
import org.academiadecodigo.simplegraphics.graphics.Canvas;
import org.gamepainting.Images;
import org.gamepainting.MouseLogic;
import org.gamepainting.Player.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        //Canvas.setMaxX(1490);
        //Canvas.setMaxY(790);

        Canvas.setMaxX(1014);
        Canvas.setMaxY(758);


       Background background = new Background();
       Game game = new Game(background, 40);//delay 50

       /*MouseLogic mouseLogic = new MouseLogic();
       Images images = new Images(background);
       mouseLogic.setButtons(images.getPlayButton(),images.getExitButton());*/

        game.init();
        game.start();


    }
}