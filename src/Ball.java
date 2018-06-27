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

    Rectangle boundingBox;


    public Ball(int x, int y){
        this.x=x;
        this.y=y;

        velocityX=speed;
        velocityY=speed;

        boundingBox = new Rectangle(x,y, size, size);
        boundingBox.setBounds(this.x,this.y,this.size,this.size);
    }
    public void tick(Game game) {
        boundingBox.setBounds(x,y,size,size);

        if( x <= 0 ){
            game.p2score++;
            velocityX=speed;
        }else if(x + size >= game.WIDTH){
            game.p1score++;
            velocityX =-speed;
        }
        if(y < 32){
            velocityY = speed;
        }else if ( y  >= game.HEIGHT-size){
            velocityY=-speed;
        }

        x += velocityX;
        y += velocityY;

        paddleCollide(game);
    }

        private void paddleCollide(Game game) {
        if(boundingBox.intersects(game.player.boundingBox)){
            velocityX=speed;
        }else if(boundingBox.intersects(game.ai.boundingBox)){
            velocityX=-speed;
            }
        }

    public void render(Graphics g){
        g.setColor(Color.RED);
        g.fillOval(x,y,size,size);
    }
}
