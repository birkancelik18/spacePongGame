package Game.topElements;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Score {
	/**
	 * Class that contains score information for the game.
	 */
	private int score;
	public Score() {
		score=0;
	}
	public void draw(Graphics g) {
		g.setColor(Color.black);
		g.setFont(new Font("Serif", Font.BOLD, 30));
		g.drawString("Score: " + score,  400, 50);

	}
	
	public int getScore() {
		return score;
	}
	public void increaseScore() {
		score++;
	}
	
	public void increaseScoreByStar() {
		score+=3;
	}

}
