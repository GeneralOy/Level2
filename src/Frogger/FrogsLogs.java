package Frogger;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class FrogsLogs {
	public int y;
	public int x;
	public int fps;
	int xspeed;
	// int ySpeed;
	String name;
	public BufferedImage logImage;
	String image;

	public FrogsLogs(int x, /* int xspeed, int ySpeed */ int y, String name, int xspeed, String image) {
		this.x = x;
		this.y = y;
		this.name = name;
		this.image = image;
		this.xspeed = xspeed;

		if (image.equals("log")) {
			try {
				logImage = ImageIO.read(this.getClass().getResourceAsStream("../FroggerLog.png"));

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// x->700, 750, 800
		// y->300, 350, 400
	}

	void update() {
		System.out.println("" + this.fps);
		if (this.fps >= 60) {
			this.fps -= 59;
		} else {
			this.fps++;
		}
		if (name.equals("rlog")) {
			if (x >= 520) {
				x = -300;
			} else {
				x += xspeed;
			}
		} else if (name.equals("llog")) {
			if (x <= -300) {
				x = 520;
			} else {
				x += xspeed;
			}
		}
	}

	void draw(Graphics g) {
		g.drawImage(logImage, x, y, null);
		// g.setColor(color);
		// g.fillRect(x, y, width, height);
	}

	public void checkCollision() {

	}
}