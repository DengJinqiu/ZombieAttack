package com.jinqiu.zombieattack.model.effect;

import com.jinqiu.zombieattack.model.ExpirableObjectType;
import com.jinqiu.zombieattack.model.entity.zombie.Zombie;

public class IceBoulderToZombieEffect extends Effect {
	/** The number of count for appearance */
	private final static int APPEARANCE_COUNT = 5;
	/** The number of count for normal life state */
	private final static int NORMAL_COUNT = 50;
	/** The number of count for disappearance */
	private final static int DISAPPEARANCE_COUNT = 5;

	public IceBoulderToZombieEffect(Zombie zombie) {
		super(zombie, APPEARANCE_COUNT, NORMAL_COUNT, DISAPPEARANCE_COUNT);
		zombie.stopRunning();
	}

	@Override
	public void startDisappear() {
		((Zombie) getEntity()).startRunning();
		super.startDisappear();
	}

	@Override
	protected void initialObjectType() {
		super.initialObjectType();
		addExpirableObjectType(ExpirableObjectType.iceBoulderToZombieEffect);
	}

}
