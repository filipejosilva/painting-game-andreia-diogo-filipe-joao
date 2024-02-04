package org.gamepainting.Player;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.gamepainting.Background;
import org.gamepainting.Game;
//import org.gamepainting.CollisionDetector;

import java.util.ArrayList;

public class Player{
    protected Color color;
    private Background background;
    private Picture player;
    protected ArrayList<Rectangle> score = new ArrayList<>();
    protected double lastMove = Math.random();

    protected int speed = Game.SPEED;

    public Player(Background background, int x, int y, Color color, String picture){
        this.player = new Picture(x,y, picture);
        this.background = background;
        this.color = color;
        getPlayer().draw();

    }

    public Picture getPlayer(){
        return player;
    }
    public Background getBackground(){
        return background;
    }
    public void move() {
    }

    public void moveLeft() {

        if (getPlayer().getX() - speed <= getBackground().getX()) {
            return;
        }
        if(paintCollision())
        {
            getPlayer().translate(-speed, 0);
            return;
        }
        addArray(paint());
        getPlayer().translate(-speed, 0);

    }

    public void moveRight() {
        if(getPlayer().getX() + getPlayer().getWidth() + speed >= getBackground().getWidth()){
            return;
        }
        if(paintCollision())
        {
            getPlayer().translate(speed, 0);
            return;
        }
        addArray(paint());
        getPlayer().translate(speed, 0);
    }

    public void moveDown() {
        if(getPlayer().getY() + getPlayer().getHeight() + speed >= getBackground().getHeight()){
            return;
        }
        if(paintCollision())
        {
            getPlayer().translate(0, speed);
            return;
        }
        addArray(paint());
        getPlayer().translate(0, speed);
    }

    public void moveUp() {
        if(getPlayer().getY() - speed <= getBackground().getY()){
            return;
        }
        if(paintCollision())
        {
            getPlayer().translate(0, -speed);
            return;
        }
        addArray(paint());
        getPlayer().translate(0, -speed);
    }

    public Rectangle paint() {
        Rectangle paint = new Rectangle(getPlayer().getX(), getPlayer().getY(), 25,25);
        paint.setColor(color);
        paint.fill();
        getPlayer().delete();
        getPlayer().draw();
        return paint;
    }

    public void addArray(Rectangle rectangle){
        score.add(rectangle);
    }
    public int sizeArray(){
     return score.size();
    }

    public ArrayList<Rectangle> getScore() {
        return score;
    }
    public void removeArray(int index){
        score.remove(index);
    }
    public boolean paintCollision(){
        for(int i = 0; i< sizeArray(); i++){
            if(player.getX() == score.get(i).getX() && player.getY() == score.get(i).getY()){
                return true;
            }
        }
        return false;
    }

    public void checkCollisionItem() {

    }
}

