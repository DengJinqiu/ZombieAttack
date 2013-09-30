package com.jinqiu.zombieattack.view.component;

import java.util.HashMap;
import java.util.Map;

import android.graphics.PointF;

import com.jinqiu.zombieattack.listener.ExpirableObjectListener;
import com.jinqiu.zombieattack.model.entity.Entity;
import com.jinqiu.zombieattack.model.objectstate.ExpirableObjectState;

/** The double view icon */
public class DoubleViewIcon extends EnumViewComponent<DoubleViewIcon.State> {
	/** The state */
	public static enum State {
		TURN_ON, TURN_OFF
	}

	public DoubleViewIcon(Integer turnOnID, Integer turnOffID, PointF center,
			Entity entity) {
		super(createKeyMap(turnOnID, turnOffID), State.TURN_ON, center);
		entity.addExpirableObjectListener(new ExpirableObjectListener() {

			@Override
			public void remove() {
				turnOff();
			}

			@Override
			public void update(int centerX, int centerY,
					ExpirableObjectState objectState) {
			}
		});
	}

	/** Change the image */
	private void turnOff() {
		setCurrentImageKey(State.TURN_OFF);
	}

	private static Map<State, Integer> createKeyMap(Integer turnOnID,
			Integer turnOffID) {
		Map<State, Integer> map = new HashMap<State, Integer>();
		map.put(State.TURN_ON, turnOnID);
		map.put(State.TURN_OFF, turnOffID);
		return map;
	}

}
