import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;

public class PlayerFactory {

    public static Player getNewHumanPlayer(Background background, Color color, int[] coordinates) {
        Player humanPlayer;
        humanPlayer = new HumanPlayer(background, color, coordinates);
        return humanPlayer;
    }

    public static Player getNewAIPlayer(Background background, Color color, int[] coordinates) {
        Player AIplayer;
        AIplayer = new AIPlayer(background, color, coordinates);
        return AIplayer;
    }
}
