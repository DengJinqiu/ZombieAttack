package com.jinqiu.zombieattack.view.component;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;

import com.jinqiu.zombieattack.view.attached.FrameTransformation;
import com.jinqiu.zombieattack.view.attached.ViewRect;

/** The view component used in the view */
public abstract class ViewComponent {
	/** The top left point of the view component */
	protected PointF center;

	/** The transformation to the screen */
	protected FrameTransformation frameTransformation;

	/**
	 * Constructor
	 * 
	 * @param center
	 *            The center of the view component
	 */
	public ViewComponent(PointF center) {
		setTransformation();
		setCenter(center);
	}

	/** Set the transformation from the view or model to the screen */
	protected abstract void setTransformation();

	/** Get the current bitmap */
	protected abstract Bitmap getCurrentBitmap();

	/**
	 * Set the center of the component
	 * 
	 * @param center
	 *            The center
	 */
	public void setCenter(PointF center) {
		this.center = frameTransformation.transform(center);
	}

	/**
	 * Draw the view component
	 * 
	 * @param canvas
	 *            Use to draw
	 */
	public void draw(Canvas canvas) {
		int left = (int) (center.x - getCurrentBitmap().getWidth() / 2);
		int top = (int) (center.y - getCurrentBitmap().getHeight() / 2);
		canvas.drawBitmap(getCurrentBitmap(), left, top, null);
	}

	/**
	 * Get the size of the view component
	 * 
	 * @return The view rectangle of the view component
	 */
	public ViewRect getViewRect() {
		int width = getCurrentBitmap().getWidth();
		int height = getCurrentBitmap().getHeight();
		return new ViewRect(center.x - width / 2, center.y - height / 2,
				center.x + width / 2, center.y + height / 2);
	}

}