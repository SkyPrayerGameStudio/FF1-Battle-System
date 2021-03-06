package scenes.TitleScene.System;

import audio.MP3;
import scenes.GameSystem;
import engine.Engine;

/**
 * TitleSystem
 * @author nhydock
 *
 *	Main title screen system
 */
public class TitleSystem extends GameSystem {

	Engine engine;
	
	IntroState is;		//state for showing the blue backed intro story
	TitleState ts;		//state for showing the title screen with choices
	
	MP3 music;
	
	/**
	 * Constructs the title system
	 */
	public TitleSystem()
	{
		engine = Engine.getInstance();
		
		is = new IntroState(this);
		ts = new TitleState(this);
		
		state = is;
		state.start();
		
		music = new MP3("intro.mp3");
		music.play();
	}

	@Override
	public void setNextState() {
		if (state == is)
		    state = ts;
		else
			state = is;
		state.start();
	}

	/**
	 * Goes into the game
	 */
	@Override
	public void finish() {
		if (ts.index == 0)
			engine.changeToCreation();
		else
			engine.loadFromSave(0);
	}

}
