package com.jinqiu.zombieattack.view.component.object.cycleplay;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.graphics.Bitmap;

import com.jinqiu.zombieattack.model.objectstate.DirectionState;
import com.jinqiu.zombieattack.model.objectstate.ExpirableObjectState;
import com.jinqiu.zombieattack.model.objectstate.InvincibleState;
import com.jinqiu.zombieattack.model.objectstate.LifeState;
import com.jinqiu.zombieattack.model.objectstate.RunningState;
import com.jinqiu.zombieattack.view.attached.BitmapManager;
import com.jinqiu.zombieattack.view.attached.FrameTransformation;

/** Animate the moving object */
public abstract class CyclePlay {
	/** The order of the cycle play */
	private int order = 0;
	/** The image ids */
	private List<Integer> currentImageIDs;
	/** The current object state */
	private ExpirableObjectState currentObjectState;
	/** The map between expirable object state to the image ids */
	private Map<ExpirableObjectState, List<Integer>> objectStateImageIDs;

	/** The appearance image id */
	protected List<Integer> appearance;

	/** The disappearance left image id */
	protected List<Integer> disappearance_left;
	/** The disappearance right image id */
	protected List<Integer> disappearance_right;
	/** The disappearance up image id */
	protected List<Integer> disappearance_up;
	/** The disappearance down image id */
	protected List<Integer> disappearance_down;

	/** The running left image id */
	protected List<Integer> running_left;
	/** The running right image id */
	protected List<Integer> running_right;
	/** The running up image id */
	protected List<Integer> running_up;
	/** The running down image id */
	protected List<Integer> running_down;

	/** The running invincible left image id */
	protected List<Integer> running_invincible_left;
	/** The running invincible right image id */
	protected List<Integer> running_invincible_right;
	/** The running invincible up image id */
	protected List<Integer> running_invincible_up;
	/** The running invincible down image id */
	protected List<Integer> running_invincible_down;

	/** The standing left image id */
	protected List<Integer> standing_left;
	/** The standing right image id */
	protected List<Integer> standing_right;
	/** The standing up image id */
	protected List<Integer> standing_up;
	/** The standing down image id */
	protected List<Integer> standing_down;

	/** The standing invincible left image id */
	protected List<Integer> standing_invincible_left;
	/** The standing invincible right image id */
	protected List<Integer> standing_invincible_right;
	/** The standing invincible up image id */
	protected List<Integer> standing_invincible_up;
	/** The standing invincible down image id */
	protected List<Integer> standing_invincible_down;

	public CyclePlay(ExpirableObjectState firstObjectState) {
		objectStateImageIDs = new HashMap<ExpirableObjectState, List<Integer>>();
		currentObjectState = firstObjectState.getCopy(firstObjectState);
	}

	/**
	 * Get the bitmap
	 * 
	 * @param frameTransformation
	 *            The transformation from model or view to screen
	 * @return The bitmap
	 */
	public Bitmap getBitmap(FrameTransformation frameTransformation) {
		return BitmapManager.getBitmap(currentImageIDs.get(order),
				frameTransformation);
	}

	/**
	 * Turn into the next image
	 * 
	 * @param objectState
	 *            The new object state
	 */
	public void playNextImage(ExpirableObjectState objectState) {
		if (!currentObjectState.equals(objectState)) {
			currentObjectState = objectState.getCopy(objectState);
			currentImageIDs = objectStateImageIDs.get(currentObjectState);
			order = 0;
		} else {
			order = (order + 1) % currentImageIDs.size();
		}
	}

