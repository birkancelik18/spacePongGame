package Game.animatingElements;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Game.Scene.GameWindow;

public class Paddle extends Rectangle implements KeyListener {
	
	private static int widthPaddle = 120;
	private static int heightPaddle = 10;

	private int velocity = 30;
	private boolean paddleRight; // it turns to true as user presses right arrow
	private boolean paddleLeft; // it turns to true as user presses left arrow
	private boolean pausePaddle; //

	public Paddle(int x, int y) {

		this.x = x;
		this.y = y;
		this.width = widthPaddle;
		this.height = heightPaddle;

	}

	public void draw(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(x, y, width, height);
	}

	/**
	 * Makes horizontal move of paddle works by boolean inputs comes from left and
	 * right arrow keys
	 */
	public void makeMove() {
		if (paddleRight & !pausePaddle) {
			if (x <= (GameWindow.WINDOW_WIDTH - 120)) {
				x += velocity;
			} else {
			}
		} else if (paddleLeft & !pausePaddle) {
			if (x > 0) {
				x -= velocity;
			} else {
				x = 0;
			}
		} else {
		}
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			this.paddleRight = true;
			this.paddleLeft = false;
			this.pausePaddle = false;
			// System.out.println("inside paddle");
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			this.paddleRight = false;
			this.paddleLeft = true;
			this.pausePaddle = false;
		}

	}


	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			this.paddleRight = false;
			this.paddleLeft = false;
			this.pausePaddle = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {

			this.paddleRight = false;
			this.paddleLeft = false;
			this.pausePaddle = false;
		}

	}
	public void keyTyped(KeyEvent e) {
		/*
		 *implemented due to KeyListener interface usage
		 */
	}

}
