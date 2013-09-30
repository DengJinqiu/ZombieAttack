package com.jinqiu.zombieattack.model.factory;

import com.jinqiu.zombieattack.model.entity.boulder.Boulder;
import com.jinqiu.zombieattack.model.entity.boulder.FireBoulder;

public class BoulderFireFactory implements EntityFactory<Boulder>{

	@Override
	public Boulder newEntity() {
		return new FireBoulder();
	}

}
