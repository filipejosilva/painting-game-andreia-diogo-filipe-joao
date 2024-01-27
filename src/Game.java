import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;

public class Game {

    private Background background;
    private Player[] players;
    private int numberOfPlayers = 4;
    //delay for the animation
    private int delay;

    public Game(int cols, int rows, int delay) {
        this.background = new Background(cols,rows);
        this.delay = delay;
    }

    public void init() {
        background.init();


        players = new Player[numberOfPlayers];
        //human goes to index zero
        players[0] = PlayerFactory.getNewHumanPlayer(background, Color.BLUE, initialPosition(background, 0));
        System.out.println("test to see if the human player was created.");
        KeyboardLogic keyboard = new KeyboardLogic(players[0]);

        //AIPlayers start in index 1
        for (int i = 1; i < players.length; i++) {
            players[i] = PlayerFactory.getNewAIPlayer(background, setColor(i), initialPosition(background, i));
            System.out.println("test to see if the AI player was created.");
        }
    }

    public void start() throws InterruptedException {

        while (true) {

            // Pause for a while
            Thread.sleep(delay);

            //players[0].move(background);
            movePlayers();
        }

    }

    //set color to the AIPlayer
    public Color setColor(int indexAIPlayer) {

        Color color;
        switch (indexAIPlayer) {
            case 1:
                color = Color.YELLOW;
                break;
            case 2:
                color = Color.GREEN;
                break;
            case 3:
                color = Color.RED;
                break;
            default:
                color = Color.YELLOW;
                break;
        }
        return color;
    }
    public void movePlayers() {
        for (int i = 0; i < players.length; i++) {
            players[i].move(background);
        }
    }

    //defines initial position for all Players
    public int[] initialPosition(Background background, int indexPlayer) {
        //to find the center position so all players have the same distance from center
        int[] coordinates = new int[2]; //takes y and x positions
        int centerY = background.getRows()/2;
        int centerX = background.getCols()/2;

        switch (indexPlayer) {
            case 0:
                coordinates[0] = centerX - 4;
                coordinates[1] = centerY - 4;
                break;
            case 1:
                coordinates[0] = centerX + 4;
                coordinates[1] = centerY + 4;
                break;
            case 2:
                coordinates[0] = centerX - 4;
                coordinates[1] = centerY + 4;
                break;
            case 3:
                coordinates[0] = centerX + 4;
                coordinates[1] = centerY - 4;
                break;
        }
        return coordinates;
    }
}
