package com.jinqiu.zombieattack.model.factory;

import com.jinqiu.zombieattack.model.entity.zombie.GiantZombie;

public class ZombieGiantFactory implements EntityFactory<GiantZombie> {
	@Override
	public GiantZombie newEntity() {
		return new GiantZombie();
	}
}
