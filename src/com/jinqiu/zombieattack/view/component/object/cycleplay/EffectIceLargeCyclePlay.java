package com.jinqiu.zombieattack.view.component.object.cycleplay;

import java.util.Arrays;

import com.jinqiu.zombieattack.model.objectstate.ExpirableObjectState;
import com.jinqiu.zombieattack.view.activities.R;

public class EffectIceLargeCyclePlay extends CyclePlay {

	public EffectIceLargeCyclePlay(ExpirableObjectState firstObjectState) {
		super(firstObjectState);

		appearance = Arrays.asList(R.drawable.effect_ice_large_appearance_1,
				R.drawable.effect_ice_large_appearance_2,
				R.drawable.effect_ice_large_appearance_3,
				R.drawable.effect_ice_large_appearance_4,
				R.drawable.effect_ice_large_appearance_5);

		disappearance_down = Arrays.asList(
				R.drawable.effect_ice_large_disappearance_1,
				R.drawable.effect_ice_large_disappearance_2,
				R.drawable.effect_ice_large_disappearance_3,
				R.drawable.effect_ice_large_disappearance_4);

		running_down = Arrays.asList(R.drawable.effect_ice_large_on_1);

		initializeBitmap();
	}
}
