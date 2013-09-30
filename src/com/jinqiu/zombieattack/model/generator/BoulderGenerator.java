package com.jinqiu.zombieattack.model.generator;

import java.util.ArrayList;
import java.util.List;

import com.jinqiu.zombieattack.model.entity.Entity;
import com.jinqiu.zombieattack.model.entity.boulder.Boulder;
import com.jinqiu.zombieattack.model.factory.BoulderEtherealFactory;
import com.jinqiu.zombieattack.model.factory.BoulderFireFactory;
import com.jinqiu.zombieattack.model.factory.BoulderHoverFactory;
import com.jinqiu.zombieattack.model.factory.BoulderIceFactory;
import com.jinqiu.zombieattack.model.factory.BoulderNormalFactory;
import com.jinqiu.zombieattack.model.factory.EntityFactory;
import com.jinqiu.zombieattack.model.factory.WeightedEntityFactory;

/** The boulder generator */
public class BoulderGenerator implements EntityFactory<Boulder> {
	/** The weight of generating normal boulder */
	private static final int NORMAL_BOULDER_WEIGHT = 2;
	/** The weight of generating ice boulder */
	private static final int ICE_BOULDER_WEIGHT = 2;
	/** The weight of generating fire boulder */
	private static final int FIRE_BOULDER_WEIGHT = 2;
	/** The weight of generating hover boulder */
	private static final int HOVER_BOULDER_WEIGHT = 1;
	/** The weight of generating ethereal boulder */
	private static final int ETHEREAL_BOULDER_WEIGHT = 1;

	/** The number of boulder in one level */
	private static final int BOULDER_NUMBER = 3;

	//
	private EntityGenerator<Boulder> entityGenerator;

	public BoulderGenerator() {
		List<Integer> boulderWeight = new ArrayList<Integer>();
		boulderWeight.add(NORMAL_BOULDER_WEIGHT);
		boulderWeight.add(ICE_BOULDER_WEIGHT);
		boulderWeight.add(FIRE_BOULDER_WEIGHT);
		boulderWeight.add(HOVER_BOULDER_WEIGHT);
		boulderWeight.add(ETHEREAL_BOULDER_WEIGHT);

		/** The factories for all kinds of boulder */
		List<EntityFactory<? extends Boulder>> boulderFactories = new ArrayList<EntityFactory<? extends Boulder>>();
		boulderFactories.add(new BoulderNormalFactory());
		boulderFactories.add(new BoulderIceFactory());
		boulderFactories.add(new BoulderFireFactory());
		boulderFactories.add(new BoulderHoverFactory());
		boulderFactories.add(new BoulderEtherealFactory());

		List<WeightedEntityFactory<? extends Boulder>> weightedboulderFactories = new ArrayList<WeightedEntityFactory<? extends Boulder>>();
		for (int i = 0; i < boulderFactories.size(); i++) {
			weightedboulderFactories.add(new WeightedEntityFactory<Boulder>(
					boulderWeight.get(i), boulderFactories.get(i)));
		}

		entityGenerator = new EntityGenerator<Boulder>(weightedboulderFactories);
	}

	@Override
	public Boulder newEntity() {
		return entityGenerator.newEntity();
	}

	/** Generate three boulders */
	public List<Entity> getNewBoulders() {
		List<Entity> boulders = new ArrayList<Entity>();
		for (int i = 0; i < BOULDER_NUMBER; i++) {
			boulders.add(newEntity());
		}
		return boulders;
	}
}
