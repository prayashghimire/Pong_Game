import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Paddle extends Rectangle {

	//ids for paddle1 or paddle2
	int id;
	int Yvelocity;
	int speed = 10;
	
	Paddle(int x,int y, int PADDLE_WIDTH, int PADDLE_HEIGHT, int id){
		
		//calling the constructor of Rectangle class
		super (x,y,PADDLE_WIDTH,PADDLE_HEIGHT);
		this.id = id;
		
	}
	public void keyPressed(KeyEvent e) {
		
		switch(id) {
		
		case 1:
			if(e.getKeyCode() == KeyEvent.VK_W) {
				setYdirection(-speed);
				move();
			}
			if(e.getKeyCode() == KeyEvent.VK_S) {
				setYdirection(speed);
				move();
			}
			break;
			
			case 2:
				if(e.getKeyCode() == KeyEvent.VK_UP) {
					setYdirection(-speed);
					move();
				}
				if(e.getKeyCode() == KeyEvent.VK_DOWN) {
					setYdirection(speed);
					move();
				}
				break;
		}
		
		
	}
	public void keyReleased(KeyEvent e) {
		
		switch(id) {
		
		case 1:
			if(e.getKeyCode() == KeyEvent.VK_W) {
				setYdirection(-speed);
				move();
			}
			if(e.getKeyCode() == KeyEvent.VK_S) {
				setYdirection(speed);
				move();
			}
			break;
			
			case 2:
				if(e.getKeyCode() == KeyEvent.VK_UP) {
					setYdirection(0);
					move();
				}
				if(e.getKeyCode() == KeyEvent.VK_DOWN) {
					setYdirection(0);
					move();
				}
				break;
		}
		
	}
	public void setYdirection(int yd) {
		
		Yvelocity = yd;
		
	}
	public void move() {
		
		y = y + Yvelocity;
		
	}
	public void draw(Graphics g) {
		
		if(id == 1) {
			g.setColor(Color.blue);
		}
		else {
			g.setColor(Color.red);
		}
		g.fillRect(x, y	, width, height);
		
	}
	public void movePaddle2(double ballY) {
		
		int paddleCenter = y + height/2;
		
		int bally = (int) ballY;
		
		if(ballY < paddleCenter) 
			setYdirection(-speed);//moving the paddle upwards
		else
			setYdirection(speed);//moving the paddle downwards

			
		move();	
		
	}
}
