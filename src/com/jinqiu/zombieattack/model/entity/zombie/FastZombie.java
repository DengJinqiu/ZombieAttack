package com.jinqiu.zombieattack.model.entity.zombie;

import com.jinqiu.zombieattack.model.ExpirableObjectType;

/** This zombie moves faster than others */
public class FastZombie extends Zombie {
	/** The width of moving up and down */
	private static final int WIDTH_UP_DOWN = 35;
	/** The height of moving up and down */
	private static final int HEIGHT_UP_DOWN = 60;
	/** The width of moving left and right */
	private static final int WIDTH_LEFT_RIGHT = 26;
	/** The height of moving left and right */
	private static final int HEIGHT_LEFT_RIGHT = 60;
	/** The number of disappearance count */
	private static final int DESTRUCTION_PEROID = 10;
	/** The running speed */
	private static final int RUNNING_SPEED = 6;
	/** The health point */
	private static final int HEALTH_POINT = 2;
	/** The zombie damage to the scientist */
	private static final int ZOMBIE_DAMAGE = 1;
	/** The score of killing this zombie */
	private static final int ZOMBIE_SCORE = 2;

	public FastZombie() {
		super(WIDTH_UP_DOWN, HEIGHT_UP_DOWN, WIDTH_LEFT_RIGHT,
				HEIGHT_LEFT_RIGHT, RUNNING_SPEED, HEALTH_POINT, ZOMBIE_DAMAGE,
				-1, -1, DESTRUCTION_PEROID);
	}

	@Override
	public void initialObjectType() {
		super.initialObjectType();
		addExpirableObjectType(ExpirableObjectType.FastZombie);

	}

	@Override
	public int score() {
		return ZOMBIE_SCORE;
	}
}