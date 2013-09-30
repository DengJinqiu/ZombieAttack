package com.jinqiu.zombieattack.model.entity.materials;

import com.jinqiu.zombieattack.model.ExpirableObjectType;
import com.jinqiu.zombieattack.model.attached.Position;

/** The small horizontal barrier */
public class BarrierSmallHorizontal extends Barrier {
	/** The width of this barrier */
	private final static int width = 100;
	/** The height of this barrier */
	private final static int height = 30;

	public BarrierSmallHorizontal(Position topLeft) {
		super(topLeft, new Position(topLeft.getX() + width, topLeft.getY()
				+ height));
	}

	@Override
	public void initialObjectType() {
		super.initialObjectType();
		addExpirableObjectType(ExpirableObjectType.BarrierSmallHorizontal);
	}

}