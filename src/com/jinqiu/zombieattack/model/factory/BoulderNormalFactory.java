package com.jinqiu.zombieattack.model.factory;

import com.jinqiu.zombieattack.model.entity.boulder.Boulder;
import com.jinqiu.zombieattack.model.entity.boulder.NormalBoulder;

public class BoulderNormalFactory implements EntityFactory<Boulder>{

	@Override
	public Boulder newEntity() {
		return new NormalBoulder();
	}

}
