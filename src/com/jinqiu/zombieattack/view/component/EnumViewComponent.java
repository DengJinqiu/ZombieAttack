package com.jinqiu.zombieattack.view.component;

import java.util.Map;

import android.graphics.Bitmap;
import android.graphics.PointF;

import com.jinqiu.zombieattack.view.attached.BitmapManager;
import com.jinqiu.zombieattack.view.attached.ModelViewScreenTrans;

/** This kind of view component has several images */
public abstract class EnumViewComponent<K> extends ViewComponent {
	/** The map between image id to the state */
	protected Map<K, Integer> imageIDs;

	/** The current image key */
	private K currentImageKey;

	public EnumViewComponent(Map<K, Integer> imageIDs, K firstImageKey,
			PointF center) {
		super(center);
		this.currentImageKey = firstImageKey;

		this.imageIDs = imageIDs;
	}

	/** Get the current image key */
	protected K getCurrentImageKey() {
		return this.currentImageKey;
	}

	/** Set the current image key */
	protected void setCurrentImageKey(K key) {
		this.currentImageKey = key;
	}

	@Override
	protected Bitmap getCurrentBitmap() {
		return BitmapManager.getBitmap(imageIDs.get(currentImageKey),
				frameTransformation);
	}

	@Override
	protected void setTransformation() {
		this.frameTransformation = ModelViewScreenTrans
				.getViewToScreenTransformation();
	}

}
