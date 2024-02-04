package org.gamepainting.Player;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.gamepainting.Background;
import org.gamepainting.Collision;
import org.gamepainting.Game;

import java.util.ArrayList;
import java.util.Random;

public class Player{
    protected Color color;
    private Background background;
    private Picture player;
    protected ArrayList<Rectangle> score = new ArrayList<>();
    protected double lastMove = Math.random();
    public static int speed = 7;
    protected boolean stunned = false; //temporary shock with the other player/item
    protected int stunnedCount = 0;
    protected int multiplier = 1; //to increase velocity
    protected int itemCount = 0; //for the velocity increase to be temporary

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

    public void move(){

    }
    public void moveLeft(int multiplier) {
        lastMove = 0.1;

        if (getPlayer().getX() - speed <= getBackground().getX()) {
            return;
        }
        if(paintCollision())
        {
            getPlayer().translate(-speed * multiplier, 0);
            return;
        }
        addArray(paint());
        getPlayer().translate(-speed * multiplier, 0);

    }

    public void moveRight(int multiplier) {

        lastMove = 0.3;

        if(getPlayer().getX() + getPlayer().getWidth() + speed >= getBackground().getWidth()){
            return;
        }
        if(paintCollision())
        {
            getPlayer().translate(speed * multiplier, 0);
            return;
        }
        addArray(paint());
        getPlayer().translate(speed * multiplier, 0);
    }

    public void moveDown(int multiplier) {
        lastMove = 0.6;
        if(getPlayer().getY() + getPlayer().getHeight() + speed >= getBackground().getHeight()){
            return;
        }
        if(paintCollision())
        {
            getPlayer().translate(0, speed * multiplier);
            return;
        }
        addArray(paint());
        getPlayer().translate(0, speed * multiplier);
    }

    public void moveUp(int multiplier) {
        lastMove = 0.8;
        if(getPlayer().getY() - speed <= getBackground().getY()){
            return;
        }
        if(paintCollision())
        {
            getPlayer().translate(0, -speed * multiplier);
            return;
        }
        addArray(paint());
        getPlayer().translate(0, -speed * multiplier);
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

    public boolean isStunned() {
        return stunned;
    }

    public void setStunned() {
        this.stunned = true;
        this.stunnedCount = 30; //time that he will spend stunned
    }

    public void clashBack(){
        int randomDirection = (int) (Math.random() * 2);
        if (lastMove < 0.25) {
            moveRight(4);
            if (randomDirection == 0){
                moveUp(4);
            }
            else{
                moveDown(4);
            }

            return;
        }
        if (lastMove < 0.50) {
            moveLeft(4);
            if (randomDirection == 0){
                moveUp(4);
                moveUp(4);
            }
            else{
                moveDown(4);
            }
            return;
        }
        if (lastMove < 0.75) {
            moveUp(4);
            if (randomDirection == 0){
                moveLeft(4);
            }
            else{
                moveRight(4);
            }
            return;
        }
        moveDown(4);
        if (randomDirection == 0){
            moveLeft(4);
        }
        else{
            moveRight(4);
        }
    }

    public void setMultiplier(int multiplier) {
        this.multiplier = multiplier;
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

    public void handleItems(){
        if(itemCount > 0){  //means we have an item and timer is decrementing
            itemCount--;
            if(itemCount == 0){
                multiplier = 1;   //if timer goes to 0, our bonus is over
                //do same for growth
            }
        }
    }
}

