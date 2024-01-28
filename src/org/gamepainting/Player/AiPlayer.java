package org.gamepainting.Player;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.gamepainting.Background;
import org.gamepainting.Game;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.ietf.jgss.GSSManager;

public class AiPlayer extends Player {
    private double lastMove = Math.random();

    public AiPlayer(Background background, int x, int y, Color color){
        super(background, x, y, color);
        getPlayer().setColor(color);
        getPlayer().fill();
    }

    @Override
    public void move(){

        if(Math.random()<0.75){
            paint();
            repeatMove();
            return;
        }
        paint();
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
    public void paint() {
        Rectangle paint = new Rectangle(getPlayer().getX(), getPlayer().getY(), 25,25);
        paint.setColor(color);
        paint.fill();
        getPlayer().delete();
        getPlayer().fill();
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

