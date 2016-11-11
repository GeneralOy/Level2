import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener {
	Timer timer;
	public String collision;
	public String collisionY;
	public Image Froggerbackground;
	FroggerObject Frog;
	int frogX;
	int frogY;
	int log1;
	int log2;
	int log3;
	int log4;
	int rTruck1;
	int rTruck2;
	int lTruck1;
	int lTruck2;
	//ImageObject log3;
	//ImageObject log1;
	//ImageObject log2;
	//ImageObject log4;
	//ImageObject LTruck1;
	//ImageObject LTruck2;
	//ImageObject RTruck1;
	//ImageObject RTruck2;
	//ImageObject splash;
	//ImageObject backgroundPane;
	FrogsLogs FullLog1;
	BufferedImage background;
	BufferedImage LTruck1Image;
	BufferedImage frogImage;
	BufferedImage logImage;
	BufferedImage Rtruck;
	BufferedImage Ltruck;
	Image image;


	public GamePanel() {
		FullLog1 = new FrogsLogs(0,60, "log1", 10);
		/** VV Image Prep VV **/
		
		try {
			frogImage = ImageIO.read(this.getClass().getResourceAsStream("Frogger.png"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}try {
			background = ImageIO.read(this.getClass().getResourceAsStream("Frogger Background.png"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}try {
			logImage = ImageIO.read(this.getClass().getResourceAsStream("FroggerLog.png"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}try {
			Rtruck = ImageIO.read(this.getClass().getResourceAsStream("Froggertruck1.png"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}try {
			Ltruck = ImageIO.read(this.getClass().getResourceAsStream("Froggertruck2.png"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/**VV ASSORTED CODE VV**/
		Frog = new FroggerObject(20, 20, 64, 64);
		timer = new Timer(1000 / 60, this);
		timer.start();
		System.out.println(" " + FullLog1.x);
		log1 ++;
		repaint();
	}

	// VV Images VV//
	public void paintComponent(Graphics g) {
		g.drawImage(background, 0, 0, null);
		g.drawImage(logImage, log1, 60, null);
		g.drawImage(logImage, log2, 105, null);
		g.drawImage(logImage, log3, 150, null);
		g.drawImage(logImage, log4, 195, null);
		g.drawImage(frogImage, frogX, frogY, null);
		g.drawImage(Rtruck, rTruck1, frogY, null);
		g.drawImage(Rtruck, rTruck2, frogY, null);
		g.drawImage(Ltruck, lTruck1, frogY, null);
		g.drawImage(Ltruck, lTruck2, frogY, null);
		g.drawImage(frogImage, frogX, frogY, null);
		//frogX ++;
		FullLog1.update();
	}

	// VV Frog Movement VV//
	@Override
	public void actionPerformed(ActionEvent e) {

	}

	// VV X-Axis Collision VV//
	//**public boolean collisionX(GameObject objectCollision) {
		/**if (objectCollision.x >= log1.x && objectCollision.x <= log1.x + 20) {
			collision = "object1";
		}
		if (objectCollision.x >= log2.x && objectCollision.x <= log2.x + 20) {
			collision = "object1";
		}
		if (objectCollision.x >= log3.x && objectCollision.x <= log3.x + 10) {
			collision = "object3";
		}
		if (objectCollision.x >= log4.x && objectCollision.x <= log4.x + 13) {
			collision = "Log4";
		}
		if (objectCollision.x >= LTruck1.x && objectCollision.x <= LTruck1.x + 15) {
			collision = "L1";
		}
		if (objectCollision.x >= LTruck2.x && objectCollision.x <= LTruck2.x + 50) {
			collision = "L2";
		}
		if (objectCollision.x >= RTruck1.x && objectCollision.x <= RTruck1.x + 50) {
			collision = "R1";
		}
		if (objectCollision.x >= RTruck2.x && objectCollision.x <= RTruck2.x + 50) {
			collision = "R2";
		}
		if (objectCollision.name.equals(collision)) {
			return false;
		} else {
			return true;
		}
	}**/

	////////////////// Y AXIS COLLISION//////////////////
	/**public boolean collisionY(GameObject objectCollision) {
		if (objectCollision.y >= log1.y && objectCollision.y <= log1.y + 15) {
			collisionY = "object1";
		}
		if (objectCollision.y >= log2.y && objectCollision.y <= log2.y + 25) {
			collisionY = "object3";
		}
		if (objectCollision.y >= log3.y && objectCollision.y <= log3.y + 19) {
			collisionY = "object5";
		}
		if (objectCollision.y >= log4.y && objectCollision.y <= log4.y + 15) {
			collisionY = "object4";
		}
		if (objectCollision.y >= LTruck1.y && objectCollision.y <= LTruck1.y + 15) {
			collisionY = "blackobject";
		}
		if (objectCollision.y >= LTruck2.y && objectCollision.y <= LTruck2.y + 15) {
			collisionY = "blackobject";
		}
		if (objectCollision.y >= RTruck1.y && objectCollision.y <= RTruck1.y + 15) {
			collisionY = "blackobject";
		}
		if (objectCollision.y >= RTruck2.y && objectCollision.y <= RTruck2.y + 15) {
			collisionY = "blackobject";
		}
		if (objectCollision.name.equals(collisionY)) {
			return false;
		} else {
			return true;
		}
	}**/

}
//TRASH CODE

// VVtrash codeVV//
// ImageObject Gamebackground;
// BufferedImage buffered = (BufferedImage) image;
// ImageIcon backgroundIcon = new ImageIcon("FroggerBackgroundCopy.png");
// Gamebackground.x = 0;
// Gamebackground.y = 0;

// VVtrash codeVV
// this.set
// = new JLabel();
// backgroundPane.setIcon(backgroundPane);
// Gamebackground = new ImageObject(0, 0, 0, 0, 0, 0, background,
// "background");
// object3 = new ImageObject(770, 9, 5, 800, 10, 25, Color.BLUE,
// "object3");
// object4 = new ImageObject(540, 7, 7, 390, 13, 19, Color.RED,
// "object4");
// object5 = new ImageObject(200, 3, 2, 300, 15, 15, Color.GREEN,
// "object5");
// blackobject = new ImageObject(900, 1, 0, 300, 50, 15, Color.BLACK,
// "blackobject");
// background = (BufferedImage) image;
// ImageObject backgroundPane = new ImageObject(0, 0, 0, 0, 516, 560,
// background, "backgroundImage");
// imageB =
// ImageIO.read(this.getClass().getResourceAsStream("FroggerBackgroundCopy.png"))

/** VVTrash CodeVV
/** Gamebackground.draw(g);
/** object1.draw(g);
/** blackobject.draw(g);
/** object3.draw(g);
/** object4.draw(g);
/** object5.draw(g);*/

// VVTrash CodeVV//
/**
 * object1.update(); object3.update(); object4.update();
 * object5.update(); blackobject.update();
 **/
// System.out.println("hi");
// repaint();