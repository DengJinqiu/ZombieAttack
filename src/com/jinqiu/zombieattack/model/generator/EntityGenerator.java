package com.jinqiu.zombieattack.model.generator;

import java.util.ArrayList;
import java.util.List;

import com.jinqiu.zombieattack.model.entity.Entity;
import com.jinqiu.zombieattack.model.factory.WeightedEntityFactory;

/** The entity generator */
public class EntityGenerator<E extends Entity> {
	/** The sum of the weight */
	private int sumWeight = 0;
	/** The list of weighted factory */
	private List<WeightedEntityFactory<? extends E>> entityFactories = new ArrayList<WeightedEntityFactory<? extends E>>();

	public EntityGenerator(
			List<WeightedEntityFactory<? extends E>> entityFactories) {
		this.entityFactories = entityFactories;
		for (int i = 0; i < entityFactories.size(); i++) {
			sumWeight += entityFactories.get(i).getWeight();
		}
	}

	/** Get new entity */
	public E newEntity() {
		double temp = Math.random() * sumWeight;
		for (WeightedEntityFactory<? extends E> factory : this.entityFactories) {
			temp -= factory.getWeight();
			if (temp < 0) {
				return factory.newEntity();
			}
		}
		throw new IllegalStateException("Weights did not add up to one!");
	}

	/** Get the weight for each weighted factory */
	public List<Double> getWeight() {
		List<Double> weight = new ArrayList<Double>();
		for (int i = 0; i < entityFactories.size(); i++) {
			weight.add((double) entityFactories.get(i).getWeight() / sumWeight);
		}
		return weight;
	}
}
