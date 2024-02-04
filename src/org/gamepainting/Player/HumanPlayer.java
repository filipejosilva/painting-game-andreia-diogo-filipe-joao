package org.gamepainting.Player;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.gamepainting.Background;
import org.gamepainting.Game;

import java.util.ArrayList;

public class HumanPlayer extends Player {

    static KeyboardLogic keyboard;
    public HumanPlayer(Background background, int x, int y, Color color, String picture){
        super(background, x, y, color, picture);
        keyboard = new KeyboardLogic();
        keyboard.setPlayer(this);
    }

    public static void stopKeyboard(){
        keyboard.keyboardStopped();
    }
}
