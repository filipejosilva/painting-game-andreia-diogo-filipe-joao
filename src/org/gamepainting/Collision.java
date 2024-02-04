package org.gamepainting;
import org.gamepainting.Item;
import org.gamepainting.Player.Player;

public class Collision {

    public Collision() {

    }

    public void checkCollisionItems(Item item, Player[] players){
        for(int i = 0; i < players.length; i++) {
            if((players[i].getPlayer().getX() < Item.getNewItemPositionX() + Item.length &&
                players[i].getPlayer().getY() < Item.getNewItemPositionY() + Item.length &&
                players[i].getPlayer().getX() + players[i].getPlayer().getWidth() > Item.getNewItemPositionX() &&
                players[i].getPlayer().getY() + players[i].getPlayer().getHeight() > Item.getNewItemPositionY())) {
                    if(item.isSpeed()) {
                        players[i].setMultiplier(3);
                        players[i].setItemCount(100);
                        System.out.println("Player collied with wings and increase velocity.");
                        item.eraseItem();
                    }

            }
        }
    }

    public static void checkCollisionPlayers(Player[] players){
        for(int i = 0; i < players.length; i++) {
            for(int j = i + 1; j < players.length; j++) {
                if(players[i].getPlayer().getX() < players[j].getPlayer().getX() + players[j].getPlayer().getWidth() &&
                players[i].getPlayer().getY() < players[j].getPlayer().getY() + players[j].getPlayer().getHeight() &&
                players[i].getPlayer().getX() + players[i].getPlayer().getWidth() > players[j].getPlayer().getX() &&
                players[i].getPlayer().getY() + players[i].getPlayer().getHeight() >  players[j].getPlayer().getY()) {
                    players[i].setStunned();
                    players[j].setStunned();
                    System.out.println("Two players have collided, should stop walking");
                    bumped(players[i], players[j]);
                }
            }
        }
    }

    public static void bumped(Player one, Player two) {
        one.clashBack();
        two.clashBack();
    }
}
