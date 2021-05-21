package Game;

import Game.Scene.BottomBar;
import Game.Scene.GameDynamics;
import Game.Scene.GameWindow;
import Game.Scene.TopBar;

public class Game {
	/**
	 * 
	 * Game panels are implemented here.
	 */
	
	public final static int WINDOW_WIDTH = 1024; // px
	public final static int WINDOW_HEIGHT = 768; // px
	
	
	static TopBar top = new TopBar();
	static BottomBar bot = new BottomBar();
	static GameDynamics game = new GameDynamics(top,bot);
	public static void main(String[] args) {
		
		GameWindow frame = new GameWindow(game,top,bot);
		
	}
}
