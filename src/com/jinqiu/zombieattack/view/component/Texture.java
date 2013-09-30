package com.jinqiu.zombieattack.view.component;

import android.graphics.Bitmap;
import android.graphics.PointF;

import com.jinqiu.zombieattack.view.attached.BitmapManager;
import com.jinqiu.zombieattack.view.attached.ModelViewScreenTrans;

/** To represent a static image */
public class Texture extends ViewComponent {
	/** The image id of the static image */
	private int imageID;

	public Texture(Integer imageID, PointF center) {
		super(center);
		this.imageID = imageID;
	}

	@Override
	protected Bitmap getCurrentBitmap() {
		return BitmapManager.getBitmap(imageID, frameTransformation);
	}

	@Override
	protected void setTransformation() {
		frameTransformation = ModelViewScreenTrans
				.getViewToScreenTransformation();
	}

}
