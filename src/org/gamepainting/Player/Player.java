package org.gamepainting.Player;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.gamepainting.Background;

public abstract class Player {
    protected Color color;
    private Background background;
    private Picture player;
    public Player(Background background, int x, int y, Color color, String picture){
        this.player = new Picture(x,y, picture);
        this.background = background;
        this.color = color;

    }

    public Picture getPlayer(){
        return player;
    }
    public void setPlayer(String newPicture, int x, int y){
        player = new Picture(x,y, newPicture);
    }
    public Background getBackground(){
        return background;
    }
    public abstract void move();

    public abstract void moveLeft();
    public abstract void moveRight();
    public abstract void moveDown();
    public abstract void moveUp();

    public abstract void paint();

}

