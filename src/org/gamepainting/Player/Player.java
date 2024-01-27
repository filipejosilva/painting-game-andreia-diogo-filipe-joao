package org.gamepainting.Player;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.gamepainting.Background;

public abstract class Player {
    protected Color color;
    private Background background;
    private Rectangle player;
    public Player(Background background, int x, int y, Color color){
        this.player = new Rectangle(x,y,25,25);
        this.background = background;
        this.color = color;

    }

    public Rectangle getPlayer(){
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

}
