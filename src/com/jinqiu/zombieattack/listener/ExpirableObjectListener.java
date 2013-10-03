package com.jinqiu.zombieattack.listener;

import com.jinqiu.zombieattack.model.objectstate.ExpirableObjectState;

/** Listener to the expirable object */
public interface ExpirableObjectListener {

	/**
	 * Update when the corresponding expirable object update
	 * 
	 * @param centerX
	 *            The x coordinate of the center of the expirable object
	 * @param centerY
	 *            The y coordinate of the center of the expirable object
	 * @param objectState
	 *            The object state of the expirable object
	 */
	public void update(int centerX, int centerY,
			ExpirableObjectState objectState);

	/** Remove when the corresponding expirable object removed*/
	public void remove();

}
