package com.jinqiu.zombieattack.view.attached;

import android.graphics.PointF;
import android.graphics.RectF;

/** The view rectangle */
public class ViewRect extends RectF {

	public ViewRect(PointF leftTop, PointF rightBottom) {
		super(leftTop.x, leftTop.y, rightBottom.x, rightBottom.y);
	}

	public ViewRect(float left, float top, float right, float bottom) {
		super(left, top, right, bottom);
	}

	/**
	 * Get the left top position
	 * 
	 * @return The position
	 */
	public PointF getLeftTop() {
		return new PointF(left, top);
	}

	/**
	 * Get the right bottom position
	 * 
	 * @return The position
	 */
	public PointF getRightBottom() {
		return new PointF(right, bottom);
	}

	/**
	 * Whether the point is inside the rectangle
	 * 
	 * @param point
	 *            The given position
	 * @return True: the position is inside rectangle
	 */
	public boolean isInside(PointF point) {
		return left < point.x && point.x < right && top < point.y
				&& point.y < bottom;
	}
}
