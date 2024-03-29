package org.gamepainting;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.gamepainting.Player.*;
import org.gamepainting.Windows.*;
import org.gamepainting.Windows.HighScore;

import java.io.IOException;

public class Game extends Window {

    public static final String RESOURCES_PREFIX = "resources/";
    public static final String MENU = "resources/menu/";
    public static final String PLAYER_IMG = "marble";
    public Player[] players;
    private int numberOfPlayers = 4;
    private int delay;
    private Background background;
    private Score score = new Score();
    private Item item;
    private int counterWaitItemCreation = 300; //interval between showing the items on the screen
    private Collision collision;

    public Game(Background background, int delay, CurrentWindow current){
        super(current);
        this.background = background;
        this.delay = delay;
        collision = new Collision();
    }

    public void init(){
        
        players = new Player[numberOfPlayers];
        
        //Human player
        players[0] = PlayerFactory.getNewHumanPlayer(background, initialPositionX(0),initialPositionY(0), Color.BLUE, RESOURCES_PREFIX + PLAYER_IMG + "0.png");
        System.out.println("Human player created");

        //ai player
        for(int i = 1; i <players.length; i++){
            players[i] = PlayerFactory.getNewAiPlayer(background, initialPositionX(i),initialPositionY(i), setColor(i),RESOURCES_PREFIX + PLAYER_IMG + i + ".png");
            System.out.println("Ai player created" + i);
        }
    }

    public void start() throws InterruptedException, IOException {
        int time = 0;

        Sound sound = new Sound();
        sound.playSound();

        while(time <1000){
            Thread.sleep(delay);


            movePlayers();
            Collision.checkCollisionPlayers(players);
            itemManagement();
            time ++;
        }

        for(Player p : players){
            System.out.println(p.sizeArray());
        }

        HumanPlayer.stopKeyboard();
        sound.stopSound();
        setNewScore();
        changeWindow();
    }
    private void setNewScore() {
        try {
            if(score.getScore( RESOURCES_PREFIX + "Score") >= players[0].sizeArray()) {
                return;
            }
            score.setScore(players[0].sizeArray(), RESOURCES_PREFIX + "Score");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void movePlayers() {
        for (int i = 0; i < players.length; i++) {
            players[i].move();
            collisionPaint(i);
        }
    }

    public void itemManagement() {

        if(item != null){
            collision.checkCollisionItems(item, players);
            if(item.decrementTimer() == 0) {
                item = null;
                System.out.println("item destroyed");
            };
        }
        else if(counterWaitItemCreation == 0) {
            item = new Item(background, players);
            counterWaitItemCreation = 100;
            System.out.println("item created");
        }
        else {
            counterWaitItemCreation--;
        }


        for (int i = 0; i < players.length; i++) {
            players[i].handleItems();
        }

    }

    public Color setColor (int indexAIPlayer){

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
        public int initialPositionX ( int indexPlayer){
         int x = 0;
            switch (indexPlayer) {
                case 0:
                    x = 537;
                    break;
                case 1:
                    x = 537;
                    break;
                case 2:
                    x = 477;
                    break;
                case 3:
                    x = 477;
                    break;
            }
            return x;
        }

        public int initialPositionY ( int indexPlayer){
            int y = 0;
            switch (indexPlayer) {
                case 0:
                    y = 345;
                    break;
                case 1:
                    y = 405;
                    break;
                case 2:
                    y = 405;
                    break;
                case 3:
                    y = 345;
                    break;
            }
            return y;
        }


        public void collisionPaint (int i){
         for (int j = 0; j < players.length; j++) {
            if (!players[i].equals(players[j])) {
                for (int k = 0; k < players[j].sizeArray(); k++) {
                if(players[i].getPlayer().getX() <= players[j].getScore().get(k).getX() + players[j].getScore().get(k).getWidth() &&
                        players[i].getPlayer().getX() + players[i].getPlayer().getWidth() >= players[j].getScore().get(k).getX() &&
                        players[i].getPlayer().getY() <= players[j].getScore().get(k).getY() + players[j].getScore().get(k).getHeight() &&
                        players[i].getPlayer().getY() + players[i].getPlayer().getHeight() >= players[j].getScore().get(k).getY()) {

                    //players[j].getScore().get(k).delete();
                    players[j].removeArray(k);
                    }
                }
            }
        }
    }

    @Override
    public void changeWindow() throws IOException {
        Background background = new Background();
        HighScore highScore = new HighScore(current);
        current.setWindow(highScore);
    }
}
