import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

abstract class Player {

    protected Position pos;
    protected Color color;

    public Player(Background background, Color color, int[] coordinates) {
        this.pos = new Position(background, color, coordinates);
        this.color = color;
    }

    void move(Background background) {
    }

    public void paint(Background background) {
        background.paintPosition(getPos().getCol(), getPos().getRow(), color);
    }

    public Position getPos() {
        return pos;
    }
}
