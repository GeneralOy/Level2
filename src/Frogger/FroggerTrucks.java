
package Frogger;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class FroggerTrucks {
	public int y;
	public int x;
	public int fps;
	int xspeed;
	String name;
	public BufferedImage logImage;
	String image;

	public FroggerTrucks(int x,  int y, String name, int xspeed, String image) {
		this.x = x;
		this.y = y;
		this.name = name;
		this.image = image;
		this.xspeed = xspeed;

		if (image.equals("ltruck")) {
			try {
				logImage = ImageIO.read(this.getClass().getResourceAsStream("../FroggerTruck2.png"));

			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (image.equals("rtruck")) {
			try {
				logImage = ImageIO.read(this.getClass().getResourceAsStream("../Froggertruck1.png"));

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	void update() {
		if (this.fps >= 60) {
			this.fps -= 59;
		} else {
			this.fps++;
		}
		if (name.equals("rtruck")) {
			if (x >= 540) {
				x = -300;
			} else {
				x += xspeed;
			}
		} else if (name.equals("ltruck")) {
			if (x <= -300) {
				x = 520;
			} else {
				x += xspeed;
			}
		}
	}

	void draw(Graphics g) {
		g.drawImage(logImage, x, y, null);
	}
}
