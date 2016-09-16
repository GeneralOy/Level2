import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener {
	Timer timer;
	public String collision;
	public String collisionY;
	FroggerObject Frog;
	ImageObject log3;
	ImageObject log1;
	ImageObject log2;
	ImageObject log4;
	ImageObject LTruck1;
	ImageObject LTruck2;
	ImageObject RTruck1;
	ImageObject RTruck2;
	BufferedImage Gamebackground;

	public GamePanel() {

		// Gamebackground = (FroggerBackground.png);
		Frog = new FroggerObject(20, 20, 20, 20);
		// object3 = new ImageObject(770, 9, 5, 800, 10, 25, Color.BLUE,
		// "object3");
		// object4 = new ImageObject(540, 7, 7, 390, 13, 19, Color.RED,
		// "object4");
		// object5 = new ImageObject(200, 3, 2, 300, 15, 15, Color.GREEN,
		// "object5");
		// blackobject = new ImageObject(900, 1, 0, 300, 50, 15, Color.BLACK,
		// "blackobject");
		timer = new Timer(1000 / 60, this);
		timer.start();

	}

	public void paintComponent(Graphics g) {
		// object1.draw(g);
		// blackobject.draw(g);
		// object3.draw(g);
		// object4.draw(g);
		// object5.draw(g);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// System.out.println("hi");
		/**
		 * object1.update(); object3.update(); object4.update();
		 * object5.update(); blackobject.update(); repaint();
		 **/
	}

	public boolean collisionX(GameObject objectCollision) {
		if (objectCollision.x >= log1.x && objectCollision.x <= log2.x + 20) {
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
	}

	public boolean collisionY(GameObject objectCollision) {
		if (objectCollision.y >= log1.y && objectCollision.y <= log1.y + 15) {
			collisionY = "object1";
		}
		if (objectCollision.y >= object3.y && objectCollision.y <= object3.y + 25) {
			collisionY = "object3";
		}
		if (objectCollision.y >= object5.y && objectCollision.y <= object5.y + 19) {
			collisionY = "object5";
		}
		if (objectCollision.y >= object4.y && objectCollision.y <= object4.y + 15) {
			collisionY = "object4";
		}
		if (objectCollision.y >= blackobject.y && objectCollision.y <= blackobject.y + 15) {
			collisionY = "blackobject";
		}
		if (objectCollision.name.equals(collisionY)) {
			return false;
		} else {
			return true;
		}
	}

}
