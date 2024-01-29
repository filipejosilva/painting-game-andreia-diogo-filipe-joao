<<<<<<< HEAD
package org.gamepainting.Player;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Test {
    private Picture picture;

    public Test(){
       this.picture = new Picture(10, 10, "resources/pincel.png");
       picture.draw();
    }
=======
package org.gamepainting.Player;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.gamepainting.Game;

public class Test {
    private Picture picture;

    public Test(){
       this.picture = new Picture(10, 10, Game.RESOURCES_PREFIX +"pincel.png");
       picture.draw();
    }
>>>>>>> second-version
}