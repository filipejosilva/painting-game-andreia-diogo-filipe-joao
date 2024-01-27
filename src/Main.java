public class Main {
    public static void main(String[] args) throws InterruptedException {

        Game game = new Game(100, 30, 100);
        game.init();
        game.start();
    }
}