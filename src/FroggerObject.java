import java.awt.Graphics;
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
	public FroggerObject(int x, int y, int w, int h /**int xspeed, int yspeed*/){
		try {
			frogImage = ImageIO.read(this.getClass().getResourceAsStream("Frogger.png"));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	void update(){
		
	}
	public void paintComponent(Graphics g) {
		g.drawImage(frogImage, 250, 250, null);


	}
	
}
//TRASH CODE
//String name;
//int yspeed;
//int xspeed;
