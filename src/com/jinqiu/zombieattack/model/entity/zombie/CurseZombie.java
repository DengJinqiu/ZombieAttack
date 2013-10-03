package com.jinqiu.zombieattack.model.entity.zombie;

import com.jinqiu.zombieattack.model.ExpirableObjectType;
import com.jinqiu.zombieattack.model.attached.CleanupContext;
import com.jinqiu.zombieattack.model.attached.CollisionContext;
import com.jinqiu.zombieattack.model.entity.materials.Goo;

/** When it die, it return into a goo. */
public class CurseZombie extends Zombie {
	/** The width of moving up and down */
	private static final int WIDTH_UP_DOWN = 41;
	/** The height of moving up and down */
	private static final int HEIGHT_UP_DOWN = 59;
	/** The width of moving left and right */
	private static final int WIDTH_LEFT_RIGHT = 47;
	/** The height of moving left and right */
	private static final int HEIGHT_LEFT_RIGHT = 57;
	/** The number of disappearance count */
	private static final int DESTRUCTION_PEROID = 19;
	/** The running speed */
	private static final int RUNNING_SPEED = 3;
	/** The health point */
	private static final int HEALTH_POINT = 1;
	/** The zombie damage to the scientist */
	private static final int ZOMBIE_DAMAGE = 1;
	/** The score of killing this zombie */
	private static final int ZOMBIE_SCORE = 2;

	public CurseZombie() {
		super(WIDTH_UP_DOWN, HEIGHT_UP_DOWN, WIDTH_LEFT_RIGHT,
				HEIGHT_LEFT_RIGHT, RUNNING_SPEED, HEALTH_POINT, ZOMBIE_DAMAGE,
				-1, -1, DESTRUCTION_PEROID);
	}

	@Override
	public void initialObjectType() {
		super.initialObjectType();
		addExpirableObjectType(ExpirableObjectType.CurseZombie);

	}

	/** change into a goo */
	@Override
	public void cleanup(CleanupContext cleanupContext) {
		super.cleanup(cleanupContext);
		Goo goo = new Goo(getCenter(), Math.max(getWidth(), getHeight()));
		cleanupContext.addEntity(goo);
	}

	@Override
	public void hitGoo(Goo goo, CollisionContext collisionContext) {
	}

	@Override
	public int score() {
		return ZOMBIE_SCORE;
	}

}