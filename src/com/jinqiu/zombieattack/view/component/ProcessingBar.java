package com.jinqiu.zombieattack.view.component;

import android.graphics.Bitmap;
import android.graphics.PointF;

import com.jinqiu.zombieattack.view.attached.BitmapManager;
import com.jinqiu.zombieattack.view.attached.ModelViewScreenTrans;

/** The processing bar */
public class ProcessingBar extends ViewComponent {
	/** The bottom right corner of the processing bar */
	private PointF bottomRight;
	/** The image id to draw the processing bar */
	private int imageID;

	/** The width of the processing bar */
	private float width;
	/** The height of the processing bar */
	private float height;

	/** The percentage to draw the processing bar */
	private float percentage;

	/**
	 * Constructor
	 * 
	 * @param width
	 *            The width of the processing bar
	 * @param height
	 *            The height of the processing bar
	 * @param bottomRight
	 *            The bottom right of the processing bar
	 * @param imageID
	 *            The image id to draw the processing bar
	 */
	public ProcessingBar(int width, int height, PointF bottomRight, int imageID) {
		super(new PointF(0, 0));
		this.bottomRight = frameTransformation.transform(bottomRight);

		this.width = frameTransformation.transform(width);
		this.height = frameTransformation.transform(height);

		this.imageID = imageID;
	}

	@Override
	protected Bitmap getCurrentBitmap() {
		Bitmap bitmap = BitmapManager.getBitmap(imageID, frameTransformation);
		bitmap = Bitmap.createScaledBitmap(bitmap, (int) width,
				(int) (height * percentage) <= 0 ? 1
						: (int) (height * percentage), false);
		center = new PointF(bottomRight.x - width / 2, bottomRight.y - height
				* percentage / 2);

		return bitmap;
	}

	/**
	 * Set the percentage
	 * 
	 * @param percentage
	 *            The percentage
	 */
	public void setPercentage(float percentage) {
		this.percentage = percentage;
	}

	@Override
	protected void setTransformation() {
		frameTransformation = ModelViewScreenTrans
				.getViewToScreenTransformation();
	}
}
