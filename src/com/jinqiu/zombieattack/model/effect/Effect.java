package com.jinqiu.zombieattack.model.effect;

import com.jinqiu.zombieattack.model.ExpirableObject;
import com.jinqiu.zombieattack.model.ExpirableObjectType;
import com.jinqiu.zombieattack.model.entity.Entity;
import com.jinqiu.zombieattack.model.objectstate.LifeState;

/** The effect*/
public abstract class Effect extends ExpirableObject {
	/** The entity under this effect */
	private Entity entity;

	/**
	 * Set up the effect correspond to a given entity
	 * 
	 * @param entity
	 *            The entity under this effect
	 * @param appearanceCount
	 *            The appearance state count
	 * @param normalCount
	 *            The normal state count
	 * @param disappearanceCount
	 *            The disappearance state count
	 */
	Effect(Entity entity, int appearanceCount, int normalCount,
			int disappearanceCount) {
		super(appearanceCount, normalCount, disappearanceCount);
		this.entity = entity;
		entity.obtainEffect();
	}

	public Entity getEntity() {
		return entity;
	}

	@Override
	public void update() {
		if (entity.isShouldBeRemoved()
				&& expirableObjectState.getLifeState() != LifeState.DISAPPEARANCE) {
			startDisappear();
		}
		super.update();
	}
	
	@Override
	public void startDisappear() {
		getEntity().removeEffect();
		super.startDisappear();
	}

	@Override
	public int getCenterX() {
		return entity.getCenterX();
	}

	@Override
	public int getCenterY() {
		return entity.getCenterY();
	}

	@Override
	protected void initialObjectType() {
		addExpirableObjectType(ExpirableObjectType.Effect);
	}
}