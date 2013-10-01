package com.jinqiu.zombieattack.model;

import java.util.ArrayList;
import java.util.List;

import com.jinqiu.zombieattack.listener.ExpirableObjectListener;
import com.jinqiu.zombieattack.model.attached.CleanupContext;
import com.jinqiu.zombieattack.model.objectstate.ExpirableObjectState;
import com.jinqiu.zombieattack.model.objectstate.InvincibleState;
import com.jinqiu.zombieattack.model.objectstate.LifeState;
import com.jinqiu.zombieattack.model.objectstate.RunningState;

/**
 * There are two kinds of expirable object in the game, entity and effect. Each
 * of them has an object state, including appearance period when it appears, a
 * normal period, and a disappearance period when it disappears.
 */
public abstract class ExpirableObject {
	/** The object state */
	protected ExpirableObjectState expirableObjectState;
	/** The number of update for normal state, -1 means infinite */
	private int normalCount;
	/** The number of update for appearance state, when the object appear */
	private int appearanceCount;
	/** The number of update for disappearance state, when the object disappear */
	private int disappearanceCount;
	/** The update count, starts from 0 */
	private int updateCount;
	/** The marked update count */
	private int markedUpdateCount;
	/**
	 * Indicate whether we should remove it from the game. When true it is dead.
	 */
	protected boolean shouldBeRemoved;
	/** Object listeners */
	private List<ExpirableObjectListener> expirableObjectListeners;

	/** The type of the object */
	private List<ExpirableObjectType> expirableObjectTypes;

	/**
	 * Set up the update count for the three state
	 * 
	 * @param appearanceCount
	 *            The appearance state count
	 * @param normalCount
	 *            The normal state count
	 * @param disappearanceCount
	 *            The disappearance state count
	 */
	public ExpirableObject(int appearanceCount, int normalCount,
			int disappearanceCount) {
		this.appearanceCount = appearanceCount;
		this.normalCount = normalCount;
		this.disappearanceCount = disappearanceCount;
		updateCount = 0;

		shouldBeRemoved = false;

		expirableObjectTypes = new ArrayList<ExpirableObjectType>();

		expirableObjectState = new ExpirableObjectState();
		if (appearanceCount < 0) {
			expirableObjectState.setLifeState(LifeState.NORMAL);
		}

		expirableObjectListeners = new ArrayList<ExpirableObjectListener>();

		initialObjectType();
	}

	/** Add entity type */
	protected void addExpirableObjectType(
			ExpirableObjectType expirableObjectType) {
		this.expirableObjectTypes.add(expirableObjectType);
	}

	/** Initial the entity type */
	protected abstract void initialObjectType();

	/**
	 * Check whether it belongs to the given entity type
	 * 
	 * @param objectType
	 *            The given entity type
	 * @return True: belongs to the given entity type
	 */
	public boolean isExpirableObjectType(ExpirableObjectType objectType) {
		return expirableObjectTypes.contains(objectType);
	}

	public ExpirableObjectType getDetailExpirableObjectType() {
		return expirableObjectTypes.get(expirableObjectTypes.size() - 1);
	}

	/**
	 * Check if the object should be removed.
	 * 
	 * @return Boolean True means it should be removed
	 */
	public boolean isShouldBeRemoved() {
		return shouldBeRemoved;
	}

	/**
	 * Get expirable object state
	 * 
	 * @return The current state
	 */
	public ExpirableObjectState getObjectState() {
		return expirableObjectState;
	}

	/** Finish the normal state and turn into disappearance state */
	public void startDisappear() {
		expirableObjectState.setLifeState(LifeState.DISAPPEARANCE);
		expirableObjectState.setRunningState(RunningState.STANDING);
		expirableObjectState.setInvincibleState(InvincibleState.NORMAL);
		markUpdateCount();
	}

	/** Do the clean up */
	public void cleanup(CleanupContext cleanupContext) {
	};

	/**
	 * 1. Increase the update count. <br\>
	 * 2. If during appearance state, check if turn into normal state <br\>
	 * 3. If during normal state, check if turn into disappearance state <br\>
	 * 4. If during disappearance state, check if remove it.
	 */
	public void update() {
		updateCount++;
		if (expirableObjectState.getLifeState() == LifeState.APPEARANCE
				&& updateCount >= appearanceCount) {
			expirableObjectState.setLifeState(LifeState.NORMAL);
		} else if (expirableObjectState.getLifeState() == LifeState.NORMAL
				&& normalCount > 0 && updateCount > normalCount) {
			startDisappear();
		} else if (expirableObjectState.getLifeState() == LifeState.DISAPPEARANCE
				&& countToMarkedUpdateCount() >= disappearanceCount) {
			shouldBeRemoved = true;
		}
		updateListener();
	}

	/** Mark the update count */
	public void markUpdateCount() {
		markedUpdateCount = updateCount;
	}

	/** The difference form the marked update count to the current update count */
	public int countToMarkedUpdateCount() {
		return updateCount - markedUpdateCount;
	}

	/** Add add expirable object listener */
	public void addExpirableObjectListener(
			ExpirableObjectListener objectListener) {
		expirableObjectListeners.add(objectListener);
	}

	/** Update the listeners */
	protected void updateListener() {
		// update the listeners
		for (ExpirableObjectListener objectListener : expirableObjectListeners) {
			if (isShouldBeRemoved()) {
				objectListener.remove();
			} else {
				objectListener.update(getCenterX(), getCenterY(),
						expirableObjectState);
			}
		}
	}

	/**
	 * The x coordinate of the center
	 * 
	 * @return The value
	 */
	public abstract int getCenterX();

	/**
	 * The y coordinate of the center
	 * 
	 * @return The value
	 */
	public abstract int getCenterY();
}
