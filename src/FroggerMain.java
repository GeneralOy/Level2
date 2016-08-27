import javax.swing.JFrame;

public class FroggerMain {
	int width;
	int height;
	GamePanel mainFroggerPanel;
	JFrame mainFrame = new JFrame();
	
	public static void main(String[] args) {
		FroggerMain froggerMain = new FroggerMain(1000,750);
	}
	
	public FroggerMain(int width, int height) {
	
		this.width = width;
		this.height = height;
		mainFroggerPanel = new GamePanel();
		mainFrame.add(mainFroggerPanel);
		mainFrame.setSize(width, height);
		mainFrame.setVisible(true);
		
	}
}
