package Game.Scene;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

import Game.animatingElements.Ball;
import Game.topElements.GameTime;
import Game.topElements.Level;
import Game.topElements.Lives;
import Game.topElements.Score;

public class TopBar extends JPanel {
	/**
	 * This panel contains buttons.
	 */
	public final static int WINDOW_WIDTH = 1024; // px
	public final static int WINDOW_HEIGHT = 768; // px


	GameTime time;
	Lives lives;
	Score score;
	Level lev;
	Ball ball;
	int timeCount = 0;
	private Image image;
	private Graphics graphics;
	

	public TopBar() {
	
		time = new GameTime(timeCount);
		lives = new Lives(3);
		score = new Score();
		lev = new Level();
	}

	public void draw(Graphics g) {
		time.draw(g);
		lives.draw(g);
		score.draw(g);
		lev.draw(g);

	}
	public void paint(Graphics g) {
		image = createImage(getWidth(), getHeight());
		graphics = image.getGraphics();
		draw(graphics);
		g.drawImage(image, 0, 0, this);
	}

}
