package Game.Scene;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameWindow extends JPanel {
	/**
	 * Game panels brought together here.
	 */
	public final static int WINDOW_WIDTH = 1024; // px
	public final static int WINDOW_HEIGHT = 768; // px
	

	private final JPanel topJPanel; // panel to hold score, time, lives
	private final JPanel midJPanel; // panel to hold space elements, ball and paddle
	private final JPanel botJPanel; // panel to hold pause and play buttons


	public GameWindow(GameDynamics game, TopBar top,BottomBar bot)  {
		
		JFrame f = new JFrame("Space Pong Game");
		
		// Create panels
		topJPanel = top;
		topJPanel.setBounds(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT /9);
		topJPanel.setBackground(Color.pink);

		midJPanel = game;
		midJPanel.setBounds(0, WINDOW_HEIGHT / 9, WINDOW_WIDTH, (WINDOW_HEIGHT*7/9));
		midJPanel.setBackground(Color.white);

		botJPanel = bot;
		botJPanel.setBounds(0, (WINDOW_HEIGHT*8/9), WINDOW_WIDTH,  WINDOW_HEIGHT /9);
		botJPanel.setBackground(Color.black);

		// Add panels and set window size etc.
		f.add(topJPanel);
		f.add(midJPanel);
		f.add(botJPanel);
		f.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLayout(null);
		f.setVisible(true);


	}
	

}
