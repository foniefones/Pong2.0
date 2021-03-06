import java.awt.*;

public class PlayerPaddle {
    int x;
    int y;
    int width = 15;
    int height = 70;
    int speed = 2;

    Rectangle boundingBox;

    boolean goingUp = false;
    boolean goingDown = false;

    public PlayerPaddle(int x, int y) {
        this.x = x;
        this.y = y;

        boundingBox = new Rectangle(x,y, width, height);        //invisible rect for paddle to check collision with ball
        boundingBox.setBounds(x,y,width,height);
    }

    public void tick (Game game) {      //update method
        boundingBox.setBounds(x,y,width,height);
        if (goingUp && y >= 40) {
            y-= speed;
        }
        if (goingDown &&  y < game.HEIGHT - 83) {
            y+= speed;
        }
    }

    public void render (Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(x, y, width , height);
    }
}
