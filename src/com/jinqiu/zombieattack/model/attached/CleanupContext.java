package com.jinqiu.zombieattack.model.attached;

import com.jinqiu.zombieattack.model.entity.Entity;

/** Do clean up context after an entity disappear */
public interface CleanupContext {
	/** Track the number of dead and left zombie */
	public void trackDeadAndLeftZombieCount();

	/** Only track the number of dead zombie */
	public void trackDeadZombieCount();

	/** Track the number of dead scientist */
	public void trackDeadScientistCount();

	/**
	 * Add new entity to the entity manager
	 * 
	 * @param entity
	 *            The new entity
	 */
	public void addEntity(Entity entity);
}
