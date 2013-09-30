package com.jinqiu.zombieattack.view.component.object;

import android.graphics.Bitmap;
import android.graphics.PointF;

import com.jinqiu.zombieattack.listener.ExpirableObjectListener;
import com.jinqiu.zombieattack.model.ExpirableObject;
import com.jinqiu.zombieattack.model.objectstate.ExpirableObjectState;
import com.jinqiu.zombieattack.view.component.object.cycleplay.CyclePlay;

/** The view moving expirable object */
public class ViewMovingExpirableObject extends ViewExpirableObject {
	/** The cycle play of the moving object */
	private CyclePlay cyclePlay;

	public ViewMovingExpirableObject(ExpirableObject expirableObject,
			CyclePlay cyclePlay, PointF center) {
		super(center);

		this.cyclePlay = cyclePlay;

		expirableObject
				.addExpirableObjectListener(new ExpirableObjectListener() {
					@Override
					public void update(int centerX, int centerY,
							ExpirableObjectState objectState) {
						ViewMovingExpirableObject.this.setCenter(new PointF(
								centerX, centerY));
						ViewMovingExpirableObject.this.cyclePlay
								.playNextImage(objectState);
					}

					@Override
					public void remove() {
						ViewMovingExpirableObject.this.shouldBeRemoved = true;
					}
				});
	}

	@Override
	protected Bitmap getCurrentBitmap() {
		return cyclePlay.getBitmap(frameTransformation);
	}

}
