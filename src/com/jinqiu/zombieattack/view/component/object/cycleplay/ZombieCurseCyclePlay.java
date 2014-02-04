package com.jinqiu.zombieattack.view.component.object.cycleplay;

import java.util.Arrays;

import com.jinqiu.zombieattack.model.objectstate.ExpirableObjectState;
import com.jinqiu.zombieattack.view.activities.R;

public class ZombieCurseCyclePlay extends CyclePlay {

	public ZombieCurseCyclePlay(ExpirableObjectState firstObjectState) {
		super(firstObjectState);

		disappearance_left = Arrays.asList(
				R.drawable.zombie_curse_death_left_1,
				R.drawable.zombie_curse_death_left_2,
				R.drawable.zombie_curse_death_left_3,
				R.drawable.zombie_curse_death_left_4,
				R.drawable.zombie_curse_death_left_5,
				R.drawable.zombie_curse_death_left_6,
				R.drawable.zombie_curse_death_left_7,
				R.drawable.zombie_curse_death_left_8,
				R.drawable.zombie_curse_death_left_9,
				R.drawable.zombie_curse_death_left_10,
				R.drawable.zombie_curse_death_left_11,
				R.drawable.zombie_curse_death_left_12,
				R.drawable.zombie_curse_death_left_13,
				R.drawable.zombie_curse_death_left_14,
				R.drawable.zombie_curse_death_left_15,
				R.drawable.zombie_curse_death_left_16,
				R.drawable.zombie_curse_death_left_17,
				R.drawable.zombie_curse_death_left_18,
				R.drawable.zombie_curse_death_left_19);
		disappearance_right = Arrays.asList(
				R.drawable.zombie_curse_death_right_1,
				R.drawable.zombie_curse_death_right_2,
				R.drawable.zombie_curse_death_right_3,
				R.drawable.zombie_curse_death_right_4,
				R.drawable.zombie_curse_death_right_5,
				R.drawable.zombie_curse_death_right_6,
				R.drawable.zombie_curse_death_right_7,
				R.drawable.zombie_curse_death_right_8,
				R.drawable.zombie_curse_death_right_9,
				R.drawable.zombie_curse_death_right_10,
				R.drawable.zombie_curse_death_right_11,
				R.drawable.zombie_curse_death_right_12,
				R.drawable.zombie_curse_death_right_13,
				R.drawable.zombie_curse_death_right_14,
				R.drawable.zombie_curse_death_right_15,
				R.drawable.zombie_curse_death_right_16,
				R.drawable.zombie_curse_death_right_17,
				R.drawable.zombie_curse_death_right_18,
				R.drawable.zombie_curse_death_right_19);
		disappearance_up = Arrays.asList(R.drawable.zombie_curse_death_up_1,
				R.drawable.zombie_curse_death_up_2,
				R.drawable.zombie_curse_death_up_3,
				R.drawable.zombie_curse_death_up_4,
				R.drawable.zombie_curse_death_up_5,
				R.drawable.zombie_curse_death_up_6,
				R.drawable.zombie_curse_death_up_7,
				R.drawable.zombie_curse_death_up_8,
				R.drawable.zombie_curse_death_up_9,
				R.drawable.zombie_curse_death_up_10,
				R.drawable.zombie_curse_death_up_11,
				R.drawable.zombie_curse_death_up_12,
				R.drawable.zombie_curse_death_up_13,
				R.drawable.zombie_curse_death_up_14,
				R.drawable.zombie_curse_death_up_15,
				R.drawable.zombie_curse_death_up_16,
				R.drawable.zombie_curse_death_up_17,
				R.drawable.zombie_curse_death_up_18,
				R.drawable.zombie_curse_death_up_19);
		disappearance_down = Arrays.asList(
				R.drawable.zombie_curse_death_down_1,
				R.drawable.zombie_curse_death_down_2,
				R.drawable.zombie_curse_death_down_3,
				R.drawable.zombie_curse_death_down_4,
				R.drawable.zombie_curse_death_down_5,
				R.drawable.zombie_curse_death_down_6,
				R.drawable.zombie_curse_death_down_7,
				R.drawable.zombie_curse_death_down_8,
				R.drawable.zombie_curse_death_down_9,
				R.drawable.zombie_curse_death_down_10,
				R.drawable.zombie_curse_death_down_11,
				R.drawable.zombie_curse_death_down_12,
				R.drawable.zombie_curse_death_down_13,
				R.drawable.zombie_curse_death_down_14,
				R.drawable.zombie_curse_death_down_15,
				R.drawable.zombie_curse_death_down_16,
				R.drawable.zombie_curse_death_down_17,
				R.drawable.zombie_curse_death_down_18,
				R.drawable.zombie_curse_death_down_19);

		running_left = Arrays.asList(R.drawable.zombie_curse_walk_left_1,
				R.drawable.zombie_curse_walk_left_2,
				R.drawable.zombie_curse_walk_left_3,
				R.drawable.zombie_curse_walk_left_4,
				R.drawable.zombie_curse_walk_left_5,
				R.drawable.zombie_curse_walk_left_6,
				R.drawable.zombie_curse_walk_left_7,
				R.drawable.zombie_curse_walk_left_8);
		running_right = Arrays.asList(R.drawable.zombie_curse_walk_right_1,
				R.drawable.zombie_curse_walk_right_2,
				R.drawable.zombie_curse_walk_right_3,
				R.drawable.zombie_curse_walk_right_4,
				R.drawable.zombie_curse_walk_right_5,
				R.drawable.zombie_curse_walk_right_6,
				R.drawable.zombie_curse_walk_right_7,
				R.drawable.zombie_curse_walk_right_8);
		running_up = Arrays.asList(R.drawable.zombie_curse_walk_up_1,
				R.drawable.zombie_curse_walk_up_2,
				R.drawable.zombie_curse_walk_up_3,
				R.drawable.zombie_curse_walk_up_4,
				R.drawable.zombie_curse_walk_up_5,
				R.drawable.zombie_curse_walk_up_6,
				R.drawable.zombie_curse_walk_up_7,
				R.drawable.zombie_curse_walk_up_8);
		running_down = Arrays.asList(R.drawable.zombie_curse_walk_down_1,
				R.drawable.zombie_curse_walk_down_2,
				R.drawable.zombie_curse_walk_down_3,
				R.drawable.zombie_curse_walk_down_4,
				R.drawable.zombie_curse_walk_down_5,
				R.drawable.zombie_curse_walk_down_6,
				R.drawable.zombie_curse_walk_down_7,
				R.drawable.zombie_curse_walk_down_8);

		standing_left = Arrays.asList(R.drawable.zombie_curse_walk_left_1);
		standing_right = Arrays.asList(R.drawable.zombie_curse_walk_right_1);
		standing_up = Arrays.asList(R.drawable.zombie_curse_walk_up_1);
		standing_down = Arrays.asList(R.drawable.zombie_curse_walk_down_1);

		initializeBitmap();
	}
}
