package org.gamepainting.Player;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.gamepainting.Background;
import org.gamepainting.Game;

public class HumanPlayer extends Player {

    //private Rectangle background;

    public HumanPlayer(Background background, int x, int y, Color color){
        super(background, x, y, color);
        getPlayer().setColor(color);
        getPlayer().fill();
    }

    @Override
    public void move() {
    }

    public void moveLeft(){
        if(getPlayer().getX() <= getBackground().getX()){
            return;
        }
        paint();
        getPlayer().translate(-Game.SPEED, 0);
        /*
        Rectangle paint = new Rectangle(player.getX(), player.getY(), 50,50);
        paint.setColor(Color.BLUE);
        paint.fill();
        player.delete();
        player.fill();
        */

    }
    public void moveRight(){
        if(getPlayer().getX() + getPlayer().getWidth() >= getBackground().getWidth()){
            return;
        }
        getPlayer().translate(Game.SPEED, 0);
        /*player.setColor(Color.BLUE);
        player = new Rectangle((player.getX() + org.gamepainting.Game.SPEED), player.getY(), 50,50);
        player.setColor(Color.CYAN);
        player.fill();*/
        paint();

    }
    public void moveUp(){
        if(getPlayer().getY() <= getBackground().getY()){
            return;
        }
        paint();
        getPlayer().translate(0, -Game.SPEED);
    }


    public void moveDown(){
        if(getPlayer().getY() + getPlayer().getHeight() >= getBackground().getHeight()){
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
        getPlayer().fill();
    }
}
