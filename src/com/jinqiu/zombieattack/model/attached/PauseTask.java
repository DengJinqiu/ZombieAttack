package com.jinqiu.zombieattack.model.attached;

import java.util.TimerTask;

/** The pause task used to pause a schedule */
public abstract class PauseTask extends TimerTask {
	protected boolean isPaused;

	/** Pause this task */
	public void pause() {
		isPaused = true;
	}

	/** Resume this task */
	public void resume() {
		isPaused = false;
	}

	@Override
	public void run() {
		if (!isPaused) {
			runIfNotPaused();
		}
	}

	/** run if not paused */
	public abstract void runIfNotPaused();
}
