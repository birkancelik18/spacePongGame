package Game.animatingElements;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import Game.Game;
import Game.Scene.GameWindow;
import Game.topElements.Level;

public class Ball extends Rectangle {

	private int radius;

	private double gravity = 9.81 / 1000;
	private double xSpeed;
	private double ySpeed;

	Boolean isMissed;
	Boolean isReal = false;

	private int xInitial = 10;
	private int yInitial = 10;
	private double xInitialVel;
	private double yInitialVel;

	private Level level;

	public Ball(int r, Level level) {
		/**
		 * Comment this out for random initial state demos
		 * and change variable with commented values at the same lines with the variables 
		 **/
		/*
		 * Random rand = new Random();
		 * 
		 * int randomXInitialVel = rand.nextInt(5); int randomYInitialVel =
		 * rand.nextInt(3);
		 * System.out.println("randomXInitialVel : = "+randomXInitialVel);
		 * System.out.println("randomYInitialVel : = "+randomYInitialVel);
		 * 
		 * int randomXInitialPos = rand.nextInt(GameWindow.WINDOW_WIDTH ); int
		 * randomYInitialPos = rand.nextInt(GameWindow.WINDOW_HEIGHT - (2 *
		 * GameWindow.WINDOW_HEIGHT / 8)-20);
		 * System.out.println("randomXInitialPos : = "+randomXInitialPos);
		 * System.out.println("randomYInitialPos : = "+randomYInitialPos);
		 */

		this.setLevel(level);

		this.x = xInitial; // randomXInitialPos;
		this.y = yInitial; // randomYInitialPos;
		this.radius = 2 * r;
		this.width = 2 * r;
		this.height = 2 * r;

		// Initialize V0 for velocity equation. It changes each new level.
		xInitialVel = 4 * (Math.pow(1.5, (level.getLevel()) - 1)); // randomXInitialVel
		yInitialVel = 1 * (Math.pow(1.5, (level.getLevel()) - 1)); // randomYInitialVel

		System.out.println("level: " + level.getLevel());
		System.out.println("xInitialVel: " + xInitialVel);
		System.out.println("yInitialVel: " + yInitialVel);

		xSpeed = xInitialVel;
		ySpeed = yInitialVel;

		isMissed = false;
	}

	public void draw(Graphics g) {

		g.setColor(Color.black);
		g.fillOval(this.x, this.y, width, height);

	}
	
	
	/*
	 * This function creates motion under gravity by changing velocity vector components 
	 * According to gravity effect
	 */
	
	public void makeMove(Paddle p) {
		ySpeed += gravity;
		this.y += ySpeed;
		this.x += (xSpeed);

		if ((this.x + radius * 2) >= Game.WINDOW_WIDTH || this.x <= 0) {
			xSpeed = -xSpeed;
		}
		if (this.intersects(p)) {
			ySpeed *= -1;
			isMissed = false;

		} else if (this.y >= 8 * GameWindow.WINDOW_HEIGHT / 9) {
			isMissed = true;
		}
		if (this.y <= 0) {
			ySpeed = -ySpeed;

		}
	}

	// GETTERS AND SETTERS
	public double getX() {
		return this.x;
	}

	public double getY() {
		return this.y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public double getXSpeed() {
		return xSpeed;
	}

	public double getYSpeed() {
		return ySpeed;
	}

	public void setXSpeed(double d) {
		this.xSpeed = d;
	}

	public void setYSpeed(double d) {
		this.ySpeed = d;
	}

	public boolean getIsMissed() {
		return isMissed;
	}

	public double getGravity() {
		return gravity;
	}

	public void setIsMissed(boolean b) {
		this.isMissed = false;

	}

	public double getInitialXSpeed() {
		return xInitialVel;
	}

	public double getInitialYSpeed() {
		return yInitialVel;
	}

	public void setInitialXSpeed(double newInitialX) {
		this.xInitialVel = newInitialX;
	}

	public void setInitialYSpeed(double newInitialY) {
		this.yInitialVel = newInitialY;
	}

	/**
	 * @return the level
	 */
	public Level getLevel() {
		return level;
	}

	/**
	 * @param level the level to set
	 */
	public void setLevel(Level level) {
		this.level = level;
	}

}
