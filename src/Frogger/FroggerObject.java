package Frogger;
import java.awt.Graphics;
import java.awt.KeyEventDispatcher;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class FroggerObject {
	BufferedImage frogImage;
	
	/* To-Do List */
		/**->background set to frogger background*/
	/* create images of logs 1-4, trucks 1-4*/
	/*-> create images of frog, able to turn */
	/* create movement-WASD w/ switch to arrows*/
	/* create sensors for collision*/

	int y;
	int x;
	int w;
	int h;
	boolean isMoving;
	public FroggerObject(int x, int y, int w, int h /**int xspeed, int yspeed*/){
		try {
			frogImage = ImageIO.read(this.getClass().getResourceAsStream("../Frogger.png"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	void update(){
		if(FroggerKeyManager.down){
			goDown();
			//System.out.println("downUPDATE");
			FroggerKeyManager.down = false;
		}if(FroggerKeyManager.right){
			goRight();
			FroggerKeyManager.right = false;
		}if(FroggerKeyManager.left){
			goLeft();
			FroggerKeyManager.left = false;
		}if(FroggerKeyManager.up){
			goUp();
			FroggerKeyManager.up = false;
			
		}
	}
	public void paintComponent(Graphics g) {
		g.drawImage(frogImage, x, y, null);
	}
	
	/*public boolean dispatchKeyEvent(KeyEvent e) {
		if (e.getID() == KeyEvent.KEY_PRESSED) {
			
				if (e.getKeyCode() == KeyEvent.VK_RIGHT){
					goRight();
				}
				if (e.getKeyCode() == KeyEvent.VK_LEFT){
					goLeft();
				}
				if (e.getKeyCode() == KeyEvent.VK_UP){
					goUp();
				}
				if (e.getKeyCode() == KeyEvent.VK_DOWN){
					goDown();
				}
				return isMoving;
		}else {
			
			return isMoving = false;
		}
		
	}*/
	public void goUp() {
		// TODO Auto-generated method stub
		System.out.println("up");
		y -= 5;
	}
	public void goDown() {
		// TODO Auto-generated method stub
		System.out.println("down");
		y += 5;
	}
	public void goLeft() {
		// TODO Auto-generated method stub
		System.out.println("left"); x -= 5;
	}
	public void goRight() {
		// TODO Auto-generated method stub
		System.out.println("right");
		x += 5;
	}
	
}
//TRASH CODE
//String name;
//int yspeed;
//int xspeed;
