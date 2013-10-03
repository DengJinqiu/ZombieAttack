package com.jinqiu.zombieattack.model.entity.boulder;

import com.jinqiu.zombieattack.model.ExpirableObjectType;
import com.jinqiu.zombieattack.model.attached.CollisionContext;
import com.jinqiu.zombieattack.model.entity.materials.Goo;

/** The hover boulder cannot be slow down by the goo */
public class HoverBoulder extends Boulder {
	/** The radius of the boulder */
	private static final int RADIUS = 27;
	/** The number of appearance count */
	private static final int APPEARANCE_COUNT = 12;
	/** The number of disappearance count */
	private static final int DISAPPEARANCE_COUNT = 12;

	public HoverBoulder() {
		super(RADIUS, APPEARANCE_COUNT, DISAPPEARANCE_COUNT);
	}

	@Override
	public void hitGoo(Goo goo, CollisionContext collisionContext) {
	}

	@Override
	public void initialObjectType() {
		super.initialObjectType();
		addExpirableObjectType(ExpirableObjectType.HoverBoulder);
	}
}
