package org.gamepainting.windows;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.gamepainting.Background;
import org.gamepainting.Game;
import org.gamepainting.Score;

import java.io.IOException;

public class HighScore extends Window{

    private Text highscore;
    private Text highNumber;

    public HighScore(CurrentWindow current) throws IOException {
        super(current);
        init();

    }
    @Override
    public void changeWindow() {
        Background background = new Background();
        Menu images= new Menu(background, current);
        current.setWindow(images);
    }
    public void init() throws IOException {
        highscore = new Text(250, 100, "HighScore");
        highscore.setColor(Color.BLACK);
        highscore.setText("HighScore");
        highscore.grow(125,50);
        highscore.draw();

        Score score = new Score();
        highNumber = new Text(250, 200, "Score");
        highNumber.setColor(Color.BLACK);
        highNumber.setText(String.valueOf(score.getScore(Game.RESOURCES_PREFIX + "Score")));
        highNumber.grow(125,25);
        highNumber.draw();
    }
}
