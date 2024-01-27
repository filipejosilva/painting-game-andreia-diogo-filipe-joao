package org.gamepainting;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Background {

    private Picture picture;

    public Background(){
        picture = new Picture(0,0, "resources/background.png");
        picture.draw();
    }
}
