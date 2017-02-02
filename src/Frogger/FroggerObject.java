package Frogger;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class FroggerObject {
	BufferedImage frogImage;
	/* To-Do List */
	/** ->background set to frogger background */
	/** create images of logs 1-4, trucks 1-4 */
	/** create images of frog, *//* able to turn */
	/** create movement-WASD w/ *//* switch to arrows */
	/* create sensors for collision */

	int y;
	int x;
	int w;
	int h;
	boolean isMoving;
	String direction = "left";
	BufferedImage up;
	BufferedImage right;
	BufferedImage left;
	BufferedImage down;

	public FroggerObject(int x, int y, int w, int h,
			String direction/* int xspeed, int yspeed */) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.direction = direction;
		try {
			up = ImageIO.read(this.getClass().getResourceAsStream("../Frogger.png"));

		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			right = ImageIO.read(this.getClass().getResourceAsStream("../Frogger 2.png"));

		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			left = ImageIO.read(this.getClass().getResourceAsStream("../Frogger 3.png"));

		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			down = ImageIO.read(this.getClass().getResourceAsStream("../Frogger 4.png"));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	void update() {
		System.out.println("frog.update");
		if (direction.equals("up")) {
			frogImage = up;
			System.out.println("up");
		}
		if (direction.equals("right")) {
			frogImage = right;
			System.out.println("right");
		}
		if (direction.equals("left")) {
			frogImage = left;
			System.out.println("Left");
		}
		if (direction.equals("down")) {
			frogImage = down;
			System.out.println("down");
		}
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

	public void setDirection(String direction) {
		this.direction = direction;
	}

}
// TRASH CODE
// String name;
// int yspeed;
// int xspeed;
