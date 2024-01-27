import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Background {
    //grid

    public static final int PADDING = 10;
    private int cellSize = 10;
    private int cols;
    private int rows;
    private Rectangle[][] tableBackground;

    public Background(int cols, int rows) {
        this.cols = cols;
        this.rows = rows;
    }
    public void init() {
        Rectangle field = new Rectangle(PADDING, PADDING, cols * cellSize, rows * cellSize);
        field.setColor(Color.WHITE);
        field.fill();

        //table to help with the painting movement;
        tableBackground = new Rectangle[this.cols][this.rows];
        for(int i= 0; i < tableBackground.length; i++) {
            for(int j = 0; j < tableBackground[i].length; j++) {
                tableBackground[i][j] = new Rectangle(columnToX(i), rowToY(j), cellSize, cellSize);
                tableBackground[i][j].setColor(Color.LIGHT_GRAY);
                tableBackground[i][j].fill();

            }
        }
    }

    public void paintPosition(int col, int row, Color color) {
        tableBackground[col][row].setColor(color);
    }

    public int getCellSize() {
        return cellSize;
    }

    public int getCols() {
        return cols;
    }

    public int getRows() {
        return rows;
    }

    public int rowToY(int row) {
        return PADDING + cellSize * row;
    }

    public int columnToX(int column) {
        return PADDING + cellSize * column;
    }

}
