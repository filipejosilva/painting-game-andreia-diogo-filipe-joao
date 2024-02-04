package org.gamepainting;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.gamepainting.Background;
import org.gamepainting.Game;
import org.gamepainting.Player.Player;

import java.util.Random;

public class Item {

    final static int length = 25; //represents width and height size
    boolean speed = false;
    boolean bomb = false;
    boolean growth = false;
    Picture itemCreated;
    int counter; //to count the time the item will be show

    public Item(Background background, Player[] players) {
        int itemNumber = (int) (Math.random() * 3);
        int[] newItemPosition = new int[2]; //to store new itemPosition
        counter = 100;

        String item;
        switch(itemNumber) {
            case 0:
                item = "red-apple.png"; //represents growth
                growth = true;
                break;
            case 1:
                item = "angel-wings.png"; //represents speed
                speed = true;
                break;
            case 2:
            default:
                item = "tnt-bomb.png"; //represents expanding area painted
                bomb = true;
                break;
        }
        newItemPosition = positionRandom(background, players);
        itemCreated = new Picture(newItemPosition[0], newItemPosition[1], Game.RESOURCES_PREFIX + item);
        itemCreated.draw();
    }

    public int[] positionRandom(Background background, Player[] players) {
        Random random = new Random();
        int[] coordinates = new int[2]; //to store x and y
        boolean overlapPosition;

        do {
            overlapPosition = false;
            coordinates[0] = (int) (Math.random() * background.getWidth());
            coordinates[1] = (int) (Math.random() * background.getHeight());
            for (int i = 0; i < players.length; i++) {
                if (players[i].getPlayer().getX() == coordinates[0] && players[i].getPlayer().getY() == coordinates[1] &&
                    players[i].getPlayer().getX() + players[i].getPlayer().getWidth() == coordinates[0] + length &&
                    players[i].getPlayer().getY() + players[i].getPlayer().getHeight() == coordinates[1] + length) {
                    overlapPosition = true;
                }
            }
        }
        while(overlapPosition);
        return coordinates;
    }

    public int decrementTimer(){
        counter--;
        if(counter == 0) {
            itemCreated.delete();
        }
        return counter;
    }


}
