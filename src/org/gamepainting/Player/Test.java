package org.gamepainting.Player;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Test {
    private Picture picture;

    public Test(){
       this.picture = new Picture(10, 10, "resources/pincel.png");
       picture.draw();
    }
}