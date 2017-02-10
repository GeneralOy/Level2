package Frogger;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	public Boolean collision;
	Timer timer;
	// public String collision;
	public String collisionY;
	public String frogDirectionPasser;
	public Image Froggerbackground;
	public Boolean isMoving;
	public String keyTyped1;
	public int key;
	public KeyListener keylistener1;
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
	// ImageObject log3;
	// ImageObject log1;
	// ImageObject log2;
	// ImageObject log4;
	// ImageObject LTruck1;
	// ImageObject LTruck2;
	// ImageObject RTruck1;
	// ImageObject RTruck2;
	// ImageObject splash;
	// ImageObject backgroundPane;
	HashMap<Integer, String> keyPressed = new HashMap<Integer, String>();
	public String frogDirection;
	FrogsLogs RLog1;
	FrogsLogs RLog2;
	FrogsLogs LLog1;
	FrogsLogs RLog3;
	FroggerTrucks rtruck1;
	FroggerTrucks rtruck2;
	FroggerTrucks ltruck1;
	FroggerTrucks ltruck2;
	BufferedImage background;
	BufferedImage LTruck1Image;
	BufferedImage frogImage;
	BufferedImage logImage;
	BufferedImage Rtruck;
	BufferedImage Ltruck;
	Image image;
	int counter;
	int W = new Integer(KeyEvent.VK_W);
	int A = new Integer(KeyEvent.VK_A);
	int S = new Integer(KeyEvent.VK_S);
	int D = new Integer(KeyEvent.VK_D);

	public GamePanel() {
		frogDirection = "up";
		// keyPressed.put(KeyEvent.VK_W, "W");
		// keyPressed.put(KeyEvent.VK_A, "A");
		// keyPressed.put(KeyEvent.VK_S, "S");
		// keyPressed.put(KeyEvent.VK_D, "D");

		RLog1 = new FrogsLogs(log1, 60, "rlog", 8, "log");
		RLog2 = new FrogsLogs(log2, 105, "rlog", 7, "log");
		LLog1 = new FrogsLogs(log3, 150, "llog", -8, "log");
		RLog3 = new FrogsLogs(log4, 195, "rlog", 6, "log");
		rtruck1 = new FroggerTrucks(rTruck1, 285, "rtruck", 10, "rtruck");
		rtruck2 = new FroggerTrucks(rTruck2, 375, "rtruck", 8, "rtruck");
		ltruck1 = new FroggerTrucks(lTruck1, 325, "ltruck", -7, "ltruck");
		ltruck2 = new FroggerTrucks(lTruck2, 415, "ltruck", -5, "ltruck");

		/** VV Image Prep VV **/
		/**
		 * try { frogImage =
		 * ImageIO.read(this.getClass().getResourceAsStream("../Frogger.png"));
		 * 
		 * } catch (IOException e) { e.printStackTrace(); }
		 **/

		try {
			background = ImageIO.read(this.getClass().getResourceAsStream("../Frogger Background.png"));

		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			logImage = ImageIO.read(this.getClass().getResourceAsStream("../FroggerLog.png"));

		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			Rtruck = ImageIO.read(this.getClass().getResourceAsStream("../Froggertruck1.png"));

		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			Ltruck = ImageIO.read(this.getClass().getResourceAsStream("../Froggertruck2.png"));

		} catch (IOException e) {
			e.printStackTrace();
		}

		/** VV ASSORTED CODE VV **/
		Frog = new FroggerObject(195, 195, 64, 64, "up");
		// System.out.println("asdf");
		timer = new Timer(1000 / 60, this);
		timer.start();
		// System.out.println(" " + FullLog1.x);
		repaint();
	}

	// VV Images VV//
	public void paintComponent(Graphics g) {
		// if(isMoving){

		/*
		 * log1 += 6; log2 += 5; log3 += -10; log4 += -7; // } if (log1 >= 520)
		 * { log1 = -300; } if (log2 >= 530) { log2 = -290; } if (log3 <= -320)
		 * { log3 = 520; } if (log4 >= 520) { log4 = -290; } if (rTruck1 >= 520)
		 * { rTruck1 = -300; } if (rTruck2 >= 530) { rTruck2 = -290; } if
		 * (lTruck1 <= -320) { lTruck1 = 520; } if (lTruck2 >= 520) { lTruck2 =
		 * -290; }
		 */
		g.drawImage(background, 0, 0, null);
		RLog1.draw(g);
		RLog2.draw(g);
		LLog1.draw(g);
		RLog3.draw(g);

		/*
		 * g.drawImage(logImage, log1, 60, null); g.drawImage(logImage, log2,
		 * 105, null); g.drawImage(logImage, log3, 150, null);
		 * g.drawImage(logImage, log4, 195, null);
		 */
		Frog.draw(g);
		/*
		 * g.drawImage(Rtruck, rTruck1, frogY, null); g.drawImage(Rtruck,
		 * rTruck2, frogY, null); g.drawImage(Ltruck, lTruck1, frogY, null);
		 * g.drawImage(Ltruck, lTruck2, frogY, null);
		 */
		// g.drawImage(frogImage, frogX, frogY, null);
		// FullLog1.update();

		rtruck1.draw(g);
		rtruck2.draw(g);
		ltruck1.draw(g);
		ltruck2.draw(g);
		System.out.println("DRAW");
	}

	// VV Frog Movement VV//
	@Override
	public void actionPerformed(ActionEvent e) {
		// String PerformedAction =

		// THIS IS A THING.
		if (Frog.x >= rtruck1.x && Frog.x <= rtruck1.x + 124) {
			if (Frog.y >= 285 && Frog.y <= 325) {
				collision = true;
				System.out.println("Collided1");
			}
		}
		if (Frog.x >= rtruck2.x && Frog.x <= rtruck2.x + 124) {
			if (Frog.y >= 375 && Frog.y <= 415) {
				collision = true;
				System.out.println("Collided2");
			}
		}
		if (Frog.x >= ltruck1.x && Frog.x <= ltruck1.x + 180) {
			if (Frog.y >= 325 && Frog.y <= 370) {
				collision = true;
				System.out.println("Collided3");

			}
		}
		if (Frog.x >= ltruck2.x && Frog.x <= ltruck2.x + 180) {
			if (Frog.y >= 415 && Frog.y <= 460) {
				collision = true;
				System.out.println("Collided4");
			}
		}
		// Log collision
		if (Frog.x >= RLog1.x && Frog.x <= RLog1.x + 176) {
			if (Frog.y >= 60 && Frog.y <= 100) {
				collision = true;
				System.out.println("Log1");
				Frog.x += 8;
			}
		}
		if (Frog.x >= RLog2.x && Frog.x <= RLog2.x + 176) {
			if (Frog.y >= 105 && Frog.y <= 145) {
				collision = true;
				System.out.println("Log2");
				Frog.x += 7;
			}
		}
		if (Frog.x >= LLog1.x && Frog.x <= LLog1.x + 176) {
			if (Frog.y >= 150 && Frog.y <= 190) {
				collision = true;
				System.out.println("Log3");
				Frog.x -= 8;
			}
		}
		if (Frog.x >= RLog3.x && Frog.x <= RLog3.x + 176) {
			if (Frog.y >= 195 && Frog.y <= 235) {
				collision = true;
				System.out.println("Log4");
				Frog.x += 6;
			}
		}
		if (Frog.x < 0) {
			Frog.isMovingLeft = false;
		}
		if (Frog.x > 516) {
			Frog.isMovingRight = false;
			System.out.println("516 +");
		}
		if (Frog.x > 0) {
			Frog.isMovingLeft = true;
		}
		if (Frog.x < 516) {
			Frog.isMovingRight = true;
		}
		if (Frog.y < 0) {
			Frog.isMovingUp = false;
		}
		if (Frog.y > 556) {
			Frog.isMovingDown = false;
		}
		if (Frog.y > 0) {
			Frog.isMovingUp = true;
		}
		if (Frog.y < 556) {
			Frog.isMovingDown = true;
		}
		RLog1.update();
		LLog1.update();
		RLog2.update();
		RLog3.update();
		// Frog.directionFromPanel = Fr;
		// setDirectiontoFrog(frogDirectionPasser);
		Frog.update();
		rtruck1.update();
		rtruck2.update();
		ltruck1.update();
		ltruck2.update();
		repaint();
	}

	public void keyTyped(KeyEvent e) {
		key = e.getKeyCode();
		System.out.println("RUNNING");
		System.out.println(keyTyped1);
		if (key == KeyEvent.VK_W) {
			frogY -= 10;
			keyTyped1 = "w";
			System.out.println("w");
			frogDirection = "up";
		}
		if (key == A) {
			keyTyped1 = "a";
			System.out.println("a");
			frogDirection = "left";
		}
		if (key == S) {
			keyTyped1 = "s";
			System.out.println("s");
			frogDirection = "down";
		}
		if (key == D) {
			keyTyped1 = "d";
			System.out.println("d");
			frogDirection = "right";
		}
		System.out.println("key");
		// Frog.setDirection(frogDirection);
	}

	public void keyPressed(KeyEvent e) {
		System.out.println("KP RUNNING");
		isMoving = true;
	}

	public void keyReleased(KeyEvent e) {
		isMoving = false;
		System.out.println("KR RUNNING");
	}

	/*
	 * public void setDirectiontoFrog(String direction) {
	 * //Frog.directionFromPanel = direction; }
	 */

	// VV X-Axis Collision VV//
	// **public boolean collisionX(GameObject objectCollision) {
	/**
	 * if (objectCollision.x >= log1.x && objectCollision.x <= log1.x + 20) {
	 * collision = "object1"; } if (objectCollision.x >= log2.x &&
	 * objectCollision.x <= log2.x + 20) { collision = "object1"; } if
	 * (objectCollision.x >= log3.x && objectCollision.x <= log3.x + 10) {
	 * collision = "object3"; } if (objectCollision.x >= log4.x &&
	 * objectCollision.x <= log4.x + 13) { collision = "Log4"; } if
	 * (objectCollision.x >= LTruck1.x && objectCollision.x <= LTruck1.x + 15) {
	 * collision = "L1"; } if (objectCollision.x >= LTruck2.x &&
	 * objectCollision.x <= LTruck2.x + 50) { collision = "L2"; } if
	 * (objectCollision.x >= RTruck1.x && objectCollision.x <= RTruck1.x + 50) {
	 * collision = "R1"; } if (objectCollision.x >= RTruck2.x &&
	 * objectCollision.x <= RTruck2.x + 50) { collision = "R2"; } if
	 * (objectCollision.name.equals(collision)) { return false; } else { return
	 * true; } }
	 **/

	////////////////// Y AXIS COLLISION//////////////////
	/**
	 * public boolean collisionY(GameObject objectCollision) { if
	 * (objectCollision.y >= log1.y && objectCollision.y <= log1.y + 15) {
	 * collisionY = "object1"; } if (objectCollision.y >= log2.y &&
	 * objectCollision.y <= log2.y + 25) { collisionY = "object3"; } if
	 * (objectCollision.y >= log3.y && objectCollision.y <= log3.y + 19) {
	 * collisionY = "object5"; } if (objectCollision.y >= log4.y &&
	 * objectCollision.y <= log4.y + 15) { collisionY = "object4"; } if
	 * (objectCollision.y >= LTruck1.y && objectCollision.y <= LTruck1.y + 15) {
	 * collisionY = "blackobject"; } if (objectCollision.y >= LTruck2.y &&
	 * objectCollision.y <= LTruck2.y + 15) { collisionY = "blackobject"; } if
	 * (objectCollision.y >= RTruck1.y && objectCollision.y <= RTruck1.y + 15) {
	 * collisionY = "blackobject"; } if (objectCollision.y >= RTruck2.y &&
	 * objectCollision.y <= RTruck2.y + 15) { collisionY = "blackobject"; } if
	 * (objectCollision.name.equals(collisionY)) { return false; } else { return
	 * true; } }
	 **/

}
// TRASH CODE

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

/**
 * VVTrash CodeVV /** Gamebackground.draw(g); /** object1.draw(g); /**
 * blackobject.draw(g); /** object3.draw(g); /** object4.draw(g); /**
 * object5.draw(g);
 */

// VVTrash CodeVV//
/**
 * object1.update(); object3.update(); object4.update(); object5.update();
 * blackobject.update();
 **/
// System.out.println("hi");
// repaint();