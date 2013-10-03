package com.jinqiu.zombieattack.model.entity.zombie;

import com.jinqiu.zombieattack.model.ExpirableObjectType;

/** This zombie has more health point and more damage */
public class GiantZombie extends Zombie {
	/** The width of moving up and down */
	private static final int WIDTH_UP_DOWN = 90;
	/** The height of moving up and down */
	private static final int HEIGHT_UP_DOWN = 90;
	/** The width of moving left and right */
	private static final int WIDTH_LEFT_RIGHT = 67;
	/** The height of moving left and right */
	private static final int HEIGHT_LEFT_RIGHT = 90;
	/** The number of disappearance count */
	private static final int DESTRUCTION_PEROID = 10;
	/** The running speed */
	private static final int RUNNING_SPEED = 2;
	/** The health point */
	private static final int HEALTH_POINT = 5;
	/** The zombie damage to the scientist */
	private static final int ZOMBIE_DAMAGE = 2;
	/** The score of killing this zombie */
	private static final int ZOMBIE_SCORE = 7;

	public GiantZombie() {
		super(WIDTH_UP_DOWN, HEIGHT_UP_DOWN, WIDTH_LEFT_RIGHT,
				HEIGHT_LEFT_RIGHT, RUNNING_SPEED, HEALTH_POINT, ZOMBIE_DAMAGE,
				-1, -1, DESTRUCTION_PEROID);
	}

	@Override
	public void initialObjectType() {
		super.initialObjectType();
		addExpirableObjectType(ExpirableObjectType.GiantZombie);
	}

	@Override
	public int score() {
		return ZOMBIE_SCORE;
	}
}
