package Game.skyObjects;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import Game.Scene.GameWindow;

public class SkyObject extends Rectangle {

	/**
	 * Class to create UFO, Meteor and star.
	 */

	Image img;
	private final static int IMAGE_SIZE = 60;

	public SkyObject(String path) {
		// create instance of Random class
		Random rand = new Random();

		int rand_x = rand.nextInt(GameWindow.WINDOW_WIDTH - IMAGE_SIZE);
		int rand_y = rand.nextInt(GameWindow.WINDOW_HEIGHT - IMAGE_SIZE - 2 * GameWindow.WINDOW_HEIGHT / 8);

		this.x = rand_x;
		this.y = rand_y;
		this.width = IMAGE_SIZE;
		this.height = IMAGE_SIZE;

		try {
			img = ImageIO.read(new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void draw(Graphics g, Component c) {

		g.drawImage(img, x, y, width, height, c);

	}

	public Rectangle spaceObjAreaCreate(Rectangle r) {
		Rectangle specialArea = new Rectangle();

		specialArea.setBounds((int) r.getX(), (int) r.getY(), (int) r.getWidth(), (int) r.getHeight());

		return specialArea;
	}

}
