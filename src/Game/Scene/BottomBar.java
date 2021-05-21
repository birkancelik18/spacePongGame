package Game.Scene;

import java.awt.Button;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

public class BottomBar extends JPanel {
	/**
	 * This class contains buttons for game. 
	 * Panel at bottom of the screen
	 */
	public final static int WINDOW_WIDTH = GameWindow.WINDOW_WIDTH; // px
	public final static int WINDOW_HEIGHT = GameWindow.WINDOW_HEIGHT; // px

	private Button b1;
	private Button b2;
	private Button b4;

	public BottomBar() {

		// Create Buttons
		b1 = new Button("Play  ");
		b1.setBackground(Color.cyan);
		b2 = new Button("Pause ");
		b2.setBackground(Color.cyan);
		b4 = new Button("Shuffle ");
		b4.setBackground(Color.cyan);
		
		// add buttons to panel.
		this.add(b1);
		this.add(b2);
		this.add(b4);
		
		// set them as "not focusable" to be able to use paddle properly after buttons used.
		b1.setFocusable(false);
		b2.setFocusable(false);
		b4.setFocusable(false);
		
		b1.setVisible(true);
		b2.setVisible(true);
		b4.setVisible(true);

	}
	public Button getPlay() {
		return b1;
	}
	public Button getPause() {
		return b2;
	}
	public Button getShuffle() {
		return b4;
	}
}
