import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputHandler implements KeyListener {

    public InputHandler(Game game) {
        game.frame.addKeyListener(this);
    }

    public void keyPressed(KeyEvent e) {
        System.out.println("press");
        int keyCode = e.getKeyCode();

        //Player 1 controls
        if (keyCode == KeyEvent.VK_W) {
            Game.player.goingUp = true;
            Game.player.goingDown = false;
        }
        if (keyCode == KeyEvent.VK_S) {
            Game.player.goingUp = false;
            Game.player.goingDown = true;
        }

        //Player 2 controls
        if (keyCode == KeyEvent.VK_UP) {
            Game.ai.goingUp = true;
            Game.ai.goingDown = false;
        }
        if (keyCode == KeyEvent.VK_DOWN) {
            Game.ai.goingUp = false;
            Game.ai.goingDown = true;
        }
    }

    public void keyReleased(KeyEvent e) {
        System.out.println("release");
        int keyCode = e.getKeyCode();

        //Player 1 controls
        if (keyCode == KeyEvent.VK_W) {
            Game.player.goingUp = false;
            Game.player.goingDown = false;
        }
        if (keyCode == KeyEvent.VK_S) {
            Game.player.goingUp = false;
            Game.player.goingDown = false;
        }

        //Player 2 controls
        if (keyCode == KeyEvent.VK_UP) {
            Game.ai.goingUp = false;
            Game.ai.goingDown = false;
        }
        if (keyCode == KeyEvent.VK_DOWN) {
            Game.ai.goingUp = false;
            Game.ai.goingDown = false;
        }
    }

    public void keyTyped(KeyEvent e) {
    }


}
