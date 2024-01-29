<<<<<<< HEAD
package org.gamepainting;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Background {

    private Picture picture;

    public Background(){
        picture = new Picture(0,0, "resources/background.png");
        picture.draw();
    }

    public int getX(){
        return picture.getX();
    }
    public int getY(){
        return picture.getY();
    }
    public int getWidth(){
        return picture.getWidth();
    }
    public int getHeight(){
        return picture.getHeight();
    }
}
=======
package org.gamepainting;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Background {

    private Picture picture;

    public Background(){
        picture = new Picture(0,0, Game.RESOURCES_PREFIX + "background.png");
        picture.draw();
    }

    public int getX(){
        return picture.getX();
    }
    public int getY(){
        return picture.getY();
    }
    public int getWidth(){
        return picture.getWidth();
    }
    public int getHeight(){
        return picture.getHeight();
    }
}
>>>>>>> second-version
