package org.gamepainting;

import org.gamepainting.Player.*;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class PlayerFactory {

    public static Player getNewHumanPlayer(Rectangle background, int x, int y){
        Player humanPlayer = new HumanPlayer(background, x,y);
        return humanPlayer;
    }
    public static Player getNewAiPlayer(Rectangle background, int x, int y){
        Player aiPlayer = new AiPlayer(background, x,y);
        return aiPlayer;
    }

}
