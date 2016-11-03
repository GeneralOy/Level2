import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class FrogsLogs {
	public int y;
	public int x;
	// int xSpeed;
	// int ySpeed;
	String name;
	BufferedImage logImage;
	public FrogsLogs(int x, /* int xspeed, int ySpeed */ int y, String name, int xspeed) {
		this.x = x;
		this.y = y;
		this.name = name;
		try {
			logImage = ImageIO.read(this.getClass().getResourceAsStream("FroggerLog.png"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		// x->700, 750, 800
		// y->300, 350, 400
	}

	void update() {
		
	}
	
	void draw(Graphics g) {
		g.drawImage(logImage, x, y, null);
		//g.setColor(color);
		//g.fillRect(x, y, width, height);
	}
}