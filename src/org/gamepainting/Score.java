package org.gamepainting;

import java.io.*;

import static java.lang.Integer.parseInt;

public class Score {

    public int getScore(String src) throws IOException {
        int score = 0;
        FileReader in = new FileReader(src);
        BufferedReader reader = new BufferedReader(in);
        String line;
        while((line = reader.readLine()) != null) {

            score = Integer.parseInt(line);
        }
        reader.close();
        return score;
    }

    public void setScore(int score, String src) throws IOException {
        FileWriter out = new FileWriter(src);
        BufferedWriter writer = new BufferedWriter(out);

        writer.write(String.valueOf(score));
        writer.close();
    }

}
