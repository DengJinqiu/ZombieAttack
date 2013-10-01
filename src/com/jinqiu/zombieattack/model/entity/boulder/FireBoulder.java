package com.jinqiu.zombieattack.model.entity.boulder;

import com.jinqiu.zombieattack.model.ExpirableObjectType;
import com.jinqiu.zombieattack.model.attached.CollisionContext;
import com.jinqiu.zombieattack.model.effect.FireBoulderToZombieEffect;
import com.jinqiu.zombieattack.model.entity.zombie.Zombie;

/** This boulder will setup a fire effect on the zombie it hit */
public class FireBoulder extends Boulder {
	/** The radius of the boulder */
	private static final int RADIUS = 24;
	/** The number of the appearance count */
	private static final int APPEARANCE_COUNT = 9;
	/** The number of the disappearance count */
	private static final int DISAPPEARANCE_COUNT = 8;

	public FireBoulder() {
		super(RADIUS, APPEARANCE_COUNT, DISAPPEARANCE_COUNT);
	}

	/** The total continue damage after the hit */
	private static final int DAMAGE_OVER_TIME = 1;

	@Override
	public void hitZombie(Zombie zombie, CollisionContext collisionContext) {
		if (!zombie.isUnderEffect()) {
			collisionContext.addEffect(new FireBoulderToZombieEffect(zombie,
					DAMAGE_OVER_TIME));
		}
		super.hitZombie(zombie, collisionContext);
	}

	@Override
	public void initialObjectType() {
		super.initialObjectType();
		addExpirableObjectType(ExpirableObjectType.FireBoulder);
	}

}
