package Game.topElements;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Lives {
	/**
	 * Class responsible for user lives.
	 */
	private int lives;

	public Lives(int lives) {
		this.lives = lives;
	}

	public void draw(Graphics g) {
		g.setColor(Color.black);
		g.setFont(new Font("Serif", Font.BOLD, 30));
		g.drawString("Lives: " + lives, 600,50 );
	}

	public int getLives() {
		return lives;
	}

	public void upLife() {
		this.lives++;
	}

	public void killLife() {
		if(lives>0) {
			this.lives--;
		}	
	}
}