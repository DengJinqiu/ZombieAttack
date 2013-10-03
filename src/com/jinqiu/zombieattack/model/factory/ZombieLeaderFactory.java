package com.jinqiu.zombieattack.model.factory;

import com.jinqiu.zombieattack.model.entity.zombie.LeaderZombie;

public class ZombieLeaderFactory implements EntityFactory<LeaderZombie>{
	@Override
	public LeaderZombie newEntity() {
		return new LeaderZombie();
	}
}
