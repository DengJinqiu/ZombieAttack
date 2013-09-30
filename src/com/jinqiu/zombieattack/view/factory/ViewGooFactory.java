package com.jinqiu.zombieattack.view.factory;

import android.graphics.PointF;

import com.jinqiu.zombieattack.model.ExpirableObject;
import com.jinqiu.zombieattack.view.component.object.ViewExpirableObject;
import com.jinqiu.zombieattack.view.component.object.ViewStaticExpirableObject;
import com.jinqiu.zombieattack.view.component.object.imageframe.GooImageFrame;

public class ViewGooFactory implements ViewExpirableObjectFactory {

	@Override
	public ViewExpirableObject getViewExpirableObject(
			ExpirableObject expirableObject) {

		return new ViewStaticExpirableObject(new GooImageFrame(), new PointF(
				expirableObject.getCenterX(), expirableObject.getCenterY()));
	}

}
