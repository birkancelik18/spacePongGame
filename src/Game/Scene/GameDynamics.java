package Game.Scene;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import Game.EndText;
import Game.animatingElements.Ball;
import Game.animatingElements.Paddle;
import Game.skyObjects.SkyObject;

public class GameDynamics extends JPanel {
	/**
	 * This class implements whole game logic and animation events gets other to
	 * panels as parameters in constructor and updates them
	 */
	private static final long serialVersionUID = 1L;
	public final static int WINDOW_WIDTH = 1024;
	public final static int WINDOW_HEIGHT = 768;

	boolean rightClicked;

	TopBar top;
	BottomBar bot;

	Paddle paddle;
	Ball ball;

	SkyObject meteor;
	SkyObject star;
	SkyObject ufo;

	EndText theEnd;

	int level;

	private Image image;
	private Graphics graphics;


	Timer t;
	Boolean frozen;
	private int timeCount;

	private boolean isStarted = false;
	private boolean isPaused = true;

	private boolean starIntersectable = true;
	private boolean ufoIntersectable = true;
	private boolean metIntersectable = true;

	private int collisionCount;
	private boolean movePaddle;
	private boolean lifeKilled;
	
	
	/**
	 * 
	 * @param topBar
	 * @param bot
	 * Constructor for class. it initiates class variables and timer for animation.
	 */
	public GameDynamics(TopBar topBar, BottomBar bot) {

		timeCount = 0;
		collisionCount = 0;
		rightClicked = false;
		lifeKilled = false;
		setFocusable(true);

		this.top = topBar;
		this.bot = bot;

		createSjyObjects();
		this.level = topBar.lev.getLevel();

		bot.getPlay().addActionListener(new playListener());
		bot.getPause().addActionListener(new pauseListener());
		bot.getShuffle().addActionListener(new shuffleListener());

		ball = new Ball(10, top.lev);

		paddle = new Paddle(WINDOW_WIDTH / 2 - 60, (WINDOW_HEIGHT * 7 / 9) - 20);

		theEnd = new EndText();

		addKeyListener(paddle);

		isStarted = true;
		t = new Timer(20, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update();

			}
		});
	}
	
	
	
	
	/**
	 * Update function includes action that will be done in each 20 miliseconds.
	 */
	private void update() {

		timeCount++;
		if (timeCount % 50 == 0) {
			top.time.decreasetimeLeft(top.lev);
			if (top.lev.getIsLevelUp()) {
				this.ball = new Ball(10, top.lev);
			}

		}
		scoreCounter(ball, paddle);
		arrangeLives(ball, ufo);

		if (starCollides(ball, star)) {
			top.score.increaseScoreByStar();
		}

		if (metCollides(ball, ufo)) {
			ball.setXSpeed(ball.getXSpeed() * 1.5);
			ball.setYSpeed(ball.getYSpeed() * 1.5);
		}

		ball.makeMove(paddle);
		paddle.makeMove();

		if (top.lives.getLives() == 0) {

			t.stop();
		}

		if (ball.getIsMissed()) {
			top.lives.killLife();
			ball.setIsMissed(false);
			this.ball = new Ball(10, top.lev);

		}

		repaint();
		top.repaint();
		bot.repaint();

	}
		
	///////////ACTION LISTENERS FOR BUTTONS //////////////////
	
	/*
	 * Action listener for play button
	 */
	class playListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if (isStarted) {
				t.start();
			} else {
				t.start();
				isStarted = true;
			}
		}
	}
	
	/*
	 * Action listener for pause button
	 */
	class pauseListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			isPaused = true;
			t.stop();
		}
	}
	/*
	 * Action listener for shuffle button.
	 * If objects randomly created makes game unplayable 
	 * this button gives to user to recreate the sky objects,i.e. ufo, star, meteor.
	 */
	class shuffleListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			shuffleObjects();
		}
	}
	
	/**
	 * function that is called when shuffle button clicked. Recreates objects randomly.
	 */
	public void shuffleObjects() {
		this.star = new SkyObject("src/star_small.png");
		this.meteor = new SkyObject("src/meteorite_small.png");
		this.ufo = new SkyObject("src/ufoship_small.png");
	}

	
	/**
	 * Creates Ufo, Meteor and Star Objects  and recreates if any two of them intersects
	 */
	private void createSjyObjects() {
		star = new SkyObject("src/star_small.png");
		meteor = new SkyObject("src/meteorite_small.png");
		ufo = new SkyObject("src/ufoship_small.png");

		while (star.intersects(meteor) || star.intersects(ufo)) {
			System.out.println("star collided recreating...");
			star = new SkyObject("src/star_small.png");
		}
		while (meteor.intersects(star) || meteor.intersects(ufo)) {
			System.out.println("meteor collided recreating...");
			meteor = new SkyObject("src/meteorite_small.png");
		}
		while (ufo.intersects(meteor) || ufo.intersects(star)) {
			System.out.println("ufo collided recreating...");
			meteor = new SkyObject("src/meteorite_small.png");
		}
	}
	
	
	/**
	 * 
	 * @param ball
	 * @param ufo
	 * function controls lives of user
	 */
	public void arrangeLives(Ball ball, SkyObject ufo) {
		if (ufoCollides(ball, ufo)) {
			top.lives.killLife();
		}
		if (ball.getIsMissed()) {
			top.lives.killLife();
		}
	}
	
	/**
	 * 
	 * @param ball
	 * @param obj
	 * @return
	 * 	function checks collisions of ball and star object if collision 
	 */
	public Boolean starCollides(Ball ball, SkyObject obj) {

		if (!ball.intersects(star)) {
			starIntersectable = true;
		}
		if (starIntersectable && ball.intersects(star)) {
			starIntersectable = false;
			return true;
		}

		return false;
	}
	
	/**
	 * 
	 * @param ball
	 * @param paddle
	 * Increase score if ball intersects paddle
	 */
	public void scoreCounter(Ball ball, Paddle paddle) {
		if (ball.intersects(paddle)) {
			top.score.increaseScore();
		}
	}
	
	/**
	 * 
	 * @param ball
	 * @param obj
	 * @return
	 * Checks if ball collides UFO
	 */
	public Boolean ufoCollides(Ball ball, SkyObject obj) {

		if (!ball.intersects(ufo)) {
			ufoIntersectable = true;
		}

		if (ufoIntersectable && ball.intersects(ufo)) {
			ufoIntersectable = false;
			return true;
		}
		return false;
	}
	
	/**
	 * 
	 * @param ball
	 * @param obj
	 * @return
	 * Checks if ball collides meteor
	 */
	public Boolean metCollides(Ball ball, SkyObject obj) {

		if (!ball.intersects(meteor)) {
			metIntersectable = true;
		}

		if (metIntersectable && ball.intersects(meteor)) {
			metIntersectable = false;
			return true;
		}
		return false;
	}
	
	public void draw(Graphics g) {
		star.draw(g, this);
		meteor.draw(g, this);
		ufo.draw(g, this);
		paddle.draw(g);
		ball.draw(g);
		if (top.lives.getLives() == 0) {

			theEnd.draw(g);
			t.stop();
		}
	}

	public void paint(Graphics g) {
		image = createImage(getWidth(), getHeight());
		graphics = image.getGraphics();
		draw(graphics);
		g.drawImage(image, 0, 0, this);
	}

}
