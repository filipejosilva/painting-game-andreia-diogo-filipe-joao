package org.gamepainting.Player;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public abstract class Player {

    private Rectangle background;
    private Rectangle player;
    public Player(Rectangle background, int x, int y){
        this.player = new Rectangle(x,y,25,25);
        this.background = background;
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
