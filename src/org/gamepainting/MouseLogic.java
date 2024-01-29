package org.gamepainting;
import org.academiadecodigo.simplegraphics.mouse.*;
import org.academiadecodigo.simplegraphics.pictures.*;
import org.gamepainting.Player.HumanPlayer;

public class MouseLogic implements MouseHandler {

    private Game game;
    private Mouse mouse;
    private Picture playButton;
    private Picture exitButton;

    public MouseLogic(){
        mouse = new Mouse(this);
        mouse.addEventListener(MouseEventType.MOUSE_CLICKED);
    }

    public void setButtons(Picture playButton, Picture exitButton){
        this.playButton = playButton;
        this.exitButton = exitButton;
    }

    public void startGame() throws InterruptedException {
        Background background = new Background();
        Game game = new Game(background, 50);
        game.init();
        game.start();
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

        if (mouseEvent.getX() > playButton.getX() &&
                mouseEvent.getX() < playButton.getX() + playButton.getWidth() &&
                mouseEvent.getY() > playButton.getY() &&
                mouseEvent.getY() < playButton.getY() + playButton.getHeight()) {

            try {
                startGame();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }

        if (mouseEvent.getX() > exitButton.getX() &&
                mouseEvent.getX() < exitButton.getX() + exitButton.getWidth() &&
                mouseEvent.getY() > exitButton.getY() &&
                mouseEvent.getY() < exitButton.getY() + exitButton.getHeight()){
            System.exit(0);
        }

    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent){
    }

}