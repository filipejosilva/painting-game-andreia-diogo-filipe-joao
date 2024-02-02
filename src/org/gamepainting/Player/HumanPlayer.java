package org.gamepainting.Player;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.gamepainting.Background;
import org.gamepainting.Game;

import java.util.ArrayList;

public class HumanPlayer extends Player {

    KeyboardLogic keyboard;
    public HumanPlayer(Background background, int x, int y, Color color, String picture){
        super(background, x, y, color, picture);
        keyboard = new KeyboardLogic();
        keyboard.setPlayer(this);
    }

    @Override
    public Rectangle paint() {
        Rectangle paint = new Rectangle(getPlayer().getX(), getPlayer().getY(), 25,25);
        paint.setColor(Color.BLUE);
        paint.fill();
        getPlayer().delete();
        getPlayer().draw();
        return paint;
    }

}
