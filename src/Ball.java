import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Ball extends Rectangle {

	Random rnd;
	int Xvelocity;
	int Yvelocity;
	
	
	
	Ball(int x, int y, int width, int height){
		
		super(x, y, width, height);
		rnd = new Random();
		int randomXdirection = rnd.nextInt(2);
		
		if(randomXdirection == 0) {
			//making the ball go left
			randomXdirection--;
			setXDirection(randomXdirection);
		}
		int randomYdirection = rnd.nextInt(2);
		
		if(randomYdirection == 0) {
			//making the ball go left
			randomYdirection--;
			setYDirection(randomYdirection);
		}
		
	}
	public void setXDirection(int randomX) {
		
		Xvelocity = randomX;
		
	}
	public void setYDirection(int randomY) {
		
		Yvelocity = randomY;
		
	}
	public void move() {
		
		x += Xvelocity;
		y += Yvelocity;
		
	}
	public void draw(Graphics g) {
		
		g.setColor(Color.yellow);
		g.fillOval(y, y, height, width);
		
	}
}
