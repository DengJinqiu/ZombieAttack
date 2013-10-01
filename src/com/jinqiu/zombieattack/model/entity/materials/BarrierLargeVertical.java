package com.jinqiu.zombieattack.model.entity.materials;

import com.jinqiu.zombieattack.model.ExpirableObjectType;
import com.jinqiu.zombieattack.model.attached.Position;

/** The large vertical barrier */
public class BarrierLargeVertical extends Barrier {
	/** The width of the barrier */
	private final static int width = 50;
	/** The height of the barrier */
	private final static int height = 100;

	public BarrierLargeVertical(Position topLeft) {
		super(topLeft, new Position(topLeft.getX() + width, topLeft.getY()
				+ height));
	}

	@Override
	public void initialObjectType() {
		super.initialObjectType();
		addExpirableObjectType(ExpirableObjectType.BarrierLargeVertical);
	}

}
