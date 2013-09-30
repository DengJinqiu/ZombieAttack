package com.jinqiu.zombieattack.view.component.object;

import android.graphics.PointF;

import com.jinqiu.zombieattack.view.attached.ModelViewScreenTrans;
import com.jinqiu.zombieattack.view.component.ViewComponent;

/** Draw the view expirable object */
public abstract class ViewExpirableObject extends ViewComponent {

	public ViewExpirableObject(PointF center) {
		super(center);
		shouldBeRemoved = false;
	}

	/** Whether this view component should be removed */
	protected boolean shouldBeRemoved;

	public boolean isShouldBeRemoved() {
		return shouldBeRemoved;
	}

	@Override
	protected void setTransformation() {
		frameTransformation = ModelViewScreenTrans
				.getModelToScreenTransformation();
	}

}
