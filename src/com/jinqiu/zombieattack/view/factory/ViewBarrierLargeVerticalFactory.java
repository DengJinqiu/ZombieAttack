package com.jinqiu.zombieattack.view.factory;

import android.graphics.PointF;

import com.jinqiu.zombieattack.model.ExpirableObject;
import com.jinqiu.zombieattack.view.component.object.ViewExpirableObject;
import com.jinqiu.zombieattack.view.component.object.ViewStaticExpirableObject;
import com.jinqiu.zombieattack.view.component.object.imageframe.BarrierLargeVerticalImageFrame;

public class ViewBarrierLargeVerticalFactory implements
		ViewExpirableObjectFactory {

	@Override
	public ViewExpirableObject getViewExpirableObject(
			ExpirableObject expirableObject) {

		return new ViewStaticExpirableObject(
				new BarrierLargeVerticalImageFrame(), new PointF(
						expirableObject.getCenterX(),
						expirableObject.getCenterY()));
	}

}
