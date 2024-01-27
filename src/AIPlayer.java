import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import java.util.Random;

public class AIPlayer extends Player {

    public AIPlayer(Background background, Color color, int[] coordinates) {
        super(background, color, coordinates);
    }

    @Override
    public void move(Background background) {
        Random rand = new Random();
        int randomValue = rand.nextInt(4);
        switch(randomValue) {
            case 0:
                if((this.getPos().getCol() + 1) < background.getCols()) {
                    this.getPos().moveRight(1, background.getCellSize());
                }
                break;
            case 1:
                if((this.getPos().getRow() - 1) >= 0) {
                    this.getPos().moveUp(1, background.getCellSize());
                }
                break;
            case 2:
                if((this.getPos().getCol() - 1) >= 0) {
                    this.getPos().moveLeft(1, background.getCellSize());
                }
                break;
            case 3:
                if((this.getPos().getRow() + 1) < background.getRows()) {
                    this.getPos().moveDown(1, background.getCellSize());
                }
                break;
        }
        paint(background); //paint is in Player
    }
}
