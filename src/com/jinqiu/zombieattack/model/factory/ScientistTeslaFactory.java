package com.jinqiu.zombieattack.model.factory;

import com.jinqiu.zombieattack.model.entity.scientist.Tesla;

public class ScientistTeslaFactory implements EntityFactory<Tesla>{
	@Override
	public Tesla newEntity() {
		return new Tesla();
	}
}