import javax.swing.JFrame;

public class FroggerMain {
	int width;
	int height;
	int testx;
	GamePanel mainFroggerPanel;
	JFrame mainFrame = new JFrame();
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		FroggerMain froggerMain = new FroggerMain(516,576);
	}
	
	public FroggerMain(int width, int height) {
		
		this.width = width;
		this.height = height;
		mainFroggerPanel = new GamePanel();
		mainFrame.add(mainFroggerPanel);
		mainFrame.setSize(width, height);
		mainFrame.setVisible(true);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}
