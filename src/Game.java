import javafx.scene.canvas.Canvas;


import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game extends Canvas implements Runnable {
    private static final long serialVersionUID = 1L;

    public static PlayerPaddle player;
    InputHandler ih;

    JFrame frame;
    public final int WIDTH = 400;
    public final int HEIGHT = 250;
    public final Dimension gameSize = new Dimension(WIDTH, HEIGHT);
    public final String TITLE = "Pong InDev";

    public int screenWidth = (int) getWidth();
    public int screenHeight = (int) getHeight();

    BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);

    static boolean gameRunning = false;


    public void run() {

        while (gameRunning) {
            tick();
            render();
        }
    }

    public synchronized void start() {
        gameRunning = true;
        new Thread(this).start();
    }
    public static synchronized void stop() {
        gameRunning = false;
        System.exit(0);
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

//        screenWidth = getWidth();
//        screenHeight =  getHeight();

        ih = new InputHandler(this);
        frame.addKeyListener(ih);

    }
    public void tick(){             //update method
        player.tick(this);
    }
    public void render() {
        BufferStrategy bs = frame.getBufferStrategy();
        if (bs == null) {
            frame.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();

        g.setColor(Color.BLACK);
        g.drawImage(image, 0, 0, 400, 250, null);

        player.render(g);

        g.dispose();
        bs.show();
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.start();

    }

}