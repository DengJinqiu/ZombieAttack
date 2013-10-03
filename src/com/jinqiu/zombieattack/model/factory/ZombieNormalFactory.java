package com.jinqiu.zombieattack.model.factory;

import com.jinqiu.zombieattack.model.entity.zombie.NormalZombie;

public class ZombieNormalFactory implements EntityFactory<NormalZombie>{
	@Override
	public NormalZombie newEntity() {
		return new NormalZombie();
	}
}