package Frogger;
import javax.swing.JFrame;

public class Window {
	int width;
	int height;
	GamePanel mainPanel;
	JFrame mainFrame = new JFrame();

	public static void main(String[] args) {
		Window main = new Window(516, 582);
	}

	public Window(int width, int height) {

		this.width = width;
		this.height = height;
		mainPanel = new GamePanel();
		mainFrame.add(mainPanel);
		mainFrame.setSize(width, height);
		mainFrame.setVisible(true);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}