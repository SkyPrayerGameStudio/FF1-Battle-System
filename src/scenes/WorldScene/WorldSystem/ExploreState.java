package scenes.WorldScene.WorldSystem;

import map.Map;
import map.NPC;
import scenes.GameState;
import engine.Engine;
import engine.Input;

/**
 * ExploreState
 * @author nhydock
 *
 *	World state for handling moving the character around a map
 */
public class ExploreState extends GameState {

	WorldSystem parent;
	
	//party's position on the map
	int x;					
	int y;
	
	/**
	 * Creates the state
	 */
	public ExploreState(WorldSystem c) {
		super(c);
		parent = c;
	}

	/**
	 * Do nothing
	 */
	@Override
	public void finish() {

	}

	/**
	 * Update things such as the position of the leader
	 * and make the npcs move around
	 */
	@Override
	public void handle() {
		x = parent.leader.getX();
		y = parent.leader.getY();
		
		for (int i = 0; i < parent.map.getAllNPCs().size(); i++)
			parent.map.getAllNPCs().get(i).move();
	}

	/**
	 * Handles key input
	 */
	@Override
	public void handleKeyInput(int key) {
		//move the character around
    	if (Input.DPAD.contains("" + key)) {
    		if (key == Input.KEY_UP)
    			y--;
    		else if (key == Input.KEY_DN)
    			y++;
    		else if (key == Input.KEY_LT)
    			x--;
    		else if (key == Input.KEY_RT)
    			x++;
    		parent.moveTo(x, y);
		}
    	//interact with npcs
    	else if (key == Input.KEY_A)
        {
        	int[] ahead = Map.getCoordAhead(x, y, parent.leader.getDirection());
      		
        	NPC n = parent.map.getNPC(ahead[0], ahead[1]);
        	if (n != null)
        		if (n.interact() == "dialog")
        		{
        			parent.activeNPC = n;
        			parent.setNextState();
        		}
        }
    	//switch character sprite
    	else if (key == Input.KEY_SELECT)
    	{
    		parent.finish();
    		Engine.getInstance().changeToOrder();
    	}
    	//show main menu
    	else if (key == Input.KEY_START)
    	{
    		parent.finish();
    		Engine.getInstance().changeToMenu();
    	}
    	//quick save can only be done on the map
    	else if (key == Input.KEY_QUICKSAVE)
    	{
    		Engine.getInstance().recordSave(0);
    	}
	}

	/**
	 * Do nothing
	 */
	@Override
	public void start() {

	}

}
