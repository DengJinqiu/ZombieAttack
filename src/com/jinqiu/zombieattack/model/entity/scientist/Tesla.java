package com.jinqiu.zombieattack.model.entity.scientist;

import com.jinqiu.zombieattack.model.ExpirableObjectType;

/** tesla */
public class Tesla extends Scientist {
	/** The width of moving left and right */
	private static final int WIDTH_LEFT_RIGHT = 59;
	/** The height of moving left and right */
	private static final int HEIGHT_LEFT_RIGHT = 59;
	/** The width of moving up and down */
	private static final int WIDTH_UP_DOWN = 59;
	/** The height of moving up and down */
	private static final int HEIGHT_UP_DOWN = 59;
	/** The number of disappearance count */
	private static final int DESTRUCTION_PEROID = 12;

	public Tesla() {
		super(WIDTH_UP_DOWN, HEIGHT_UP_DOWN, WIDTH_LEFT_RIGHT,
				HEIGHT_LEFT_RIGHT, -1, -1, DESTRUCTION_PEROID);
	}

	@Override
	public void initialObjectType() {
		super.initialObjectType();
		addExpirableObjectType(ExpirableObjectType.Tesla);
	}
}