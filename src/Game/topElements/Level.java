package Game.topElements;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Level {
	/**
	 * Class for game level information. 
	 */
	
	int level = 1;

	private Boolean levelUp;

	public Level() {

		levelUp = false;
	}

	public int getLevel() {
		return this.level;
	}

	public void levelUp() {
		this.level++;
		levelUp = true;
	}

	public boolean getIsLevelUp() {
		return levelUp;
	}

	public void setLevelUp() {
		this.levelUp = false;
	}

	public void draw(Graphics g) {

		g.setColor(Color.black);
		g.setFont(new Font("Serif", Font.BOLD, 30));
		g.drawString("Level: " + level, 200, 50);
		levelUp = false;

	}
}
