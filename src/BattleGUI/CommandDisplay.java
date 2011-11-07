package BattleGUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.File;

import scenes.Scene;

import actors.Actor;
import battleSystem.BattleState;
import battleSystem.BattleSystem;
import battleSystem.IssueState;

import engine.Sprite;

public class CommandDisplay extends Sprite{
	
	Window window;
	Sprite arrow;
	Font f;
	int index;
	
	BattleSystem parent;
	
	public CommandDisplay(int x, int y)
	{
		super(null);
		window = new Window(x, y, 110, 82);
		arrow = new Sprite("hud/selectarrow.png");
		try {
			f = Font.createFont(Font.TRUETYPE_FONT, new File("data/font/default.ttf"));
			f = new Font("serif", Font.PLAIN, 10);
		} catch (Exception e) {
			f = new Font("serif", Font.PLAIN, 10);
		}
	}
	
	public void setParentScene(BattleSystem bs)
	{
		parent = bs;
	}
	
	public void update(IssueState state)
	{
		this.index = state.getIndex();
	}
	
	/**
	 * Main render method
	 */
	public void paint(Graphics g)
	{
		//window is first sprite
		window.paint(g);
		
		g.setFont(f);
		g.setColor(Color.white);
		
		Actor a = parent.getActiveActor();
		for (int i = 0; i < a.getCommands().length; i++)
			g.drawString(a.getCommands()[i], window.getX() + 20 + 60*(i/4), 
							window.getY() + 24 + 16 * (i % 4));
		
		arrow.setX(window.getX() + 60*(index/4));
		arrow.setY(window.getY() + 24 + 16 * (index % 4) - arrow.getHeight()/2);
		arrow.paint(g);
	}
}