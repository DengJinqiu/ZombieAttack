package com.jinqiu.zombieattack.view.component.object.imageframe;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import android.graphics.Bitmap;

import com.jinqiu.zombieattack.view.attached.BitmapManager;
import com.jinqiu.zombieattack.view.attached.FrameTransformation;

/** The static image frame */
public abstract class ImageFrame {
	/** The available image ids */
	List<Integer> imageList;

	public ImageFrame() {
		imageList = new ArrayList<Integer>();
	}

	/**
	 * Randomly get a bitmap
	 * 
	 * @param frameTransformation
	 *            The transformation from view or model to screen
	 * @return The bitmap
	 */
	public Bitmap getBitmap(FrameTransformation frameTransformation) {
		Random random = new Random();
		return BitmapManager.getBitmap(
				imageList.get(random.nextInt(imageList.size())),
				frameTransformation);
	}
}
