package com.jinqiu.zombieattack.view.component;

import java.util.HashMap;
import java.util.Map;

import android.graphics.PointF;

/**
 * After hitting the button, the image will change, there are two images of the
 * button
 */
public class DoubleViewButton extends EnumViewComponent<DoubleViewButton.State> {
	/** The four state */
	public static enum State {
		UP1, DOWN1, UP2, DOWN2
	}

	public DoubleViewButton(Integer upID1, Integer downID1, Integer upID2,
			Integer downID2, PointF center) {
		super(createKeyMap(upID1, downID1, upID2, downID2), State.UP1, center);
	}

	/** Change the button image */
	public void changeButton() {
		if (getCurrentImageKey() == State.DOWN1) {
			setCurrentImageKey(State.UP2);
		} else if (getCurrentImageKey() == State.DOWN2) {
			setCurrentImageKey(State.UP1);
		}
	}

	/** Set the button to up state */
	public void buttonUp() {
		if (getCurrentImageKey() == State.DOWN1) {
			setCurrentImageKey(State.UP1);
		} else if (getCurrentImageKey() == State.DOWN2) {
			setCurrentImageKey(State.UP2);
		}
	}

	/** Set the button to down state */
	public void buttonDown() {
		if (getCurrentImageKey() == State.UP1) {
			setCurrentImageKey(State.DOWN1);
		} else if (getCurrentImageKey() == State.UP2) {
			setCurrentImageKey(State.DOWN2);
		}
	}

	/** Related the image id to the state */
	private static Map<State, Integer> createKeyMap(Integer upID1,
			Integer downID1, Integer upID2, Integer downID2) {
		Map<State, Integer> map = new HashMap<State, Integer>();
		map.put(State.UP1, upID1);
		map.put(State.DOWN1, downID1);
		map.put(State.UP2, upID2);
		map.put(State.DOWN2, downID2);
		return map;
	}
}
