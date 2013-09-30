package com.jinqiu.zombieattack.model.entity.zombie;

import com.jinqiu.zombieattack.model.ExpirableObjectType;

/** This zombie will have more life point */
public class StrongerZombie extends Zombie {
	/** The width of moving up and down */
	private static final int WIDTH_UP_DOWN = 45;
	/** The height of moving up and down */
	private static final int HEIGHT_UP_DOWN = 60;
	/** The width of moving left and right */
	private static final int WIDTH_LEFT_RIGHT = 31;
	/** The height of moving left and right */
	private static final int HEIGHT_LEFT_RIGHT = 58;
	/** The number of disappearance count */
	private static final int DESTRUCTION_PEROID = 11;
	/** The running speed */
	private static final int RUNNING_SPEED = 3;
	/** The health point */
	private static final int HEALTH_POINT = 3;
	/** The zombie damage to the scientist */
	private static final int ZOMBIE_DAMAGE = 1;
	/** The score of killing this zombie */
	private static final int ZOMBIE_SCORE = 4;

	public StrongerZombie() {
		super(WIDTH_UP_DOWN, HEIGHT_UP_DOWN, WIDTH_LEFT_RIGHT,
				HEIGHT_LEFT_RIGHT, RUNNING_SPEED, HEALTH_POINT, ZOMBIE_DAMAGE,
				-1, -1, DESTRUCTION_PEROID);
	}

	@Override
	public void initialObjectType() {
		super.initialObjectType();
		addExpirableObjectType(ExpirableObjectType.StrongerZombie);
	}

	@Override
	public int score() {
		return ZOMBIE_SCORE;
	}
}