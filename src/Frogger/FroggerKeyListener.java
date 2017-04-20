package Frogger;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;

public class FroggerKeyListener extends KeyAdapter {
	HashMap<Integer, String> keys = new HashMap<Integer, String>();
	private String keyString;
	private int imageIndex;

	private void KeysSetup() {
		keys.put(new Integer(KeyEvent.VK_W), "W");
		keys.put(new Integer(KeyEvent.VK_A), "A");
		keys.put(new Integer(KeyEvent.VK_S), "S");
		keys.put(new Integer(KeyEvent.VK_D), "D");
		keys.put(new Integer(KeyEvent.VK_R), "R");
	}


}