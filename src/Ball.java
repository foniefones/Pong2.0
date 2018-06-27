import java.awt.*;
import java.awt.Graphics;
import java.awt.Color;

public class Ball {
    int x;
    int y;
    int size=16;
    int speed = 2;
    int velocityX;
    int velocityY;


    public Ball(int x, int y){
        this.x=x;
        this.y=y;

        velocityX=speed;
        velocityY=speed;
    }
    public void tick(Game game) {

        if( x <= 0 ){
            velocityX=speed;
        }else if(x + size >= game.WIDTH){
            velocityX =-speed;
        }
        if(y < 32){
            velocityY = speed;
        }else if ( y  >= game.HEIGHT-size){
            velocityY=-speed;
        }

        x += velocityX;
        y += velocityY;
    }

    public void render(Graphics g){
        g.setColor(Color.RED);
        g.fillOval(x,y,size,size);
    }
}
