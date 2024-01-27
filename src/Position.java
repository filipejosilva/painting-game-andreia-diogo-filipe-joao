import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Position {

    private int col;
    private int row;
    private Rectangle rectangle;

    public Position(Background background, Color color, int[] coordinates) {
        this.col = coordinates[0];
        this.row = coordinates[1];
        rectangle = new Rectangle(background.columnToX(col),background.rowToY(row), background.getCellSize(), background.getCellSize());
        rectangle.setColor(color);
        rectangle.fill();
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    //random movement to the players
    public void moveRight(int distance, int cellSize) {
        col+= distance;
        rectangle.translate((distance*cellSize),0); //translate moves the rectangle by a given of set of pixels(x and y).
    }

    public void moveLeft(int distance, int cellSize){
        col-= distance;
        rectangle.translate((-distance*cellSize),0);
    }

    public void moveUp(int distance, int cellSize) {
        row-= distance;
        rectangle.translate(0, (-distance*cellSize));
    }

    public void moveDown(int distance, int cellSize) {
        row+=distance;
        rectangle.translate(0, (distance*cellSize));
    }
}
