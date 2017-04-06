package Frogger;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import java.util.Timer;

import javax.imageio.ImageIO;

public class FroggerObject {
	BufferedImage frogImage;
	// String directionFromPanel;
	/* To-Do List */
	/** ->background set to frogger background */
	/** create images of logs 1-4, trucks 1-4 */
	/** create images of frog, able to turn */
	/** create movement-WASD w/ *//* switch to arrows */
	/** create sensors for collision */
	// public Boolean SplashOver;
	public int SplashStage;
	boolean isMovingUp;
	boolean isMovingDown;
	boolean isMovingLeft;
	boolean isMovingRight;
	boolean isDead;
	boolean Drown;
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
	BufferedImage runOverUp;
	BufferedImage runOverDown;
	BufferedImage runOverLeft;
	BufferedImage runOverRight;
	BufferedImage Splash1;
	BufferedImage Splash2;
	BufferedImage Splash3;
	BufferedImage Splash4;
	BufferedImage Splash5;
	BufferedImage Splash6;
	BufferedImage Splash7;
	Timer timer1;

	public FroggerObject(int x, int y, int w, int h,
			String direction/* int xspeed, int yspeed */) {
		SplashStage = 0;
		isDead = false;
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.direction = direction;
		// Frogger movement images start here
		try {
			up = ImageIO.read(this.getClass().getResourceAsStream("../Frogger.png"));
			right = ImageIO.read(this.getClass().getResourceAsStream("../Frogger 2.png"));
			left = ImageIO.read(this.getClass().getResourceAsStream("../Frogger 3.png"));
			down = ImageIO.read(this.getClass().getResourceAsStream("../Frogger 4.png"));
			runOverUp = ImageIO.read(this.getClass().getResourceAsStream("../FroggerRunOverUp.png"));
			runOverDown = ImageIO.read(this.getClass().getResourceAsStream("../FroggerRunOverDown.png"));
			runOverRight = ImageIO.read(this.getClass().getResourceAsStream("../FroggerRunOverLeft.png"));
			runOverLeft = ImageIO.read(this.getClass().getResourceAsStream("../FroggerRunOverRight.png"));
			Splash1 = ImageIO.read(this.getClass().getResourceAsStream("../splash_stage_1.png"));
			Splash2 = ImageIO.read(this.getClass().getResourceAsStream("../splash_stage_2.png"));
			Splash3 = ImageIO.read(this.getClass().getResourceAsStream("../splash_stage_3.png"));
			Splash4 = ImageIO.read(this.getClass().getResourceAsStream("../splash_stage_4.png"));
			Splash5 = ImageIO.read(this.getClass().getResourceAsStream("../splash_stage_5.png"));
			Splash6 = ImageIO.read(this.getClass().getResourceAsStream("../splash_stage_6.png"));
			Splash7 = ImageIO.read(this.getClass().getResourceAsStream("../splash_stage_7.png"));

		} catch (IOException e) {
			e.printStackTrace();
		}
		// SPLASH^^
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

		if (isDead == true) {
			if (Drown == false) {
				System.out.println("IS DEAD");
				if (frogImage == up) {
					frogImage = runOverUp;
				}
				if (frogImage == down) {
					frogImage = runOverDown;
				}
				if (frogImage == right) {
					frogImage = runOverLeft;
				}
				if (frogImage == left) {
					frogImage = runOverRight;
				}
			} else if (Drown == true) {
				if (SplashStage == 3) {
					frogImage = Splash1;
				} else if (SplashStage == 4) {
					frogImage = Splash2;
				} else if (SplashStage == 5) {
					frogImage = Splash3;
				} else if (SplashStage == 6) {
					frogImage = Splash4;
				} else if (SplashStage == 7) {
					frogImage = Splash5;
				} else if (SplashStage == 8) {
					frogImage = Splash6;
				} else if (SplashStage == 9) {
					frogImage = Splash7;
				} else if (SplashStage >= 10) {
					frogImage = null;
					// SplashOver = true;
				}
				/**
				 * for (int i = 0; i < 140000; i++) { if(i < 20000){ frogImage =
				 * Splash1; }if(i < 40000 || i > 19999){ frogImage = Splash2;
				 * }if(i < 60000 || i > 39999){ frogImage = Splash3; }if(i <
				 * 80000 || i > 59999){ frogImage = Splash4; }if(i < 100000 || i
				 * > 79999){ frogImage = Splash5; }if(i < 120000 || i > 99999){
				 * frogImage = Splash6; }if(i < 140000 || i > 119999){ frogImage
				 * = Splash7; }if(i >= 140000){ frogImage = null; } }
				 */
			}

		}

		System.out.println("YAY");
		if (isDead == false) {
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
		if(y >= 0){
		y -= 45;
		}
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
		if ((y <= 539 && y >= 285 + 75) /**|| (y <= 330 + 75 && y >= 55 + 75)*/) {
			if (x <= 0 + 50) {
				x += 45;
			}
		//} else if() {
		}else if(y >= 330 + 75 && y <= 55 + 75) {
			System.out.println("River");
		}else if (x <= 25) {
		
			x = 510;
		}
	}

	public void goRight() {
		frogImage = left;
		// TODO Auto-generated method stub
		System.out.println("right");
		x += 45;
		if ((y <= 539 && y>= 285+75) /**|| (y <= 330 + 75 && y >= 55 + 75)*/) {
			if (x >= 516 + 5) {
				x -= 45;
			}
		}else if(y <= 330 + 75 && y >= 55 + 75) {
			System.out.println("River");
		} else if (x >= 511) {
			x =  60;
		}
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
