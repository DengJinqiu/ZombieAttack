package com.jinqiu.zombieattack.view.attached;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.LruCache;

/** The bitmap manager to load the bitmaps */
public class BitmapManager {
	/** The resource to load the bitmaps */
	private static Resources resources;
	/** Use 1/8th of the available memory for this memory cache. */
	private static int cacheSize;
	/** The bitmap cache */
	private static LruCache<Integer, Bitmap> bitmapCache;

	/**
	 * Get the resource
	 * 
	 * @param resources
	 *            The resource
	 */
	public static void setResources(Resources resources) {
		if (BitmapManager.resources == null) {
			BitmapManager.resources = resources;
			int maxMemory = (int) (Runtime.getRuntime().maxMemory());
			cacheSize = maxMemory / 8;
			// cacheSize = 10;
			bitmapCache = new LruCache<Integer, Bitmap>(cacheSize) {
				@Override
				protected int sizeOf(Integer key, Bitmap value) {
					return value.getHeight() * value.getWidth() * 4;
				}
			};
		}
	}

	/**
	 * Get the bitmap
	 * 
	 * @param imageID
	 *            The imageID of the bitmap
	 * @param frameTransformation
	 *            The transformation of the bitmap
	 * @return Get the bitmap
	 */
	public static Bitmap getBitmap(int imageID,
			FrameTransformation frameTransformation) {
		Bitmap bitmap = bitmapCache.get(imageID);
		if (bitmap == null) {
			BitmapFactory.Options options = new BitmapFactory.Options();
			options.inScaled = false;
			bitmap = BitmapFactory.decodeResource(resources, imageID, options);

			bitmap = Bitmap.createScaledBitmap(bitmap,
					(int) frameTransformation.transform(bitmap.getWidth()),
					(int) frameTransformation.transform(bitmap.getHeight()),
					false);

			bitmapCache.put(imageID, bitmap);
		}

		return bitmap;
	}
}
