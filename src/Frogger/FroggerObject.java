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
	public int SplashStage;
	boolean isMovingUp;
	boolean isMovingDown;
	boolean isMovingLeft;
	boolean isMovingRight;
	boolean isDead;
	boolean Drown;
	boolean gameWon;
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

	public FroggerObject(int x, int y, int w, int h, String direction) {
		gameWon = false;
		SplashStage = 0;
		isDead = false;
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.direction = direction;
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
		frogImage = up;
	}

	void update() {

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
				}
			}

		}

		System.out.println("YAY");
		if (gameWon) {
			if (FroggerKeyManager.ReStart) {
				x = 190 + 50;
				y = 510 + 30;
			}
		} else {
			if (isDead == false) {
				if (FroggerKeyManager.down) {
					if (isMovingDown = true) {
						if (y >= 500) {
						}else {
							goDown();
						}
					}
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
	}

	public void goUp() {
		frogImage = up;
		System.out.println("up");
		if (y >= 5) {
			y -= 45;
		}
	}

	public void goDown() {
		if (y <= 565) {
			frogImage = down;
			System.out.println("down");
			y += 45;
		} else {
			frogImage = up;
		}
	}

	public void goLeft() {
		frogImage = right;
		System.out.println("left");
		x -= 45;
		if ((y <= 539
				&& y >= 285 + 75) /** || (y <= 330 + 75 && y >= 55 + 75) */
		) {
			if (x <= 0 + 50) {
				x += 45;
			}
		} else if (y >= 330 + 75 && y <= 55 + 75) {
			System.out.println("River");
		} else if (x <= 25) {

			x = 510;
		}
	}

	public void goRight() {
		frogImage = left;
		System.out.println("right");
		x += 45;
		if ((y <= 539
				&& y >= 285 + 75) /** || (y <= 330 + 75 && y >= 55 + 75) */
		) {
			if (x >= 516 + 5) {
				x -= 45;
			}
		} else if (y <= 330 + 75 && y >= 55 + 75) {
			System.out.println("River");
		} else if (x >= 511) {
			x = 60;
		}
	}

	public void draw(Graphics g) {
		g.drawImage(frogImage, x, y, null);

	}

}
