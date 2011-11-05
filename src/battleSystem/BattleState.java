package battleSystem;

import java.awt.event.KeyEvent;

public interface BattleState {

	/**
	 * Handles anything that is required to be set upon switching to the state
	 */
	public void start();
	
	/**
	 * Handles updating
	 */
	public void handle();
	
	/**
	 * Finishes the state's execution
	 */
	public void finish();

	public void handleKeyInput(KeyEvent arg0);
}
