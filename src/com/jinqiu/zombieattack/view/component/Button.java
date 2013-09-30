package com.jinqiu.zombieattack.view.component;

import java.util.HashMap;
import java.util.Map;

import android.graphics.PointF;

/** The button used on the menu */
public class Button extends EnumViewComponent<Button.State> {

	/** The state of the button: UP and DOWN */
	public static enum State {
		UP, DOWN
	}

	public Button(Integer upID, Integer downID, PointF center) {
		super(createKeyMap(upID, downID), State.UP, center);
	}

	/** Change the button to up state */
	public void buttonUp() {
		setCurrentImageKey(State.UP);
	}

	/** Change the button to up state */
	public void buttonDown() {
		setCurrentImageKey(State.DOWN);
	}

	/** Related the image id to the state */
	private static Map<State, Integer> createKeyMap(Integer upID, Integer downID) {
		Map<State, Integer> map = new HashMap<State, Integer>();
		map.put(State.UP, upID);
		map.put(State.DOWN, downID);
		return map;
	}
}
