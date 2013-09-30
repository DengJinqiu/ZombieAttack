package com.jinqiu.zombieattack.view.component.object;

import android.graphics.Bitmap;
import android.graphics.PointF;

import com.jinqiu.zombieattack.view.component.object.imageframe.ImageFrame;

/** The view static expirable object */
public class ViewStaticExpirableObject extends ViewExpirableObject {
	/** The bitmap */
	private Bitmap bitmap;

	public ViewStaticExpirableObject(ImageFrame imageFrame, PointF center) {
		super(center);
		bitmap = imageFrame.getBitmap(frameTransformation);
	}

	@Override
	protected Bitmap getCurrentBitmap() {
		return bitmap;
	}

}
