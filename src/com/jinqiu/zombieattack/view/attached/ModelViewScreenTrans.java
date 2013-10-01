package com.jinqiu.zombieattack.view.attached;

import android.graphics.PointF;
import android.util.Log;

import com.jinqiu.zombieattack.model.GameModel;

/** The transformation between view, model and screen */
public class ModelViewScreenTrans {
	/** The view frame width */
	private static final int VIEW_FRAME_WIDTH = 854;
	/** The view frame height */
	private static final int VIEW_FRAME_HEIGHT = 480;

	/** The game frame width */
	private static final int GAME_FRAME_WIDTH = GameModel.getGameFrameWidth();
	/** The game frame height */
	private static final int GAME_FRAME_HEIGHT = GameModel.getGameFrameHeight();

	/** The width of the game in the view */
	private static final int GAME_IN_VIEW_WIDTH = 760;
	/** The height of the game in the view */
	private static final int GAME_IN_VIEW_HEIGHT = GAME_FRAME_HEIGHT;
	/** The left top position of the game in the view */
	private static final PointF GAME_IN_VIEW_SHIFT = new PointF(60, 0);

	/** Model to screen transformation */
	private static FrameTransformation modelToScreenTransformation;
	/** View to screen transformation */
	private static FrameTransformation viewToScreenTransformation;
	/** Screen to model transformation */
	private static FrameTransformation screenToModelTransformation;
	/** Screen to view transformation */
	private static FrameTransformation screenToViewTransformation;

	/** Whether the transformation is initialized */
	private static boolean initialized = false;

	/**
	 * Initialize the transformation
	 * 
	 * @param screenWidth
	 *            The screen width
	 * @param screenHeight
	 *            The screen height
	 */
	public static void initialize(int screenWidth, int screenHeight) {
		if (!initialized) {
//			Log.d("screen size", screenWidth + " " + screenHeight);
			viewToScreenTransformation = new FrameTransformation(
					VIEW_FRAME_WIDTH, VIEW_FRAME_HEIGHT, screenWidth,
					screenHeight, new PointF(0, 0));
//			Log.d("view to screen scale", viewToScreenTransformation.getScale()
//					+ "");
			modelToScreenTransformation = new FrameTransformation(
					GAME_FRAME_WIDTH, GAME_FRAME_HEIGHT, GAME_IN_VIEW_WIDTH,
					GAME_IN_VIEW_HEIGHT, GAME_IN_VIEW_SHIFT);

			modelToScreenTransformation = modelToScreenTransformation
					.addFrameTransformation(viewToScreenTransformation);
//			Log.d("model to screen scale",
//					modelToScreenTransformation.getScale() + "");

			screenToModelTransformation = modelToScreenTransformation
					.getBackwardTransformation();

			screenToViewTransformation = viewToScreenTransformation
					.getBackwardTransformation();
			initialized = true;
		}
	}

	/**
	 * Get the model to screen transformation
	 * 
	 * @return The transformation
	 */
	public static FrameTransformation getModelToScreenTransformation() {
		return modelToScreenTransformation;
	}

	/**
	 * Get the screen to model transformation
	 * 
	 * @return The transformation
	 */
	public static FrameTransformation getScreenToModelTransformation() {
		return screenToModelTransformation;
	}

	/**
	 * Get the view to screen transformation
	 * 
	 * @return The transformation
	 */
	public static FrameTransformation getViewToScreenTransformation() {
		return viewToScreenTransformation;
	}

	/**
	 * Get the screen to view transformation
	 * 
	 * @return The transformation
	 */
	public static FrameTransformation getScreenToViewTransformation() {
		return screenToViewTransformation;
	}

}
