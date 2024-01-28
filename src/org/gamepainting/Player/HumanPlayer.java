package org.gamepainting.Player;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.gamepainting.Background;
import org.gamepainting.Game;

public class HumanPlayer extends Player {

    public HumanPlayer(Background background, int x, int y, Color color, String picture){
        super(background, x, y, color, picture);
        getPlayer().draw();
    }

    @Override
    public void move() {
    }

    public void moveLeft(){
        if(getPlayer().getX() - Game.SPEED <= getBackground().getX()){
            return;
        }
        paint();
        getPlayer().translate(-Game.SPEED, 0);

    }
    public void moveRight(){
        if(getPlayer().getX() + getPlayer().getWidth() + Game.SPEED >= getBackground().getWidth()){
            return;
        }
        paint();
        getPlayer().translate(Game.SPEED, 0);


    }
    public void moveUp(){
        if(getPlayer().getY() - Game.SPEED <= getBackground().getY()){
            return;
        }
        paint();
        getPlayer().translate(0, -Game.SPEED);
    }


    public void moveDown(){
        if(getPlayer().getY() + getPlayer().getHeight() + Game.SPEED >= getBackground().getHeight()){
            return;
        }
        paint();
        getPlayer().translate(0, Game.SPEED);


    }

    @Override
    public void paint() {
        Rectangle paint = new Rectangle(getPlayer().getX(), getPlayer().getY(), 25,25);
        paint.setColor(Color.BLUE);
        paint.fill();
        getPlayer().delete();
        getPlayer().draw();
    }
}
