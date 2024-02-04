
import org.academiadecodigo.simplegraphics.graphics.Canvas;
import org.gamepainting.MouseLogic;
import org.gamepainting.Windows.CurrentWindow;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {

        Canvas.setMaxX(1014);
        Canvas.setMaxY(758);


        //Background background = new Background();
        //Game game = new Game(background, 40);//delay 50
        //game.start();

        CurrentWindow currentWindow = new CurrentWindow();
        MouseLogic mouse = new MouseLogic();
        /*double i = 0;
        while(i < 3000000000.0){
            i++;
        }
        currentWindow.changeScreen();*/

        mouse.setButtons(currentWindow.getWindow().getPlayButton(), currentWindow.getWindow().getExitButton(), currentWindow.getWindow());
        //mouse.setGame(game);

    }
}
