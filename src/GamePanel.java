import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener {
	Timer timer;
	public String collision;
	public String collisionY;
	GameObject object1;
	GameObject blackobject;
	GameObject object3;
	GameObject object4;
	GameObject object5;

	public GamePanel() {
		object1 = new GameObject(750, 7, 5, 300, 20, 15, Color.ORANGE, "object1");
		object3 = new GameObject(770, 9, 5, 800, 10, 25, Color.BLUE, "object3");
		object4 = new GameObject(540, 7, 7, 390, 13, 19, Color.RED, "object4");
		object5 = new GameObject(200, 3, 2, 300, 15, 15, Color.GREEN, "object5");
		blackobject = new GameObject(900, 1, 0, 300, 50, 15, Color.BLACK, "blackobject");
		timer = new Timer(1000 / 60, this);
		timer.start();

	}

	public void paintComponent(Graphics g) {
		object1.draw(g);
		blackobject.draw(g);
		object3.draw(g);
		object4.draw(g);
		object5.draw(g);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// System.out.println("hi");
		object1.update();
		object3.update();
		object4.update();
		object5.update();
		blackobject.update();
		repaint();
	}

	public boolean collisionX(GameObject objectCollision) {
		if (objectCollision.x >= object1.x && objectCollision.x <= object1.x + 20) {
			collision = "object1";
		}
		if (objectCollision.x >= object3.x && objectCollision.x <= object3.x + 10) {
			collision = "object3";
		}
		if (objectCollision.x >= object4.x && objectCollision.x <= object4.x + 13) {
			collision = "object4";
		}
		if (objectCollision.x >= object5.x && objectCollision.x <= object5.x + 15) {
			collision = "object5";
		}
		if (objectCollision.x >= blackobject.x && objectCollision.x <= blackobject.x + 50) {
			collision = "object";
		}
		if (objectCollision.name.equals(collision)) {
			return false;
		} else {
			return true;
		}
	}

	public boolean collisionY(GameObject objectCollision) {
		if (objectCollision.y >= object1.y && objectCollision.y <= object1.y + 15) {
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
