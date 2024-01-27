package org.gamepainting;

import org.gamepainting.Player.*;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Game {

    public static final int SPEED = 7;
    private Player[] players;
    private int numberOfPlayers = 2;
    private int delay;
    private Rectangle background;

    public Game(Rectangle background, int delay){
        this.background = background;
        this.delay = delay;
    }

    public void init(){
        
        players = new Player[numberOfPlayers];
        
        //Human player
        players[0] = PlayerFactory.getNewHumanPlayer(background, 10,10);
        System.out.println("Human player created");
        KeyboardLogic keyboard = new KeyboardLogic();
        keyboard.setPlayer(players[0]);

        //ai player
        for(int i = 1; i <players.length; i++){
            players[i] = PlayerFactory.getNewAiPlayer(background, 750,450);
            System.out.println("Ai player created" + i);
        }
    }
}
