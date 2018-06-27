import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputHandler implements KeyListener {

    public InputHandler(Game game) {
        game.frame.addKeyListener(this);
    }

    public void keyPressed(KeyEvent e) {
        System.out.println("press");
        int keyCode = e.getKeyCode();

        if (keyCode == KeyEvent.VK_W) {
            Game.player.goingUp = true;
            Game.player.goingDown = false;
        }
        if (keyCode == KeyEvent.VK_S) {
            Game.player.goingUp = false;
            Game.player.goingDown = true;
        }
    }

    public void keyReleased(KeyEvent e) {
        System.out.println("release");
        int keyCode = e.getKeyCode();

        if (keyCode == KeyEvent.VK_W) {
            Game.player.goingUp = false;
            Game.player.goingDown = false;
        }
        if (keyCode == KeyEvent.VK_S) {
            Game.player.goingUp = false;
            Game.player.goingDown = false;
        }
    }

    public void keyTyped(KeyEvent e) {
    }


}
