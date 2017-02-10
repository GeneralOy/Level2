package Frogger;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class FroggerObject {
	BufferedImage frogImage;
	// String directionFromPanel;
	/* To-Do List */
	/** ->background set to frogger background */
	/** create images of logs 1-4, trucks 1-4 */
	/** create images of frog, *//* able to turn */
	/** create movement-WASD w/ *//* switch to arrows */
	/* create sensors for collision */
	boolean isMovingUp;
	boolean isMovingDown;
	boolean isMovingLeft;
	boolean isMovingRight;
	int y;
	int x;
	int w;
	int h;

	String imageDirection;
	String direction = "up";
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
		frogImage = up;
	}

	void update() {
		// setDirection(directionFromPanel);
		System.out.println("frog.update");
		/*
		 * if (direction.equals("up")) { frogImage = up;
		 * System.out.println("up"); imageDirection = "up"; } if
		 * (direction.equals("right")) { frogImage = right;
		 * System.out.println("right"); imageDirection = "right"; } if
		 * (direction.equals("left")) { frogImage = left;
		 * System.out.println("Left"); imageDirection = "left"; } if
		 * (direction.equals("down")) { frogImage = down;
		 * System.out.println("down"); imageDirection = "down";
		 * System.out.println("DOWN"); }
		 */

		if (FroggerKeyManager.down) {
			if (isMovingDown = true) {
				goDown();
			}
			// System.out.println("downUPDATE");
			FroggerKeyManager.down = false;
		}
		if (FroggerKeyManager.right) {
			if (isMovingRight = true) {
				goRight();
			}
			FroggerKeyManager.right = false;
		}
		if (FroggerKeyManager.left) {
			if (isMovingLeft = true) {
				goLeft();
			}
			FroggerKeyManager.left = false;
		}
		if (FroggerKeyManager.up) {
			if (isMovingUp = true) {
				goUp();
			}
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
		frogImage = up;
		// TODO Auto-generated method stub
		System.out.println("up");
		y -= 45;

	}

	public void goDown() {
		frogImage = down;
		// TODO Auto-generated method stub
		System.out.println("down");
		y += 45;
	}

	public void goLeft() {
		frogImage = right;
		// TODO Auto-generated method stub
		System.out.println("left");
		x -= 45;
	}

	public void goRight() {
		frogImage = left;
		// TODO Auto-generated method stub
		System.out.println("right");
		x += 45;
	}

	public void draw(Graphics g) {
		g.drawImage(frogImage, x, y, null);
		// System.out.println("" + imageDirection + ";Frogimage = " +
		// frogImage.toString());

	}

	/*
	 * public void setDirection(String direction) { this.direction = direction;
	 * System.out.println("direction"); }
	 */

}
// TRASH CODE
// String name;
// int yspeed;
// int xspeed;
