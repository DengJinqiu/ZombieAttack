package com.jinqiu.zombieattack.model.generator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.jinqiu.zombieattack.listener.ZombieListener;
import com.jinqiu.zombieattack.model.entity.zombie.Zombie;
import com.jinqiu.zombieattack.model.factory.EntityFactory;
import com.jinqiu.zombieattack.model.factory.WeightedEntityFactory;
import com.jinqiu.zombieattack.model.factory.ZombieCurseFactory;
import com.jinqiu.zombieattack.model.factory.ZombieFastFactory;
import com.jinqiu.zombieattack.model.factory.ZombieGiantFactory;
import com.jinqiu.zombieattack.model.factory.ZombieKillerFactory;
import com.jinqiu.zombieattack.model.factory.ZombieLeaderFactory;
import com.jinqiu.zombieattack.model.factory.ZombieNormalFactory;
import com.jinqiu.zombieattack.model.factory.ZombieSmartFactory;
import com.jinqiu.zombieattack.model.factory.ZombieStrongerFactory;

/** Generate new zombie by the given probability. */
public class ZombieGenerator implements EntityFactory<Zombie> {
	/** The number of different levels */
	private static final int NUM_LEVEL_DIFFERENT = 5;
	/** The adding zombie frequency */
	private final static int ADD_NEW_ZOMBIE_FRE = 1000 * 3;
	/** The current adding zombie frequency */
	private int currentAddNewZombieFre;
	/** The entity generator */
	private EntityGenerator<Zombie> entityGenerator;

	// normal, fast, smart, stronger, killer, curse, giant, leader
	@SuppressWarnings("unchecked")
	private final static List<List<Integer>> zombieAppearInterval = Arrays
			.asList(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0), // not using
					Arrays.asList(1, 0, 0, 0, 2, 0, 0, 0), // 1
					Arrays.asList(0, 1, 2, 0, 0, 0, 0, 0), // 2
					Arrays.asList(0, 0, 0, 0, 0, 2, 0, 0), // 3
					Arrays.asList(0, 0, 0, 1, 0, 0, 1, 1), // 4
					Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1));// 5

	/**
	 * Constructor
	 * 
	 * @param levelIndex
	 *            The level index create the zombie generator
	 */
	public ZombieGenerator(int levelIndex) {

		currentAddNewZombieFre = ADD_NEW_ZOMBIE_FRE;
		if (levelIndex >= NUM_LEVEL_DIFFERENT) {
			levelIndex = NUM_LEVEL_DIFFERENT;
		}
		/** The factories for all kinds of zombie */
		ArrayList<EntityFactory<? extends Zombie>> zombieFactories = new ArrayList<EntityFactory<? extends Zombie>>();
		zombieFactories.add(new ZombieNormalFactory());
		zombieFactories.add(new ZombieFastFactory());
		zombieFactories.add(new ZombieSmartFactory());
		zombieFactories.add(new ZombieStrongerFactory());
		zombieFactories.add(new ZombieKillerFactory());
		zombieFactories.add(new ZombieCurseFactory());
		zombieFactories.add(new ZombieGiantFactory());
		zombieFactories.add(new ZombieLeaderFactory());

		List<WeightedEntityFactory<? extends Zombie>> weightedZombieFactories = new ArrayList<WeightedEntityFactory<? extends Zombie>>();
		for (int i = 0; i < zombieFactories.size(); i++) {
			weightedZombieFactories.add(new WeightedEntityFactory<Zombie>(
					zombieAppearInterval.get(levelIndex).get(i),
					zombieFactories.get(i)));
		}

		entityGenerator = new EntityGenerator<Zombie>(weightedZombieFactories);
	}

	@Override
	public Zombie newEntity() {
		Zombie newZombie = entityGenerator.newEntity();
		newZombie.addZombieListener(new ZombieListener() {

			@Override
			public void changeBackAddNewZombieFre() {
				ZombieGenerator.this.currentAddNewZombieFre = ADD_NEW_ZOMBIE_FRE;

			}

			@Override
			public void changeAddNewZombieFre(int newFrequency) {
				ZombieGenerator.this.currentAddNewZombieFre = newFrequency;

			}

			@Override
			public void changeScore(int change) {
			}
		});
		newZombie.responseToCreation();
		return newZombie;
	}

	/**
	 * Get the adding new zombie frequency
	 * 
	 * @return The zombie frequency
	 */
	public int getAddNewZombieFre() {
		return currentAddNewZombieFre;
	}

	/**
	 * Get the all weights
	 * 
	 * @return The weights
	 */
	public List<Double> getWeight() {
		return entityGenerator.getWeight();
	}

}