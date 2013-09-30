package com.jinqiu.zombieattack.view.attached;

import android.graphics.PointF;

/** The transformation */
public class FrameTransformation {
	/** The scale of transformation */
	private float scale;
	/** The translation of transformation */
	private PointF translation = new PointF();

	/**
	 * Constructor
	 * 
	 * @param frame1Width
	 *            The width of the first frame
	 * @param frame1Height
	 *            The height of the first frame
	 * @param frame2Width
	 *            The width of the second frame
	 * @param frame2Height
	 *            The height of the second frame
	 * @param shift
	 *            The shift of the transformation
	 */
	public FrameTransformation(float frame1Width, float frame1Height,
			float frame2Width, float frame2Height, PointF shift) {
		float rateHeight = frame2Height / frame1Height;
		float rateWidth = frame2Width / frame1Width;
		if (rateHeight > rateWidth) {
			scale = rateWidth;
		} else {
			scale = rateHeight;
		}
		translation.x = (frame2Width - frame1Width * scale) / 2 + shift.x;
		translation.y = (frame2Height - frame1Height * scale) / 2 + shift.y;
	}

	public FrameTransformation(float scale, PointF translation) {
		this.scale = scale;
		this.translation = translation;
	}

	public float getScale() {
		return scale;
	}

	public PointF getTranslation() {
		return translation;
	}

	/**
	 * Transform the given rectangle
	 * 
	 * @param viewRect
	 *            The given rectangle
	 * @return The result
	 */
	public ViewRect transform(ViewRect viewRect) {
		return new ViewRect(transform(viewRect.getLeftTop()),
				transform(viewRect.getRightBottom()));
	}

	/**
	 * Transform the given point
	 * 
	 * @param point
	 *            The given point
	 * @return The result
	 */
	public PointF transform(PointF point) {
		return new PointF(point.x * scale + translation.x, point.y * scale
				+ translation.y);
	}

	/**
	 * Transform the length
	 * 
	 * @param length
	 *            The given length
	 * @return The result
	 */
	public float transform(float length) {
		return length * scale;
	}

	/**
	 * Add a given transformation to this transformation and return the new
	 * transformation
	 * 
	 * @param frameTransformation
	 *            The given transformation
	 * @return The result
	 */
	public FrameTransformation addFrameTransformation(
			FrameTransformation frameTransformation) {
		return new FrameTransformation(scale * frameTransformation.getScale(),
				new PointF(getTranslation().x * frameTransformation.getScale()
						+ frameTransformation.getTranslation().x,
						getTranslation().y * frameTransformation.getScale()
								+ frameTransformation.getTranslation().y));
	}

	/**
	 * Get the inverted transformation
	 * 
	 * @return The result
	 */
	public FrameTransformation getBackwardTransformation() {
		return new FrameTransformation(1 / getScale(), new PointF(
				-getTranslation().x / getScale(), -getTranslation().y
						/ getScale()));
	}
}
