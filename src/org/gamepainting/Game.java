package org.gamepainting;

import org.academiadecodigo.simplegraphics.graphics.Canvas;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.gamepainting.Player.*;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Game {

    public static final int SPEED = 7;
    public static final String RESOURCES_PREFIX = "resources/";
    public static final String PLAYER_IMG = "marble";
    private Player[] players;
    private int numberOfPlayers = 4;
    private int delay;
    private Background background;

    public Game(Background background, int delay){
        this.background = background;
        this.delay = delay;
    }

    public void init(){
        
        players = new Player[numberOfPlayers];
        
        //Human player
        players[0] = PlayerFactory.getNewHumanPlayer(background, initialPositionX(0),initialPositionY(0), Color.CYAN, RESOURCES_PREFIX + PLAYER_IMG + "0.png");
        System.out.println("Human player created");
        KeyboardLogic keyboard = new KeyboardLogic();
        keyboard.setPlayer(players[0]);

        //ai player
        for(int i = 1; i <players.length; i++){
            players[i] = PlayerFactory.getNewAiPlayer(background, initialPositionX(i),initialPositionY(i), setColor(i),RESOURCES_PREFIX + PLAYER_IMG + i + ".png");
            System.out.println("Ai player created" + i);
        }
    }

    public void start() throws InterruptedException {
        int time = 0;

        while(time <1000){
            Thread.sleep(delay);

            movePlayers();
            time ++;
        }
    }

    public void movePlayers(){
        for(Player p : players){
            p.move();
        }
    }

    public Color setColor(int indexAIPlayer) {

        Color color;
        switch (indexAIPlayer) {
            case 1:
                color = Color.YELLOW;
                break;
            case 2:
                color = Color.GREEN;
                break;
            case 3:
                color = Color.RED;
                break;
            default:
                color = Color.YELLOW;
                break;
        }
        return color;
    }

    public int initialPositionX(int indexPlayer) {
        //to find the center position so all players have the same distance from center
        int x = 0; //takes y and x positions
        //int centerY = 0;
        //int centerX = 0;

        switch (indexPlayer) {
            case 0:
                x = 700;
                break;
            case 1:
                x = 700;
                break;
            case 2:
                x = 800;
                break;
            case 3:
                x = 800;
                break;
        }
        return x;
    }

    public int initialPositionY(int indexPlayer) {
        //to find the center position so all players have the same distance from center
        int y = 0; //takes y and x positions
        //int centerY = 0;
        //int centerX = 0;

        switch (indexPlayer) {
            case 0:
                y = 350;
                break;
            case 1:
                y = 450;
                break;
            case 2:
                y = 450;
                break;
            case 3:
                y = 350;
                break;
        }
        return y;
    }
}
