package com.jinqiu.zombieattack.model.factory;

import com.jinqiu.zombieattack.model.entity.zombie.CurseZombie;

public class ZombieCurseFactory implements EntityFactory<CurseZombie>{
	@Override
	public CurseZombie newEntity() {
		return new CurseZombie();
	}
}
