import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener{
	Timer timer;
	GameObject object1;
	public GamePanel() {
		object1 = new GameObject(750,5,5,300,15,15,Color.ORANGE);
		timer = new Timer(1000/60, this);
		timer.start();
		
	}
	public void paintComponent(Graphics g){
		object1.draw(g);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		//System.out.println("hi");
		object1.update();
		repaint();
	}
}
