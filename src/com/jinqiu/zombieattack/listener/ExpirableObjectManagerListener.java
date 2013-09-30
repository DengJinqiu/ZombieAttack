package com.jinqiu.zombieattack.listener;

import com.jinqiu.zombieattack.model.ExpirableObject;

/** Listen to the expirable object manager */
public interface ExpirableObjectManagerListener {

	/**
	 * Add new view object to the view object manager, when adding a new
	 * expirable object
	 * 
	 * @param expirableObject
	 *            The new adding expirable object
	 */
	public void addViewExpirableObject(ExpirableObject expirableObject);

	/** Remove all the dead view object */
	public void cleanDeadViewObject();

}
