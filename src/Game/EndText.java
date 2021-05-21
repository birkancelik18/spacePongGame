package Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import Game.Scene.GameWindow;

public class EndText {

	public EndText(){
		
			}
	
	public void  draw(Graphics g) {
		
		g.setColor(Color.red);
		g.setFont(new Font("Serif",Font.BOLD,80));
		g.drawString("< THE END >" , GameWindow.WINDOW_WIDTH/2-250,GameWindow.WINDOW_HEIGHT/2-150);
		
		Graphics g2 =  g;
		g2.setColor(Color.black);
		g2.setFont(new Font("Serif",Font.BOLD,20));
		g2.drawString("Rerun the code to play again." , GameWindow.WINDOW_WIDTH/2-150,GameWindow.WINDOW_HEIGHT/2-80);
	}
	
	
}
