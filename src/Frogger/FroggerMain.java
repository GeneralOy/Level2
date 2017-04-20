package Frogger;

import javax.swing.JFrame;

/*Keith was here*/
public class FroggerMain {
	int width;
	int height;
	int testx;

	GamePanel mainFroggerPanel;
	FroggerKeyManager KeyManager;
	String Keymanagerthing;
	JFrame mainFrame = new JFrame();

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		FroggerMain froggerMain = new FroggerMain(620, 860);
	}//516, 560 //56, 86

	public FroggerMain(int width, int height) {

		this.width = width;
		this.height = height;
		mainFroggerPanel = new GamePanel();
		KeyManager = new FroggerKeyManager();
		mainFrame.addKeyListener(KeyManager);
		mainFrame.add(mainFroggerPanel);
		mainFrame.setSize(width, height);
		System.out.println(Keymanagerthing);
		mainFrame.setVisible(true);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}
