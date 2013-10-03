package com.jinqiu.zombieattack.model.factory;

import com.jinqiu.zombieattack.model.entity.Entity;

/** An interface for entity factory */
public interface EntityFactory<E extends Entity> {
	/** Create new entity */
	public E newEntity();
}
