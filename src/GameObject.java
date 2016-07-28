import java.awt.Color;
import java.awt.Graphics;

public class GameObject {
	int y;
	int x;
	int xSpeed;
	int ySpeed;
	int width;
	int height;
	String name;
	Color color;

	public GameObject(int x, int xspeed, int ySpeed, int y, int w, int h, Color c, String name) {
		this.x = x;
		this.y = y;
		this.ySpeed = ySpeed;
		this.xSpeed = xspeed;
		this.width = w;
		this.height = h;
		this.color = c;
		this.name = name;
		// x->700, 750, 800
		// y->300, 350, 400
	}

	void update() {
		x += xSpeed;
		y += ySpeed;
		//xSpeed++;
		ySpeed++;
		/*
		 * if(x>=750){
		 * 
		 * } if(x >= 800) { xSpeed = -xSpeed; }if(x <= 700) { xSpeed = -xSpeed;
		 * }if(y >= 400) { ySpeed = -ySpeed; }if(y <= 300) { ySpeed = -ySpeed; }
		 */

		if (x >= 1500) {
			x = 1499;
			xSpeed = -xSpeed;
			//xSpeed--;
		}
		if (x <= 0) {
			x = 1;
			xSpeed = -xSpeed;
			//xSpeed++;
		}
		if (y >= 725) {
			
			y = 724;
			ySpeed = -ySpeed;//(ySpeed/2);
		}
		if (y <= 0) {
			y = 1;
			ySpeed = -ySpeed;
		}
	}

	void draw(Graphics g) {
		g.setColor(color);
		g.fillRect(x, y, width, height);
	}
}
