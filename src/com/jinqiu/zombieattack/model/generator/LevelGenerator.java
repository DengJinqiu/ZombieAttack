package com.jinqiu.zombieattack.model.generator;

import com.jinqiu.zombieattack.model.Level;

/**
 * Generate the level, there are infinity levels in the game, the first five
 * levels have different difficulties, the level after 5 have the same
 * difficulty. <br/>
 * Given a level number it will return a object of level.
 */
/**
 * @author jinqiu
 * 
 */
public class LevelGenerator {
	/** The environment generator */
	private EnvironmentGenerator environmentGenerator = new EnvironmentGenerator();
	/** The boulder generator */
	private BoulderGenerator boulderGenerator = new BoulderGenerator();
	/** The current level index */
	private int currentLevelIndex = 0;

	/**
	 * Get the current level
	 * 
	 * @param levelIndex
	 *            The level index
	 * @return The current level
	 */
	private Level getLevel(int levelIndex) {
		return new Level(new ZombieGenerator(levelIndex),
				environmentGenerator.getBarAndScientist(),
				boulderGenerator.getNewBoulders());
	}

	/**
	 * Get the next level
	 * 
	 * @return The next level
	 */
	public Level getNextLevel() {
		currentLevelIndex++;
		return getLevel(currentLevelIndex);
	}
}
