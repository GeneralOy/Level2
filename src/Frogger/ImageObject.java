package Frogger;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class ImageObject {
	int x;
	int xspeed;
	int yspeed;
	int y;
	int w;

	int h;
	BufferedImage frog;
	BufferedImage background;
	BufferedImage truck2;
	BufferedImage truck1;
	BufferedImage logs;
	String name;

	public ImageObject(int x, int xspeed, int yspeed, int y, int w, int h, BufferedImage i, String name) {
		this.x = x;
		this.y = y;
		this.xspeed = xspeed;
		this.yspeed = yspeed;
		this.w = w;
		this.h = h;
		this.frog = i;
		this.name = name;
	}

	void update() {

	}

	void draw(Graphics g/** , Image imageName **/
	) {
		g.drawImage(/** imageName **/
				frog, x, y, w, h, null);
	}
}
