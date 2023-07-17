import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

//implements Runnable because we want to run this on a thread
public class Game_Panel extends JPanel implements Runnable{

	//the variable are static to prevent sharing the same variable for multiple instances of the panel class
	static final int GAME_WIDTH = 1000;
	//giving the height corresponding to the width
	static final int GAME_HEIGHT = (int)(GAME_WIDTH * (0.5555));//5/9 is 0.5555
	static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH,GAME_HEIGHT);
	static final int BALL_DIAMETER = 20;
	static final int PADDLE_WIDTH = 25;
	static final int PADDLE_HEIGHT = 100;
	Thread gameThread;
	Image img;
	Graphics gr;
	Paddle paddle1;
	Paddle paddle2;
	Ball ball;
	Score score;
	
	Game_Panel(){
		
		newpaddle();
		newball();
		
		score = new Score(GAME_WIDTH,GAME_HEIGHT);
		this.setFocusable(true);
		this.addKeyListener(new ActionListener());
		this.setPreferredSize(SCREEN_SIZE);
		
		gameThread = new Thread(this);
		gameThread.start();
		
	}
	
	public void newball() {
		
	}
	public void newpaddle() {
							//x,y,width,heigt,this id the paddle id
		paddle1 = new Paddle(0,(GAME_HEIGHT/2)-(PADDLE_HEIGHT / 2),PADDLE_WIDTH,PADDLE_HEIGHT,1);
		paddle2 = new Paddle(GAME_WIDTH - PADDLE_WIDTH,(GAME_HEIGHT/2)-(PADDLE_HEIGHT / 2),PADDLE_WIDTH,PADDLE_HEIGHT,2);
		
	}
	public void paint(Graphics g) {
		//creating image that has same height and width as panel
		img = createImage(getWidth(),getHeight());
		gr = img.getGraphics();//creating the graphics
		draw(gr);
		g.drawImage(img, 0,0,this);
		
		
	}
	public void draw(Graphics g) {
		
		paddle1.draw(g);
		paddle2.draw(g);
		
	}
	public void move() {
		
	}
	public void check_collision() {
		
	}
	public void run() {
		
		//game loop
		long lasttime = System.nanoTime();
		double amountofticks = 60.0;
		double nanoseconds = 1000000000 / amountofticks;
		double delta;
		while(true) {
			
			long now = System.nanoTime();
			delta =+ (now-lasttime) / nanoseconds;
			lasttime = now;
			
			if(delta >= 1) {
				move();
				check_collision();
				repaint();
				delta --;
			}
		}
		
	}
	public class ActionListener extends KeyAdapter{
		
		public void keyPressed(KeyEvent e) {
			
			paddle1.keyPressed(e);
			paddle2.keyPressed(e);
			
			
		}
		public void keyReleased(KeyEvent e) {
			
			paddle1.keyReleased(e);
			paddle2.keyReleased(e);
			
			
		}
	}
}
