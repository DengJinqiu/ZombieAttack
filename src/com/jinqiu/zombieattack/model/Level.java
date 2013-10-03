package com.jinqiu.zombieattack.model;

import java.util.List;

import com.jinqiu.zombieattack.model.entity.Entity;
import com.jinqiu.zombieattack.model.generator.ZombieGenerator;

/** One level of game */
public class Level {
	/** the upper bound of the number of zombies left in the game */
	private static final int ZOMBIE_NUMBER_UPPER_BOUND = 15;
	/** the zombie need to kill */
	private static final int ZOMBIE_NEED_TO_KILL = 3;
	/** The zombie generator of this level */
	private ZombieGenerator zombieGenerator;
	/** The expirable object manager of this level */
	private ExpirableObjectManager expirableObjectManager;

	public Level(ZombieGenerator zombieGenerator, List<Entity> barAndScientist,
			List<Entity> boulderleft) {
		this.zombieGenerator = zombieGenerator;

		expirableObjectManager = new ExpirableObjectManager(barAndScientist,
				boulderleft);
	}

	/**
	 * Get the zombie generator
	 * 
	 * @return The zombie generator
	 */
	public ZombieGenerator getZombieGenerator() {
		return zombieGenerator;
	}

	/**
	 * Get the expirable object manager
	 * 
	 * @return The expirable object manager
	 */
	public ExpirableObjectManager getExpirableObjectManager() {
		return expirableObjectManager;
	}

	/**
	 * Get the zombie number upper bound
	 * 
	 * @return The zombie number upper bound
	 */
	public int getZombieNumberUpperBound() {
		return ZOMBIE_NUMBER_UPPER_BOUND;
	}

	/**
	 * Get the number of zombie need to kill
	 * 
	 * @return The number of zombie need to kill
	 */
	public int getZombieNeedToKill() {
		return ZOMBIE_NEED_TO_KILL;
	}

}
