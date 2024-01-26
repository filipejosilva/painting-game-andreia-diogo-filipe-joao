import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Player implements Movable{

    private Rectangle bakcground;
    private Rectangle player;

    public Player(Rectangle bakcground){
        this.bakcground = bakcground;
        player = new Rectangle(10,10,50,50);
        player.setColor(Color.CYAN);
        player.fill();
    }

    public void moveLeft(){
        if(player.getX() <= bakcground.getX()){
            return;
        }
        player.translate(-Game.SPEED, 0);

    }
    public void moveRight(){
        if(player.getX() + player.getWidth() >= bakcground.getWidth()){
            return;
        }
        player.translate(Game.SPEED, 0);

    }
    public void moveUp(){
        if(player.getY() <= bakcground.getY()){
            return;
        }
        player.translate(0, -Game.SPEED);
    }
    public void moveDown(){
        if(player.getY() + player.getHeight() >= bakcground.getHeight()){
            return;
        }
        player.translate(0, Game.SPEED);

    }

}
