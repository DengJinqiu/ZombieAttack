package com.jinqiu.zombieattack.listener;

import com.jinqiu.zombieattack.model.GameModelState;

/** Listen all the model. */
public interface ModelListener {
	
	/**
	 * Update when the game model update
	 * 
	 * @param gameModelState
	 *            The state of the game model
	 */
	public void update(GameModelState gameModelState);
}
