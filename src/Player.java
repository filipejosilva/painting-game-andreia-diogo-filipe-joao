import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Player implements Movable{

    private Rectangle background;
    private Rectangle player;

    public Player(Rectangle background){
        this.background = background;
        player = new Rectangle(10,10,50,50);
        player.setColor(Color.CYAN);
        player.fill();
    }

    public void moveLeft(){
        if(player.getX() <= background.getX()){
            return;
        }
        Rectangle paint = new Rectangle(player.getX(), player.getY(), 50,50);
        player.translate(-Game.SPEED, 0);
        paint.setColor(Color.BLUE);
        paint.fill();
        player.delete();
        player.fill();

    }
    public void moveRight(){
        if(player.getX() + player.getWidth() >= background.getWidth()){
            return;
        }
        //player.translate(Game.SPEED, 0);
        player.setColor(Color.BLUE);
        player = new Rectangle((player.getX() + Game.SPEED), player.getY(), 50,50);
        player.setColor(Color.CYAN);
        player.fill();

    }
    public void moveUp(){
        if(player.getY() <= background.getY()){
            return;
        }
        player.translate(0, -Game.SPEED);
    }
    public void moveDown(){
        if(player.getY() + player.getHeight() >= background.getHeight()){
            return;
        }
        player.translate(0, Game.SPEED);

    }

}
