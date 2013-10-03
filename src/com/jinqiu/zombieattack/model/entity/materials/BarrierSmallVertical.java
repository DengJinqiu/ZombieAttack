package com.jinqiu.zombieattack.model.entity.materials;

import com.jinqiu.zombieattack.model.ExpirableObjectType;
import com.jinqiu.zombieattack.model.attached.Position;

/** The small vertical barrier */
public class BarrierSmallVertical extends Barrier {
	/** The width of this vertical barrier */
	private final static int width = 30;
	/** The height of this vertical barrier */
	private final static int height = 100;

	public BarrierSmallVertical(Position topLeft) {
		super(topLeft, new Position(topLeft.getX() + width, topLeft.getY()
				+ height));
	}

	@Override
	public void initialObjectType() {
		super.initialObjectType();
		addExpirableObjectType(ExpirableObjectType.BarrierSmallVertical);
	}

}
