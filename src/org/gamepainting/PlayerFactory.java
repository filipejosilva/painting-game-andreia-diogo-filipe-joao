package org.gamepainting;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.gamepainting.Player.*;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class PlayerFactory {

    public static Player getNewHumanPlayer(Background background, int x, int y, Color color){
        Player humanPlayer = new HumanPlayer(background, x,y, color);
        return humanPlayer;
    }
    public static Player getNewAiPlayer(Background background, int x, int y, Color color){
        Player aiPlayer = new AiPlayer(background, x,y, color);
        return aiPlayer;
    }

}
