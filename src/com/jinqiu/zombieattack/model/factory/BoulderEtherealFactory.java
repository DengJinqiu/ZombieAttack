package com.jinqiu.zombieattack.model.factory;

import com.jinqiu.zombieattack.model.entity.boulder.Boulder;
import com.jinqiu.zombieattack.model.entity.boulder.EtherealBoulder;

public class BoulderEtherealFactory implements EntityFactory<Boulder>{

	@Override
	public Boulder newEntity() {
		return new EtherealBoulder();
	}

}
