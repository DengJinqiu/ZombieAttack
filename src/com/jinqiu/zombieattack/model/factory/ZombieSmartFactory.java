package com.jinqiu.zombieattack.model.factory;

import com.jinqiu.zombieattack.model.entity.zombie.SmartZombie;

public class ZombieSmartFactory implements EntityFactory<SmartZombie>{

	@Override
	public SmartZombie newEntity() {
		return new SmartZombie();
	}

}
