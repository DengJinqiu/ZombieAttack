package com.jinqiu.zombieattack.model.entity.zombie;

import com.jinqiu.zombieattack.listener.ZombieListener;
import com.jinqiu.zombieattack.model.ExpirableObjectType;
import com.jinqiu.zombieattack.model.GameModel;
import com.jinqiu.zombieattack.model.attached.CleanupContext;

/**
 * This zombie cannot be killed by boulder, but it will disappear after 5
 * seconds, when it appears the adding zombie frequency will increase.
 */
public class LeaderZombie extends Zombie {
	/** The width of moving up and down */
	private static final int WIDTH_UP_DOWN = 79;
	/** The height of moving up and down */
	private static final int HEIGHT_UP_DOWN = 90;
	/** The width of moving left and right */
	private static final int WIDTH_LEFT_RIGHT = 42;
	/** The height of moving left and right */
	private static final int HEIGHT_LEFT_RIGHT = 89;
	/** The number of disappearance count */
	private static final int DESTRUCTION_PEROID = 15;
	/** The running speed */
	private static final int RUNNING_SPEED = 3;
	/** The health point */
	private static final int HEALTH_POINT = Integer.MAX_VALUE;
	/** The zombie damage to the scientist */
	private static final int ZOMBIE_DAMAGE = 1;
	/** The score of killing this zombie */
	private static final int ZOMBIE_SCORE = 7;
	/** The number of life state count */
	private static final int LIFE_TIME = 5000 / GameModel.getUpdateFrequency();
	/** The new adding zombie frequency */
	private static final int NEW_ADD_ZOMBIE_FRE = 800;

	public LeaderZombie() {
		super(WIDTH_UP_DOWN, HEIGHT_UP_DOWN, WIDTH_LEFT_RIGHT,
				HEIGHT_LEFT_RIGHT, RUNNING_SPEED, HEALTH_POINT, ZOMBIE_DAMAGE,
				-1, LIFE_TIME, DESTRUCTION_PEROID);
	}

	@Override
	public void initialObjectType() {
		super.initialObjectType();
		addExpirableObjectType(ExpirableObjectType.LeaderZombie);

	}

	@Override
	public void cleanup(CleanupContext cleanupContext) {
		for (int i = 0; i < zombieListeners.size(); i++) {
			zombieListeners.get(i).changeBackAddNewZombieFre();
		}
		cleanupContext.trackDeadZombieCount();
	}

	@Override
	public void addZombieListener(ZombieListener zombieListener) {
		super.addZombieListener(zombieListener);
	}

	@Override
	public void responseToCreation() {
		for (int i = 0; i < zombieListeners.size(); i++) {
			zombieListeners.get(i).changeAddNewZombieFre(NEW_ADD_ZOMBIE_FRE);
		}
	}

	@Override
	public int score() {
		return ZOMBIE_SCORE;
	}
}