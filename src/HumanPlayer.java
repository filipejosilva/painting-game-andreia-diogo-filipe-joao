import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class HumanPlayer extends Player {
    public HumanPlayer(Background background, Color color, int[] coordinates) {
        super(background, color, coordinates);
    }

    @Override
    public void move(Background background) {
        //logic from the keyboard
        //in the end of keyboard logic, we need to call paint(background) as in AIPlayer
    }

}
