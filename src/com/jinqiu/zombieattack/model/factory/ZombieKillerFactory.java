package com.jinqiu.zombieattack.model.factory;

import com.jinqiu.zombieattack.model.entity.zombie.KillerZombie;

public class ZombieKillerFactory implements EntityFactory<KillerZombie>{
	@Override
	public KillerZombie newEntity() {
		return new KillerZombie();
	}
}