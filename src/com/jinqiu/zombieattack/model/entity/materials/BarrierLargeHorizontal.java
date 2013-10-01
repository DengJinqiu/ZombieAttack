package com.jinqiu.zombieattack.model.entity.materials;

import com.jinqiu.zombieattack.model.ExpirableObjectType;
import com.jinqiu.zombieattack.model.attached.Position;

/** This is the large horizontal boulder */
public class BarrierLargeHorizontal extends Barrier {
	/** The width of this boulder */
	private final static int width = 100;
	/** The height of this boulder */
	private final static int height = 50;

	public BarrierLargeHorizontal(Position topLeft) {
		super(topLeft, new Position(topLeft.getX() + width, topLeft.getY()
				+ height));
	}

	@Override
	public void initialObjectType() {
		super.initialObjectType();
		addExpirableObjectType(ExpirableObjectType.BarrierLargeHorizontal);
	}

}
