package org.gamepainting;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.util.ArrayList;

public interface CollisionDetector {

    boolean collision(Rectangle rectangle, Rectangle rectangle1);

}

