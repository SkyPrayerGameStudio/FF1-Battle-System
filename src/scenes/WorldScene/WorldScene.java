package scenes.WorldScene;

import engine.Engine;
import scenes.Scene;
import scenes.WorldScene.GUI.WorldHUD;
import scenes.WorldScene.WorldSystem.WorldSystem;

/**
 * WorldScene
 * @author nhydock
 *
 *  Scene for showing npcs and characters wandering around maps
 */
public class WorldScene extends Scene{
	
	public void start(String s)
	{
		system = new WorldSystem();
		((WorldSystem)system).start(s);
		display = new WorldHUD((WorldSystem)system);
		((WorldHUD)display).setLeader(Engine.getInstance().getParty().get(0));
	}
	
}
