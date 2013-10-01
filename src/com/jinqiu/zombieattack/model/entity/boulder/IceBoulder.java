package com.jinqiu.zombieattack.model.entity.boulder;

import com.jinqiu.zombieattack.model.ExpirableObjectType;
import com.jinqiu.zombieattack.model.attached.CollisionContext;
import com.jinqiu.zombieattack.model.effect.IceBoulderToZombieEffect;
import com.jinqiu.zombieattack.model.entity.zombie.Zombie;

/** This boulder can stop the zombie from moving */
public class IceBoulder extends Boulder {
	/** The radius of his boulder */
	private static final int RADIUS = 28;
	/** The number of appearance count */
	private static final int APPEARANCE_COUNT = 10;
	/** The number of disappearance count */
	private static final int DISAPPEARANCE_COUNT = 10;

	public IceBoulder() {
		super(RADIUS, APPEARANCE_COUNT, DISAPPEARANCE_COUNT);
	}

	@Override
	public void hitZombie(Zombie zombie, CollisionContext collisionContext) {
		if (!zombie.isUnderEffect()) {
			collisionContext.addEffect(new IceBoulderToZombieEffect(zombie));
		}
		super.hitZombie(zombie, collisionContext);
	}

	@Override
	public void initialObjectType() {
		super.initialObjectType();
		addExpirableObjectType(ExpirableObjectType.IceBoulder);
	}
}
