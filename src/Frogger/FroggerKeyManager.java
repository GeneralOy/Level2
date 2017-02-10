package Frogger;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class FroggerKeyManager implements KeyListener {
	static boolean down = false;
	static boolean right = false;
	static boolean left = false;
	static boolean up = false;
	public static String frogDirection = "up";

	public FroggerKeyManager() {
		System.out.println("stuff");
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// System.out.println("KeyTyped");
		if (e.getKeyChar() == 's') {
			down = true;
			System.out.println("S");
			frogDirection = "down";
		}
		if (e.getKeyChar() == 'd') {
			right = true;
			System.out.println("D");
			frogDirection = "right";
		}
		if (e.getKeyChar() == 'a') {
			left = true;
			System.out.println("A");
			frogDirection = "left";
		}
		if (e.getKeyChar() == 'w') {
			up = true;
			System.out.println("W");
			frogDirection = "up";
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyChar() == 's') {
			down = false;
			// System.out.println("SR");
		}
		if (e.getKeyChar() == 'd') {
			right = false;
		}
		if (e.getKeyChar() == 'a') {
			left = false;
		}
		if (e.getKeyChar() == 'w') {
			up = false;
		}
	}

}
