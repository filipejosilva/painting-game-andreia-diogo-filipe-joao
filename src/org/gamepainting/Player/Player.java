package org.gamepainting.Player;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.gamepainting.Background;

import java.util.ArrayList;

public abstract class Player {
    protected Color color;
    private Background background;
    private Picture player;
    protected ArrayList<Rectangle> score;
    public Player(Background background, int x, int y, Color color, String picture){
        this.player = new Picture(x,y, picture);
        this.background = background;
        this.color = color;

    }

    public Picture getPlayer(){
        return player;
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

    public abstract void addArray();

}

