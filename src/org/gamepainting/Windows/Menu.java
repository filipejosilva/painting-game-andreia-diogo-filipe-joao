package org.gamepainting.Windows;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.gamepainting.Background;
import org.gamepainting.Game;

import java.io.IOException;

public class Menu extends Window{
    private Background background;
    private Picture letterA;
    private Picture letterD;
    private Picture letterF;
    private Picture letterJ;
    private Picture lineJ;
    private Picture playFrame;
    private Picture playButton;
    private Picture exitFrame;
    private Picture exitButton;
    private Picture dinosaur;
    private Mouse mouse;

    public Menu(Background background, CurrentWindow window) {
        super(window);
        this.background = background;
        init();
    }

    public void init(){
            playFrame = new Picture(345, 265, Game.MENU + "Frame 9.1.png");
            playFrame.draw();

            playButton = new Picture (367, 272, Game.MENU + "Start.png");
            playButton.draw();

            exitFrame = new Picture(365, 475, Game.MENU + "Frame 10.1.png");
            exitFrame.draw();

            exitButton = new Picture(347,475, Game.MENU + "exit.png");
            exitButton.draw();

            letterA = new Picture(700, 25, Game.MENU + "A.png");
            letterA.draw();

            letterD = new Picture(850, 200, Game.MENU + "D.png");
            letterD.draw();

            letterF = new Picture(700, 365, Game.MENU + "F.png");
            letterF.draw();

            letterJ = new Picture(850, 580, Game.MENU + "J.png");
            letterJ.draw();

            lineJ = new Picture (820, 550, Game.MENU + "Line J.png");
            lineJ.draw();

            dinosaur = new Picture (20, 425, Game.MENU + "Dino 2.png");
            dinosaur.draw();
    }
    public Picture getPlayButton() {
        return playButton;
    }

    public Picture getExitButton() {
        return exitButton;
    }

    @Override
    public void changeWindow() throws InterruptedException, IOException {
        Background background = new Background();
        Game game = new Game(background,40, current);
        current.setWindow(game);
        game.init();
        game.start();
    }

}
