package Game.topElements;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

public class GameTime extends Rectangle {
	/**
	 * Class that is responsible for 60 seconds game periods.
	 */
	private final int LEVEL_TIME = 60;

	int miliSec;
	private int timeLeft = LEVEL_TIME;

	public GameTime(int miliSec) {
		this.miliSec = miliSec;
	}

	public int getTimeLeft() {
		return this.timeLeft;
	}

	public void setTimeLeft(int sec) {
		this.timeLeft = sec;
	}

	public void decreasetimeLeft(Level level) {
		if (timeLeft != 0) {
			this.timeLeft--;
		} else {
			timeLeft = LEVEL_TIME;
			level.levelUp();
		}
	}

	public void draw(Graphics g) {
		g.setColor(Color.black);
		g.setFont(new Font("Serif", Font.BOLD, 30));
		g.drawString("Time: " + timeLeft, 0, 50);

	}

}
