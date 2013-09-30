package com.jinqiu.zombieattack.model.attached;

import java.util.List;

import com.jinqiu.zombieattack.model.entity.Entity;

/** Do clean up context after an entity disappear */
public interface DetectionContext {
	
	/**
	 * Get all the barriers from the entity manager
	 * @return The barriers
	 */
	public List<Entity> getBarriers();
}
