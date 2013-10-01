package com.jinqiu.zombieattack.model.factory;

import com.jinqiu.zombieattack.model.entity.scientist.NormalScientist;

public class ScientistNormalFactory implements EntityFactory<NormalScientist> {
	@Override
	public NormalScientist newEntity() {
		return new NormalScientist();
	}
}