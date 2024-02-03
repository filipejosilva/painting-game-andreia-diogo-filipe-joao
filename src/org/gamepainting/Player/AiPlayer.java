package org.gamepainting.Player;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.gamepainting.Background;
import org.gamepainting.Game;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.util.ArrayList;

public class AiPlayer extends Player {

    public AiPlayer(Background background, int x, int y, Color color, String picture){
        super(background, x, y, color, picture);
    }

    @Override
    public void move(){

        if(Math.random()<0.75){
            addArray(paint());
            repeatMove();
            return;
        }
        addArray(paint());
        newMove();

    }

    public void newMove() {
        double direction = Math.random();
        lastMove = direction;

        if (lastMove < 0.25) {
            moveLeft();
            return;
        }
        if (lastMove < 0.50) {
            moveRight();
            return;
        }
        if (lastMove < 0.75) {
            moveDown();
            return;
        }
            moveUp();

    }

    public void repeatMove() {
        if (lastMove < 0.25) {
            moveLeft();
            return;
        }
        if (lastMove < 0.50) {
            moveRight();
            return;
        }
        if (lastMove < 0.75) {
            moveDown();
            return;
        }
            moveUp();
        }


}