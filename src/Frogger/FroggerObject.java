package Frogger;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class FroggerObject {
	BufferedImage frogImage;
	/* To-Do List */
	/** ->background set to frogger background */
	/* create images of logs 1-4, trucks 1-4 */
	/*-> create images of frog, able to turn */
	/* create movement-WASD w/ switch to arrows */
	/* create sensors for collision */

	int y;
	int x;
	int w;
	int h;
	boolean isMoving;

	public FroggerObject(int x, int y, int w,
			int h /** int xspeed, int yspeed */
	) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		try {
			frogImage = ImageIO.read(this.getClass().getResourceAsStream("../Frogger.png"));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	void update() {
		if (FroggerKeyManager.down) {
			goDown();
			// System.out.println("downUPDATE");
			FroggerKeyManager.down = false;
		}
		if (FroggerKeyManager.right) {
			goRight();
			FroggerKeyManager.right = false;
		}
		if (FroggerKeyManager.left) {
			goLeft();
			FroggerKeyManager.left = false;
		}
		if (FroggerKeyManager.up) {
			goUp();
			FroggerKeyManager.up = false;
		}
	}

	/*
	 * public boolean dispatchKeyEvent(KeyEvent e) { if (e.getID() ==
	 * KeyEvent.KEY_PRESSED) {
	 * 
	 * if (e.getKeyCode() == KeyEvent.VK_RIGHT){ goRight(); } if (e.getKeyCode()
	 * == KeyEvent.VK_LEFT){ goLeft(); } if (e.getKeyCode() == KeyEvent.VK_UP){
	 * goUp(); } if (e.getKeyCode() == KeyEvent.VK_DOWN){ goDown(); } return
	 * isMoving; }else {
	 * 
	 * return isMoving = false; }
	 * 
	 * }
	 */
	public void goUp() {
		// TODO Auto-generated method stub
		System.out.println("up");
		y -= 45;
	}

	public void goDown() {
		// TODO Auto-generated method stub
		System.out.println("down");
		y += 45;
	}

	public void goLeft() {
		// TODO Auto-generated method stub
		System.out.println("left");
		x -= 45;
	}

	public void goRight() {
		// TODO Auto-generated method stub
		System.out.println("right");
		x += 45;
	}

	public void draw(Graphics g) {
		g.drawImage(frogImage, x, y, null);
	}

}
// TRASH CODE
// String name;
// int yspeed;
// int xspeed;
