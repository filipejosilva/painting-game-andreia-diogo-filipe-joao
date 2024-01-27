package org.gamepainting.Player;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public abstract class Player {
    protected Color color;
    private Rectangle background;
    private Rectangle player;
    public Player(Rectangle background, int x, int y, Color color){
        this.player = new Rectangle(x,y,25,25);
        this.background = background;
        this.color = color;

    }

    public Rectangle getPlayer(){
        return player;
    }
    public Rectangle getBackground(){
        return background;
    }
    public abstract void move();

    public abstract void moveLeft();
    public abstract void moveRight();
    public abstract void moveDown();
    public abstract void moveUp();

    public abstract void paint();

}
