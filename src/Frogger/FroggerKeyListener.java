package Frogger;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.util.Date;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class FroggerKeyListener extends KeyAdapter {
	HashMap<Integer, String> keys = new HashMap<Integer, String>();
	private String keyString;
	private int imageIndex;
	private void KeysSetup() {
		keys.put(new Integer(KeyEvent.VK_W), "W");
		keys.put(new Integer(KeyEvent.VK_A), "A");
		keys.put(new Integer(KeyEvent.VK_S), "S");
		keys.put(new Integer(KeyEvent.VK_D), "D");
	}
	
		//KeyListener FroggerKeyListener;

}