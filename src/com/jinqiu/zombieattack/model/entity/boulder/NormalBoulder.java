package com.jinqiu.zombieattack.model.entity.boulder;

import com.jinqiu.zombieattack.model.ExpirableObjectType;

/** This boulder is do not have speical effect */
public class NormalBoulder extends Boulder {
	/** The radius of this boulder */
	private static final int RADIUS = 28;
	/** The number of the appearance count */
	private static final int APPEARANCE_COUNT = 8;
	/** The number of the disappearance count */
	private static final int DISAPPEARANCE_COUNT = 10;

	public NormalBoulder() {
		super(RADIUS, APPEARANCE_COUNT, DISAPPEARANCE_COUNT);
	}

	@Override
	public void initialObjectType() {
		super.initialObjectType();
		addExpirableObjectType(ExpirableObjectType.NormalBoulder);
	}
}