	/** initial bitmap */
	protected void initializeBitmap() {
		objectStateImageIDs.put(new ExpirableObjectState(LifeState.APPEARANCE,
				InvincibleState.NORMAL, DirectionState.DOWN,
				RunningState.RUNNING), appearance);

		objectStateImageIDs
				.put(new ExpirableObjectState(LifeState.DISAPPEARANCE,
						InvincibleState.NORMAL, DirectionState.LEFT,
						RunningState.STANDING), disappearance_left);
		objectStateImageIDs.put(new ExpirableObjectState(
				LifeState.DISAPPEARANCE, InvincibleState.NORMAL,
				DirectionState.RIGHT, RunningState.STANDING),
				disappearance_right);
		objectStateImageIDs.put(new ExpirableObjectState(
				LifeState.DISAPPEARANCE, InvincibleState.NORMAL,
				DirectionState.UP, RunningState.STANDING), disappearance_up);
		objectStateImageIDs
				.put(new ExpirableObjectState(LifeState.DISAPPEARANCE,
						InvincibleState.NORMAL, DirectionState.DOWN,
						RunningState.STANDING), disappearance_down);

		objectStateImageIDs.put(new ExpirableObjectState(LifeState.NORMAL,
				InvincibleState.NORMAL, DirectionState.LEFT,
				RunningState.RUNNING), running_left);
		objectStateImageIDs.put(new ExpirableObjectState(LifeState.NORMAL,
				InvincibleState.NORMAL, DirectionState.RIGHT,
				RunningState.RUNNING), running_right);
		objectStateImageIDs.put(
				new ExpirableObjectState(LifeState.NORMAL,
						InvincibleState.NORMAL, DirectionState.UP,
						RunningState.RUNNING), running_up);
		objectStateImageIDs.put(new ExpirableObjectState(LifeState.NORMAL,
				InvincibleState.NORMAL, DirectionState.DOWN,
				RunningState.RUNNING), running_down);

		objectStateImageIDs.put(new ExpirableObjectState(LifeState.NORMAL,
				InvincibleState.INVINCIBLE, DirectionState.LEFT,
				RunningState.RUNNING), running_invincible_left);
		objectStateImageIDs.put(new ExpirableObjectState(LifeState.NORMAL,
				InvincibleState.INVINCIBLE, DirectionState.RIGHT,
				RunningState.RUNNING), running_invincible_right);
		objectStateImageIDs.put(new ExpirableObjectState(LifeState.NORMAL,
				InvincibleState.INVINCIBLE, DirectionState.UP,
				RunningState.RUNNING), running_invincible_up);
		objectStateImageIDs.put(new ExpirableObjectState(LifeState.NORMAL,
				InvincibleState.INVINCIBLE, DirectionState.DOWN,
				RunningState.RUNNING), running_invincible_down);

		objectStateImageIDs.put(new ExpirableObjectState(LifeState.NORMAL,
				InvincibleState.NORMAL, DirectionState.LEFT,
				RunningState.STANDING), standing_left);
		objectStateImageIDs.put(new ExpirableObjectState(LifeState.NORMAL,
				InvincibleState.NORMAL, DirectionState.RIGHT,
				RunningState.STANDING), standing_right);
		objectStateImageIDs.put(new ExpirableObjectState(LifeState.NORMAL,
				InvincibleState.NORMAL, DirectionState.UP,
				RunningState.STANDING), standing_up);
		objectStateImageIDs.put(new ExpirableObjectState(LifeState.NORMAL,
				InvincibleState.NORMAL, DirectionState.DOWN,
				RunningState.STANDING), standing_down);

		objectStateImageIDs.put(new ExpirableObjectState(LifeState.NORMAL,
				InvincibleState.INVINCIBLE, DirectionState.LEFT,
				RunningState.STANDING), standing_invincible_left);
		objectStateImageIDs.put(new ExpirableObjectState(LifeState.NORMAL,
				InvincibleState.INVINCIBLE, DirectionState.RIGHT,
				RunningState.STANDING), standing_invincible_right);
		objectStateImageIDs.put(new ExpirableObjectState(LifeState.NORMAL,
				InvincibleState.INVINCIBLE, DirectionState.UP,
				RunningState.STANDING), standing_invincible_up);
		objectStateImageIDs.put(new ExpirableObjectState(LifeState.NORMAL,
				InvincibleState.INVINCIBLE, DirectionState.DOWN,
				RunningState.STANDING), standing_invincible_down);

		currentImageIDs = objectStateImageIDs.get(currentObjectState);

		disappearance_left = null;
		disappearance_right = null;
		disappearance_up = null;
		disappearance_down = null;

		running_left = null;
		running_right = null;
		running_up = null;
		running_down = null;

		running_invincible_left = null;
		running_invincible_right = null;
		running_invincible_up = null;
		running_invincible_down = null;

		standing_left = null;
		standing_right = null;
		standing_up = null;
		standing_down = null;

		standing_invincible_left = null;
		standing_invincible_right = null;
		standing_invincible_up = null;
		standing_invincible_down = null;
	}

}
