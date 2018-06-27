import java.awt.*;

public class PlayerPaddle {
    int x;
    int y;
    int width = 15;
    int height = 40;

    boolean goingUp = false;
    boolean goingDown = false;

    public PlayerPaddle(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void tick (Game game) {      //update method
        if (goingUp && y >= 0) {
            y--;
        }
        if (goingDown &&  y + height <= game.screenHeight) {
            y++;
        }
    }

    public void render (Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(x, y, width , height);
    }
}
