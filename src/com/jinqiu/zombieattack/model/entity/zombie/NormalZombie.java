package com.jinqiu.zombieattack.model.entity.zombie;

import com.jinqiu.zombieattack.model.ExpirableObjectType;

/**
 * Zombie can moving randomly and when it hits the barriers, it can choose
 * another randomly moving path.
 */
public class NormalZombie extends Zombie {
	/** The width of moving up and down */
	private static final int WIDTH_UP_DOWN = 33;
	/** The height of moving up and down */
	private static final int HEIGHT_UP_DOWN = 58;
	/** The width of moving left and right */
	private static final int WIDTH_LEFT_RIGHT = 22;
	/** The height of moving left and right */
	private static final int HEIGHT_LEFT_RIGHT = 56;
	/** The number of disappearance count */
	private static final int DESTRUCTION_PEROID = 10;
	/** The running speed */
	private static final int RUNNING_SPEED = 3;
	/** The health point */
	private static final int HEALTH_POINT = 1;
	/** The zombie damage to the scientist */
	private static final int ZOMBIE_DAMAGE = 1;
	/** The score of killing this zombie */
	private static final int ZOMBIE_SCORE = 1;

	public NormalZombie() {
		super(WIDTH_UP_DOWN, HEIGHT_UP_DOWN, WIDTH_LEFT_RIGHT,
				HEIGHT_LEFT_RIGHT, RUNNING_SPEED, HEALTH_POINT, ZOMBIE_DAMAGE,
				-1, -1, DESTRUCTION_PEROID);
	}

	@Override
	public void initialObjectType() {
		super.initialObjectType();
		addExpirableObjectType(ExpirableObjectType.NormalZombie);
	}

	@Override
	public int score() {
		return ZOMBIE_SCORE;
	}
}