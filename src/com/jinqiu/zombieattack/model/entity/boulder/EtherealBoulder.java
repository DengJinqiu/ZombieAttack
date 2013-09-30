package com.jinqiu.zombieattack.model.entity.boulder;

import com.jinqiu.zombieattack.model.ExpirableObjectType;
import com.jinqiu.zombieattack.model.attached.CollisionContext;
import com.jinqiu.zombieattack.model.entity.materials.Barrier;
import com.jinqiu.zombieattack.model.entity.materials.Goo;
import com.jinqiu.zombieattack.model.entity.scientist.Scientist;
import com.jinqiu.zombieattack.model.entity.zombie.Zombie;

/** This boulder cannot hit anything except the zombie */
public class EtherealBoulder extends Boulder {
	/** The radius of the boulder */
	private static final int RADIUS = 28;
	/** The number of the appearance count */
	private static final int APPEARANCE_COUNT = 10;
	/** The number of the disappearance count */
	private static final int DISAPPEARANCE_COUNT = 10;

	public EtherealBoulder() {
		super(RADIUS, APPEARANCE_COUNT, DISAPPEARANCE_COUNT);
	}

	@Override
	public void hitBarrier(Barrier barrier, CollisionContext collisionContext) {
		if (barrier.isExpirableObjectType(ExpirableObjectType.ScreenBound)) {
			super.hitBarrier(barrier, collisionContext);
		}
	}

	@Override
	public void hitGoo(Goo goo, CollisionContext collisionContext) {
	}

	@Override
	public void hitScientist(Scientist scientist,
			CollisionContext collisionContext) {
	}

	@Override
	public void hitZombie(Zombie zombie, CollisionContext collisionContext) {
	}

	@Override
	public void initialObjectType() {
		super.initialObjectType();
		addExpirableObjectType(ExpirableObjectType.EtherealBoulder);
	}

}
