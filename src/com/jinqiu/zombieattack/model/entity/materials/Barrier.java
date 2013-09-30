package com.jinqiu.zombieattack.model.entity.materials;

import com.jinqiu.zombieattack.model.ExpirableObjectType;
import com.jinqiu.zombieattack.model.attached.CollisionContext;
import com.jinqiu.zombieattack.model.attached.Position;
import com.jinqiu.zombieattack.model.entity.Rectangle;
import com.jinqiu.zombieattack.model.entity.boulder.Boulder;
import com.jinqiu.zombieattack.model.entity.scientist.Scientist;
import com.jinqiu.zombieattack.model.entity.zombie.Zombie;

/** This class implements barriers. It will not change during the game. */
public abstract class Barrier extends Rectangle {

	/**
	 * Constructor
	 * 
	 * @param topLeft
	 *            The top left position
	 * @param bottomRight
	 *            The bottom right position
	 */
	public Barrier(Position topLeft, Position bottomRight) {
		super(topLeft, bottomRight, -1, -1, -1);
	}

	@Override
	public void initialObjectType() {
		super.initialObjectType();
		addExpirableObjectType(ExpirableObjectType.Barrier);
	}

	@Override
	public void update() {
	}

	@Override
	protected void checkDirection() {
	}

	@Override
	public void hitBarrier(Barrier barrier, CollisionContext collisionContext) {
	}

	@Override
	public void hitGoo(Goo goo, CollisionContext collisionContext) {
	}

	@Override
	public void hitZombie(Zombie zombie, CollisionContext collisionContext) {
	}

	@Override
	public void hitScientist(Scientist scientist,
			CollisionContext collisionContext) {
	}

	@Override
	public void hitBoulder(Boulder boulder, CollisionContext collisionContext) {
	}

}
