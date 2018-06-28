import javafx.scene.canvas.Canvas;


import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game extends Canvas implements Runnable {

    public static PlayerPaddle player;
    public static AIPaddle ai;
    public static Ball ball;
    InputHandler ih;

    JFrame frame;
    public final int WIDTH = 800;
    public final int HEIGHT = 500;
    public final Dimension gameSize = new Dimension(WIDTH, HEIGHT);
    public final String TITLE = "ACADEMY PONG CHAMP DELUXE";


    BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);

    static boolean gameRunning = false;
    int p1score, p2score;
    static MP3Player musicplayer = new MP3Player();

    public void run() {

        while (gameRunning) {
            tick();
            render();
            try {
                Thread.sleep(7);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (p1score == 5) {        //win condition player1
            int playagain = JOptionPane.showConfirmDialog(null, "Player 1 is the winner! \nPlay again?", "GAME OVER", JOptionPane.YES_NO_OPTION);
            if (playagain == 0) {
                Game game = new Game();
                game.start();
            } else if (playagain == 1) {
                System.exit(0);
            }
        } else if (p2score == 5) {      //win condition player2
            int playagain = JOptionPane.showConfirmDialog(null, "Player 2 is the winner! \nPlay again?", "GAME OVER", JOptionPane.YES_NO_OPTION);
            if (playagain == 0) {
                Game game = new Game();
                game.start();
            } else if (playagain == 1) {
                System.exit(0);
            }
        }
    }

    public synchronized void start() {
        gameRunning = true;
        new Thread(this).start();
    }

    public static synchronized void stop() {
        gameRunning = false;


        //System.exit(0);
    }

    public Game() {
        frame = new JFrame();

        frame.setMinimumSize(gameSize);
        frame.setPreferredSize(gameSize);
        frame.setMaximumSize(gameSize);
//        frame.add(this, BorderLayout.CENTER);
        frame.pack();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setTitle(TITLE);
        frame.setLocationRelativeTo(null);

        player = new PlayerPaddle(10, 60);
        ai = new AIPaddle(WIDTH - 25, 60);
        ball = new Ball(WIDTH / 2, HEIGHT / 2);
        ih = new InputHandler(this);
        frame.addKeyListener(ih);

    }

    public void tick() {             //update method
        player.tick(this);
        ai.tick(this);
        ball.tick(this);
    }

    public void render() {                                  //draw background, paddles and ball in canvas window
        BufferStrategy bs = frame.getBufferStrategy();
        if (bs == null) {
            frame.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();

        g.setColor(Color.BLACK);
        g.drawImage(image, 0, 0, 800, 500, null);

        g.setColor(Color.WHITE);
        g.drawString("Player 1: " + p1score, 75, 52);
        g.drawString("Player 2: " + p2score, WIDTH - 140, 52);

        player.render(g);
        ai.render(g);
        ball.render(g);

        g.dispose();
        bs.show();
    }
}
