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
import java.util.TimerTask;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	public boolean collision;
	public boolean frogIsDead;
	public boolean gameOverThing;
	Timer timer;
	// public String collision;
	public int LifeCounter;
	public String collisionY;
	public String frogDirectionPasser;
	public Image Froggerbackground;
	public boolean isMoving;
	public boolean hitByTruck;
	public boolean gameWinThing;
	public String keyTyped1;
	public int key;
	public boolean timerBool;
	ActionEvent t;
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
	Random randomSpeed = new Random();
	int truckSpeed1;
	int truckSpeed2;
	int truckSpeed3;
	int truckSpeed4;
	int logSpeed1;
	int logSpeed2;
	int logSpeed3;
	int logSpeed4;
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
	int timerInt;
	FrogsLogs RLog1;
	FrogsLogs RLog2;
	FrogsLogs LLog1;
	FrogsLogs RLog3;
	FroggerTrucks rtruck1;
	FroggerTrucks rtruck2;
	FroggerTrucks ltruck1;
	FroggerTrucks ltruck2;
	BufferedImage ArcadeMachineBackground;
	BufferedImage WASDInstructions;
	BufferedImage gameOverR;
	BufferedImage gameOverB;
	BufferedImage background;
	BufferedImage LTruck1Image;
	BufferedImage frogImage;
	BufferedImage logImage;
	BufferedImage Rtruck;
	BufferedImage Ltruck;
	BufferedImage WinScreen1;
	BufferedImage N3c;
	BufferedImage N2c;
	BufferedImage N1c;
	BufferedImage N0cR;
	BufferedImage HEALTH;
	Image image;
	int counter;
	int W = new Integer(KeyEvent.VK_W);
	int A = new Integer(KeyEvent.VK_A);
	int S = new Integer(KeyEvent.VK_S);
	int D = new Integer(KeyEvent.VK_D);
	int R = new Integer(KeyEvent.VK_R);

	public GamePanel() {
		LifeCounter = 3;
		timerInt = 0;
		frogIsDead = false;
		gameWinThing = false;
		frogDirection = "up";
		hitByTruck = false;
		logSpeed1 = /* 9 */randomSpeed.nextInt(15);
		logSpeed2 = /* 7 */randomSpeed.nextInt(13);
		logSpeed3 = /*-8*/randomSpeed.nextInt(9) - 10;
		logSpeed4 = /* 6 */randomSpeed.nextInt(10);
		truckSpeed1 = /* 10 */randomSpeed.nextInt(19) + 1;
		truckSpeed2 = /* 8 */randomSpeed.nextInt(9) + 1;
		truckSpeed3 = /*-7*/randomSpeed.nextInt(15) - 16;
		truckSpeed4 = /*-5*/randomSpeed.nextInt(12) - 13;
		RLog1 = new FrogsLogs(log1 + 50, 60 + 76, "rlog", logSpeed1, "log");
		RLog2 = new FrogsLogs(log2 + 50, 105 + 76, "rlog", logSpeed2, "log");
		LLog1 = new FrogsLogs(log3 + 50, 150 + 76, "llog", logSpeed3, "log");
		RLog3 = new FrogsLogs(log4 + 50, 195 + 76, "rlog", logSpeed4, "log");
		rtruck1 = new FroggerTrucks(rTruck1 + 50, 285 + 75, "rtruck", truckSpeed1, "rtruck");
		rtruck2 = new FroggerTrucks(rTruck2 + 50, 375 + 75, "rtruck", truckSpeed2, "rtruck");
		ltruck1 = new FroggerTrucks(lTruck1 + 50, 325 + 75, "ltruck", truckSpeed3, "ltruck");
		ltruck2 = new FroggerTrucks(lTruck2 + 50, 415 + 75, "ltruck", truckSpeed4, "ltruck");

		/** VV Image Prep VV **/
		try {
			WASDInstructions = ImageIO.read(this.getClass().getResourceAsStream("../wasd.png"));
			N3c = ImageIO.read(this.getClass().getResourceAsStream("../NUMBERS3c.png"));
			N2c = ImageIO.read(this.getClass().getResourceAsStream("../NUMBERS2c.png"));
			N1c = ImageIO.read(this.getClass().getResourceAsStream("../NUMBERS1c.png"));
			N0cR = ImageIO.read(this.getClass().getResourceAsStream("../NUMBERS0cR.png"));
			HEALTH = ImageIO.read(this.getClass().getResourceAsStream("../healthCv3.png"));
			background = ImageIO.read(this.getClass().getResourceAsStream("../Frogger Background Timer.png"));
			gameOverR = ImageIO.read(this.getClass().getResourceAsStream("../GameOverRedV3.png"));
			gameOverB = ImageIO.read(this.getClass().getResourceAsStream("../GameOverBlackV2.png"));
			logImage = ImageIO.read(this.getClass().getResourceAsStream("../FroggerLog.png"));
			Rtruck = ImageIO.read(this.getClass().getResourceAsStream("../Froggertruck1.png"));
			Ltruck = ImageIO.read(this.getClass().getResourceAsStream("../Froggertruck2.png"));
			WinScreen1 = ImageIO.read(this.getClass().getResourceAsStream("../You-WinScreen.png"));
			ArcadeMachineBackground = ImageIO.read(this.getClass().getResourceAsStream("../ArcadeTextureMAIN.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		/** VV ASSORTED CODE VV **/
		Frog = new FroggerObject(190 + 50, 510 + 30, 64, 64, "up");
		timer = new Timer(1000 / 60, this);
		timer.start();
		repaint();
	}

	// VV Images VV//
	public void paintComponent(Graphics g) {
		System.out.println("{" + timer.toString() + "}" + "DELAY; " + timer.getDelay());

		g.drawImage(background, 50, 76, null);
		if (Frog.isDead) {
			Frog.draw(g);
			RLog1.draw(g);
			RLog2.draw(g);
			LLog1.draw(g);
			RLog3.draw(g);
		}

		RLog1.draw(g);
		RLog2.draw(g);
		LLog1.draw(g);
		RLog3.draw(g);
		if (LifeCounter == 3) {
			g.drawImage(N3c, 210, 580, null);
		} else if (LifeCounter == 2) {
			g.drawImage(N2c, 210, 580, null);
		} else if (LifeCounter == 1) {
			g.drawImage(N1c, 210, 580, null);
		} else if (LifeCounter == 0) {
			g.drawImage(N0cR, 210, 580, null);
		} else {

		}
		g.drawImage(HEALTH, 55, 580, null);
		Frog.draw(g);

		rtruck1.draw(g);
		rtruck2.draw(g);
		ltruck1.draw(g);
		ltruck2.draw(g);
		System.out.println("DRAW");
		if (gameWinThing) {
			Frog.gameWon = true;
			System.out.println("YOU WIN!");
			g.drawImage(WinScreen1, 8 + 50, 110 + 75, null);
		} else if (frogIsDead) {
			if (gameOverThing) {
				System.out.println("Frog is dead");
				if (LifeCounter <= 0) {
					g.drawImage(gameOverR, 110 + 50, 110 + 75, null);
				}
			}

		}

		g.drawImage(ArcadeMachineBackground, 0, 0, null);
		g.drawImage(WASDInstructions, 240, 700, null);
		System.out.println("" + ArcadeMachineBackground.getWidth());
		System.out.println("" + ArcadeMachineBackground.getHeight());
	}

	// VV Frog Movement VV//
	public void actionPerformed(ActionEvent e) {
		if (frogIsDead || gameOverThing || gameWinThing) {
			if (FroggerKeyManager.ReStart && LifeCounter <= 0) {
				Frog.gameWon = false;
				Frog.SplashStage = 2;
				frogIsDead = false;
				gameOverThing = false;
				gameWinThing = false;
				Frog.isDead = false;
				Frog.Drown = false;
				Frog.frogImage = Frog.up;
				Frog.x = 190 + 50;
				Frog.y = 510 + 30;
				LifeCounter = 3;
				hitByTruck = false;
			} else if (LifeCounter > 0 || (Frog.SplashStage >= 11 && LifeCounter > 0)) {
				if (frogIsDead && Frog.SplashStage >= 11) {
					// Frog.gameWon = false;
					Frog.SplashStage = 2;
					frogIsDead = false;
					gameOverThing = false;
					gameWinThing = false;
					Frog.isDead = false;
					Frog.Drown = false;
					Frog.frogImage = Frog.up;
					Frog.x = 190 + 50;
					Frog.y = 510 + 30;
					LifeCounter -= 1;
					System.out.println("LIVES LEFT; " + LifeCounter + "////////////////////////////");
					hitByTruck = false;
					timer.setDelay(1000 / 60);
				} else if (frogIsDead && hitByTruck) {
					Frog.SplashStage = 2;
					frogIsDead = false;
					gameOverThing = false;
					gameWinThing = false;
					Frog.isDead = false;
					Frog.Drown = false;
					Frog.frogImage = Frog.up;
					Frog.x = 190 + 50;
					Frog.y = 510 + 30;
					LifeCounter -= 1;
					System.out.println("LIVES LEFT; " + LifeCounter + "////////////////////////////");
					hitByTruck = false;
				} else if (gameWinThing && LifeCounter >= 0 && FroggerKeyManager.ReStart) {
					Frog.gameWon = false;
					Frog.SplashStage = 2;
					frogIsDead = false;
					gameOverThing = false;
					gameWinThing = false;
					Frog.isDead = false;
					Frog.Drown = false;
					Frog.frogImage = Frog.up;
					Frog.x = 190 + 50;
					Frog.y = 510 + 30;
					LifeCounter = 3;
					hitByTruck = false;
				}
			}
		}

		if (Frog.y <= 55 + 75) {
			System.out.println("You win!");
			gameWinThing = true;
			Frog.gameWon = true;
		} else {
		}
		if (Frog.y >= 550 + 5) {
			Frog.y -= 45;
		} else {
			//////////////////////////////////////////////////////////
			if ((Frog.y >= 415 + 75 && Frog.y <= 460 + 75)&&(Frog.x + 43 >= ltruck2.x && Frog.x + 43 <= ltruck2.x + 180)||(Frog.x + 43 >= ltruck1.x && Frog.x + 43 <= ltruck1.x + 180)&&(Frog.y >= 325 + 75 && Frog.y <= 370 + 75)||(Frog.x + 43 >= rtruck1.x && Frog.x <= rtruck1.x + 124) && (Frog.y >= 285 + 75 && Frog.y <= 325 + 75) || (Frog.x + 43 >= rtruck2.x && Frog.x <= rtruck2.x + 124) && (Frog.y >= 375 + 75 && Frog.y <= 415 + 75)) {
				hitByTruck = true;
				collision = true;
				System.out.println("Collided1");
				Frog.isDead = true;
				frogIsDead = true;
				if (LifeCounter >= 0) {
					gameOverThing = true;
				}
			}
			//////////////////////////////////////// Log collision
			if (Frog.isDead) {
				System.out.println("Yup I'm [dead]");
				if (Frog.Drown) {
					if (Frog.SplashStage <= 11) {
						timer.setDelay(1000 / 25);
						timerInt++;
						Frog.SplashStage++;
						gameOverThing = false;
					} else {
						timer.setDelay(1000 / 60);
						timerInt++;
						Frog.SplashStage++;
						if (LifeCounter <= 0) {
							gameOverThing = true;
						}
					}
				} else {
					timer.setDelay(1000 / 60);
				}
			} else {
				if (Frog.y >= 60 + 75 && Frog.y <= 100 + 75) {
					if (Frog.x + 21 >= RLog1.x && Frog.x + 21 <= RLog1.x + 176) {
						collision = true;
						System.out.println("Log1");
						Frog.x += logSpeed1;
					} else {
						Frog.Drown = true;
						frogIsDead = true;
						Frog.isDead = true;

					}
				}
				if (Frog.y >= 105 + 75 && Frog.y <= 145 + 75) {
					if (Frog.x + 21 >= RLog2.x && Frog.x + 21 <= RLog2.x + 176) {
						collision = true;
						System.out.println("Log2");
						Frog.x += logSpeed2;
					} else {
						Frog.Drown = true;
						frogIsDead = true;
						Frog.isDead = true;
					}
				}
				if (Frog.y >= 150 + 75 && Frog.y <= 190 + 75) {
					if (Frog.x + 21 >= LLog1.x && Frog.x + 21 <= LLog1.x + 176) {
						collision = true;
						System.out.println("Log3");
						Frog.x += logSpeed3;
					} else {
						Frog.Drown = true;
						frogIsDead = true;
						Frog.isDead = true;
						for (int i = 0; i < 5000; i++) {
							System.out.println("Ded log1");
						}
						System.out.println("Ded log1");
					}
				}
				if (Frog.y >= 195 + 75 && Frog.y <= 235 + 75) {
					if (Frog.x + 21 >= RLog3.x && Frog.x + 21 <= RLog3.x + 176) {
						collision = true;
						System.out.println("Log4");
						Frog.x += logSpeed4;
					} else {
						Frog.Drown = true;
						frogIsDead = true;
						Frog.isDead = true;
					}
				}
			}
		}
		///////////////////////////////////////////////////////////////////////////////
		// *****************vvTHINGS TO WORK ON HEREvv***************** //
		// ******************>>>NOTHING TO SEE HERE<<<******************//
		// *****************^^THINGS TO WORK ON HERE^^***************** //

		RLog1.update();
		LLog1.update();
		RLog2.update();
		RLog3.update();
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
	}

	public void keyPressed(KeyEvent e) {
	}

	public void keyReleased(KeyEvent e) {
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
if (Frog.x + 43 >= rtruck2.x && Frog.x <= rtruck2.x + 124) {
	if (Frog.y >= 375 + 75 && Frog.y <= 415 + 75) {
		hitByTruck = true;
		collision = true;
		System.out.println("Collided2");
		Frog.isDead = true;
		frogIsDead = true;
		if (LifeCounter >= 0) {
			gameOverThing = true;
		}
	}
}
if (Frog.x + 43 >= ltruck1.x && Frog.x + 43 <= ltruck1.x + 180) {
	if (Frog.y >= 325 + 75 && Frog.y <= 370 + 75) {
		hitByTruck = true;
		collision = true;
		System.out.println("Collided3");
		Frog.isDead = true;
		frogIsDead = true;
		if (LifeCounter >= 0) {
			gameOverThing = true;
		}
	}
}
if (Frog.x + 43 >= ltruck2.x && Frog.x + 43 <= ltruck2.x + 180) {
	if (Frog.y >= 415 + 75 && Frog.y <= 460 + 75) {
		hitByTruck = true;
		collision = true;
		System.out.println("Collided4");
		Frog.isDead = true;
		frogIsDead = true;
		if (LifeCounter >= 0) {
			gameOverThing = true;
		}
	}
}**/
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