package org.gamepainting.Player;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.gamepainting.Background;
import org.gamepainting.Game;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.util.ArrayList;

public class AiPlayer extends Player {
    private double lastMove = Math.random();

    public AiPlayer(Background background, int x, int y, Color color, String picture){
        super(background, x, y, color, picture);
        getPlayer().draw();
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

    @Override
    public void moveLeft() {

        if (getPlayer().getX() - Game.SPEED <= getBackground().getX()) {
            return;
        }
        getPlayer().translate(-Game.SPEED, 0);

    }

    @Override
    public void moveRight() {
        if(getPlayer().getX() + getPlayer().getWidth() + Game.SPEED >= getBackground().getWidth()){
            return;
        }
        getPlayer().translate(Game.SPEED, 0);
    }

    @Override
    public void moveDown() {
        if(getPlayer().getY() + getPlayer().getHeight() + Game.SPEED >= getBackground().getHeight()){
            return;
        }
        getPlayer().translate(0, Game.SPEED);
    }

    @Override
    public void moveUp() {
        if(getPlayer().getY() - Game.SPEED <= getBackground().getY()){
            return;
        }
        getPlayer().translate(0, -Game.SPEED);
    }

    @Override
    public Rectangle paint() {
        Rectangle paint = new Rectangle(getPlayer().getX(), getPlayer().getY(), 25,25);
        paint.setColor(color);
        paint.fill();
        getPlayer().delete();
        getPlayer().draw();
        return paint;
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

    @Override
    public void addArray(Rectangle rectangle) {
        score.add(rectangle);
    }

    @Override
    public int sizeArray() {
        return score.size();
    }


}