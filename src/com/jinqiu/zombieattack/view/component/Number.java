package com.jinqiu.zombieattack.view.component;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import android.graphics.PointF;

import com.jinqiu.zombieattack.view.activities.R;

/** To percent a number on the screen */
public class Number extends EnumViewComponent<Number.State> {
	/** The height of the number */
	public final static int height = 40;
	/** The width of the number */
	public final static int width = 23;

	/** The state of the number: 0, 1, 2 ... 9 */
	public static enum State {
		zero, one, two, three, four, five, six, seven, eight, nine, slash, blank
	}

	public Number(PointF center) {
		super(createKeyMap(), State.zero, center);
	}

	/**
	 * Change the number
	 * 
	 * @param num
	 *            The new number
	 */
	public void changeNum(int num) {
		Iterator<State> iterator = imageIDs.keySet().iterator();
		int count = 0;
		while (iterator.hasNext()) {
			setCurrentImageKey(iterator.next());
			if (count == num) {
				break;
			} else {
				count++;
			}
		}
	}

	/** Change the the number to slash */
	public void changeToSlash() {
		setCurrentImageKey(State.slash);
	}

	/** Change the number to blank */
	public void changeToBlank() {
		setCurrentImageKey(State.blank);
	}

	/**
	 * Relate the state to image id
	 * 
	 * @return The Map between state and image id
	 */
	private static Map<State, Integer> createKeyMap() {
		Map<State, Integer> map = new LinkedHashMap<State, Integer>();
		map.put(State.zero, R.drawable.number_0);
		map.put(State.one, R.drawable.number_1);
		map.put(State.two, R.drawable.number_2);
		map.put(State.three, R.drawable.number_3);
		map.put(State.four, R.drawable.number_4);
		map.put(State.five, R.drawable.number_5);
		map.put(State.six, R.drawable.number_6);
		map.put(State.seven, R.drawable.number_7);
		map.put(State.eight, R.drawable.number_8);
		map.put(State.nine, R.drawable.number_9);
		map.put(State.blank, R.drawable.blank);

		return map;
	}

}
