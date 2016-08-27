import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
	
public class ImageObject {
	int frogx;
	int xspeed;
	int yspeed;
	int frogy;
	int w;
	
	int h;
	BufferedImage frog;
	BufferedImage background;
	BufferedImage truck2;
	BufferedImage truck1;
	BufferedImage logs;
	String name;
	public ImageObject(int x, int xspeed, int yspeed, int y, int w, int h, BufferedImage i, String name) {
	this.frogx = x;
	this.frogy = y;
	this.xspeed = xspeed;
	this.yspeed = yspeed;
	this.w = w;
	this.h = h;
	this.frog = i;
	this.name = name;
	}
	void update() {
		
	}
	void draw(Graphics g) {
		g.drawImage(frog, frogx, frogy, w, h, null);
	}
}
