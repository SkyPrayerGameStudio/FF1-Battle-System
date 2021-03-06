package scenes.TitleScene.GUI;

import graphics.SWindow;
import graphics.Sprite;

import java.awt.Graphics;

import scenes.HUD;

/**
 * TitleScreen
 * @author nhydock
 *
 *	Main title screen
 */
public class TitleScreen extends HUD {

	Sprite background;		//title screen background image
	SWindow window;			//window frame for displaying commands
	
	int index;				//command index
	
	/**
	 * Constructs a title screen element
	 */
	public TitleScreen() {
		background = new Sprite("titlebackground.png");
		window = new SWindow(8, 160, 90, 60);
	}
	
	/**
	 * Paints the title screen
	 */
	@Override
	public void paint(Graphics g)
	{
		window.paint(g);
		font.drawString(g, "New Game", 2, 16, window);
		font.drawString(g, "Continue", 2, 34, window);
	}

	/**
	 * Updates the display
	 */
	@Override
	public void update() {
	}
	
	@Override
	public int[] updateArrowPosition(int index)
	{
		return new int[]{window.getX()-4, window.getY()+16+(index*18)};
	}
}
