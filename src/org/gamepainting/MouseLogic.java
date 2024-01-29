package org.gamepainting;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;

    public class MouseLogic implements MouseHandler {

        private Mouse mouse;
        private Rectangle clickableBox;

        public MouseLogic(){
            mouse = new Mouse(this);
            mouse.addEventListener(MouseEventType.MOUSE_CLICKED);
        }

        public void setClickableBox(Rectangle box){
            this.clickableBox = box;
        }

        @Override
        public void mouseClicked(MouseEvent mouseEvent) {
            if (mouseEvent.getX() > clickableBox.getX() &&
                    mouseEvent.getX() < clickableBox.getX() + clickableBox.getWidth() &&
                    mouseEvent.getY() > clickableBox.getY() &&
                    mouseEvent.getY() < clickableBox.getY() + clickableBox.getHeight()) {
                //slide background left to "canvas"
            }
        }

        @Override
        public void mouseMoved(MouseEvent mouseEvent){

        }

    }
