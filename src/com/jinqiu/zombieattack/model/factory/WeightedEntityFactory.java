package com.jinqiu.zombieattack.model.factory;

import com.jinqiu.zombieattack.model.entity.Entity;

/** The weighted entity factory */
public class WeightedEntityFactory<E extends Entity> implements
		EntityFactory<E> {
	/** The weight of the entity factory */
	private int weight;
	/** The entity factory */
	private EntityFactory<? extends E> factory;

	public WeightedEntityFactory(int weight, EntityFactory<? extends E> factory) {
		this.weight = weight;
		this.factory = factory;
	}

	/**
	 * Get the weight
	 * 
	 * @return The weight
	 */
	public int getWeight() {
		return weight;
	}

	/**
	 * Get the factory
	 * 
	 * @return The factory
	 */
	public EntityFactory<? extends E> getFactory() {
		return factory;
	}

	@Override
	public E newEntity() {
		return this.factory.newEntity();
	}
}
