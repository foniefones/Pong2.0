import java.awt.*;

public class AIPaddle {
    int x;
    int y;
    int width = 15;
    int height = 40;
    int speed = 1;

    Rectangle boundingBox;

    boolean goingUp = false;
    boolean goingDown = false;

    public AIPaddle(int x, int y) {
        this.x = x;
        this.y = y;

        boundingBox = new Rectangle(x,y, width, height);
        boundingBox.setBounds(x,y,width,height);
    }

    public void tick (Game game) {      //update method with bounds to keep paddle inside game walls
        boundingBox.setBounds(x,y,width,height);
// Ai paddle adapts to ball movement
        if (game.ball.y < y) {        // && y >= 0)
            y-= speed;
        }
        if(game.ball.y > y) {       // && y + game.HEIGHT <= game.HEIGHT)
            y+= speed;
        }
    }

    public void render (Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(x, y, width , height);
    }
}
