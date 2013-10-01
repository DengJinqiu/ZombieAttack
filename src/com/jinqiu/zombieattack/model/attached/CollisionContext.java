package com.jinqiu.zombieattack.model.attached;

import com.jinqiu.zombieattack.model.effect.Effect;

/** Do collision context after an entity disappear */
public interface CollisionContext {

	/**
	 * Add new effect to the effect manager
	 * 
	 * @param effect
	 *            The new effect need to be add to the effect manager
	 */
	public void addEffect(Effect effect);

}
