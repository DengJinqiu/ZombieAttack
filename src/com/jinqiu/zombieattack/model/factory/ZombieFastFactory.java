package com.jinqiu.zombieattack.model.factory;

import com.jinqiu.zombieattack.model.entity.zombie.FastZombie;

public class ZombieFastFactory implements EntityFactory<FastZombie>{
	@Override
	public FastZombie newEntity() {
		return new FastZombie();
	}
}