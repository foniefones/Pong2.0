import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class InputHandler implements KeyListener {

    public InputHandler(Game game) {
//        game.addKeyListener(this);
    }

    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        if (keyCode == KeyEvent.VK_W) {
            Game.player.goingDown = false;
            Game.player.goingUp = true;
        }
        if (keyCode == KeyEvent.VK_S) {
            Game.player.goingUp = false;
            Game.player.goingDown = true;
        }
    }

    public void keyReleased(KeyEvent e) {

    }
}
