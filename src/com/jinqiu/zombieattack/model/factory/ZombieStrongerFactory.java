package com.jinqiu.zombieattack.model.factory;

import com.jinqiu.zombieattack.model.entity.zombie.StrongerZombie;

public class ZombieStrongerFactory implements EntityFactory<StrongerZombie>{
	@Override
	public StrongerZombie newEntity() {
		return new StrongerZombie();
	}
}