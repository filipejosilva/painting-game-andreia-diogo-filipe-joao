package org.gamepainting;
import org.academiadecodigo.simplegraphics.mouse.*;
import org.academiadecodigo.simplegraphics.pictures.*;
import org.gamepainting.Windows.Window;

import java.io.IOException;

public class MouseLogic implements MouseHandler{

    private Mouse mouse;
    private Picture playButton;
    private Picture exitButton;
    private Window menu;


    public MouseLogic(){
        mouse = new Mouse(this);
        mouse.addEventListener(MouseEventType.MOUSE_CLICKED);
    }

    public void setButtons(Picture playButton, Picture exitButton, Window menu){
        this.playButton = playButton;
        this.exitButton = exitButton;
        this.menu = menu;
    }
    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        if (mouseEvent.getX() > playButton.getX() &&
                mouseEvent.getX() < playButton.getX() + playButton.getWidth() &&
                mouseEvent.getY() > playButton.getY() &&
                mouseEvent.getY() < playButton.getY() + playButton.getHeight()) {
            try {
                menu.changeWindow();
            } catch (InterruptedException | IOException e) {
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
