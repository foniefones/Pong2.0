import java.awt.*;
import java.awt.Graphics;
import java.awt.Color;

public class Ball {
    private int x;
    int y;
    private int size=16;
    private int speed = 3;
    private int velocityX;
    private int velocityY;

    Rectangle boundingBox;


    public Ball(int x, int y){
        this.x=x;
        this.y=y;

        velocityX=speed;
        velocityY=speed;

        boundingBox = new Rectangle(x,y, size, size);               //invisible rect for ball to check collision with paddles
        boundingBox.setBounds(this.x,this.y,this.size,this.size);
    }
    public void tick(Game game) {               //win condition and add player scores
        boundingBox.setBounds(x,y,size,size);

        if(game.p1score == 10 || game.p2score ==10)
            Game.stop();
        if( x <= 0 ){
            game.p2score++;
            velocityX=speed;
        }else if(x + size >= game.WIDTH){
            game.p1score++;
            velocityX =-speed;
        }
        if(y < 32){
            velocityY = speed;
            Game.musicplayer.playFX("audio/pongblip.wav");
        }else if ( y  >= game.HEIGHT-size){
            velocityY=-speed;
            Game.musicplayer.playFX("audio/pongblip.wav");
        }

        x += velocityX;
        y += velocityY;

        paddleCollide(game);
    }

        private void paddleCollide(Game game) {
        if(boundingBox.intersects(game.player.boundingBox)){
            velocityX=speed;
            Game.musicplayer.playFX("audio/pongblip.wav");
        }else if(boundingBox.intersects(game.ai.boundingBox)){
            velocityX=-speed;
            Game.musicplayer.playFX("audio/pongblip.wav");
            }
        }

    public void render(Graphics g){
        g.setColor(Color.RED);
        g.fillOval(x,y,size,size);
    }
}
