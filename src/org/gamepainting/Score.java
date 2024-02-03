package org.gamepainting;

import java.io.*;

import static java.lang.Integer.parseInt;

public class Score {
    private FileInputStream in;
    private FileOutputStream out;

    public void fileCopy(String src, String dest) throws IOException {
        setUp(src, dest);
        byte[] buffer = new byte[1024];
        int numOfBytesRead = in.read(buffer);

        while (numOfBytesRead != -1) {

            out.write(buffer, 0, numOfBytesRead);
            numOfBytesRead = in.read(buffer);
        }
        closeStreams();
    }

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
        FileWriter in = new FileWriter(src);
        BufferedWriter writer = new BufferedWriter(in);

        writer.write(String.valueOf(score));
        //Intenger.toString(score)
        writer.close();
    }

    private void setIn(String src){
        try {
            in = new FileInputStream("src");

        } catch (FileNotFoundException e) {
            System.out.println("error opening file");
            System.out.println("please pass valid paths");
        }
    }
    private void setUp(String src, String dest) throws FileNotFoundException {
        try {
            in = new FileInputStream("src");
            out = new FileOutputStream("dest");
        } catch (FileNotFoundException e) {
            System.out.println("error opening file");
            System.out.println("please pass valid paths");

        }
    }

    public void closeStreams() {
        try {
            in.close();
            out.close();
        } catch (IOException e) {
            System.out.println("Error closing stremas");
            System.out.println("please try again");
        }

    }
}
