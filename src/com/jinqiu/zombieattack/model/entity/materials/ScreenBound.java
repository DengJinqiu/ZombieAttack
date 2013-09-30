package com.jinqiu.zombieattack.model.entity.materials;

import com.jinqiu.zombieattack.model.ExpirableObjectType;
import com.jinqiu.zombieattack.model.attached.Position;

/** The screen bound */
public class ScreenBound extends Barrier {
	public ScreenBound(Position topLeft, Position bottomRight) {
		super(topLeft, bottomRight);
	}

	@Override
	public void initialObjectType() {
		super.initialObjectType();
		addExpirableObjectType(ExpirableObjectType.ScreenBound);
	}

}
