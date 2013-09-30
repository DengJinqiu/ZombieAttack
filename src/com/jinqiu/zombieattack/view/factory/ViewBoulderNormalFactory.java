package com.jinqiu.zombieattack.view.factory;

import android.graphics.PointF;

import com.jinqiu.zombieattack.model.ExpirableObject;
import com.jinqiu.zombieattack.view.component.object.ViewExpirableObject;
import com.jinqiu.zombieattack.view.component.object.ViewMovingExpirableObject;
import com.jinqiu.zombieattack.view.component.object.cycleplay.BoulderNormalCyclePlay;

public class ViewBoulderNormalFactory implements ViewExpirableObjectFactory {

	@Override
	public ViewExpirableObject getViewExpirableObject(
			ExpirableObject expirableObject) {

		return new ViewMovingExpirableObject(expirableObject,
				new BoulderNormalCyclePlay(expirableObject.getObjectState()),
				new PointF(expirableObject.getCenterX(),
						expirableObject.getCenterY()));
	}

}
