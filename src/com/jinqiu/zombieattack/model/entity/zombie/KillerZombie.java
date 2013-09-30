package com.jinqiu.zombieattack.model.entity.zombie;

import java.util.List;
import java.util.Random;

import com.jinqiu.zombieattack.model.ExpirableObjectType;
import com.jinqiu.zombieattack.model.attached.DetectionContext;
import com.jinqiu.zombieattack.model.attached.Position;
import com.jinqiu.zombieattack.model.attached.Vector;
import com.jinqiu.zombieattack.model.entity.Entity;
import com.jinqiu.zombieattack.model.entity.Rectangle;
import com.jinqiu.zombieattack.model.entity.scientist.Scientist;
import com.jinqiu.zombieattack.model.objectstate.LifeState;

/** It will chase a scientist, while the scientist is in the detection region. */
public class KillerZombie extends Zombie {
	/** The width of moving up and down */
	private static final int WIDTH_UP_DOWN = 45;
	/** The height of moving up and down */
	private static final int HEIGHT_UP_DOWN = 49;
	/** The width of moving left and right */
	private static final int WIDTH_LEFT_RIGHT = 45;
	/** The height of moving left and right */
	private static final int HEIGHT_LEFT_RIGHT = 49;
	/** The number of disappearance count */
	private static final int DESTRUCTION_PEROID = 7;
	/** The running speed */
	private static final int RUNNING_SPEED = 3;
	/** The health point */
	private static final int HEALTH_POINT = 1;
	/** The zombie damage to the scientist */
	private static final int ZOMBIE_DAMAGE = Integer.MAX_VALUE;
	/** The score of killing this zombie */
	private static final int ZOMBIE_SCORE = 5;
	/** The running speed when detect scientist */
	private static final int RUNNING_SPEED_AFTER_DETECTION = 10;
	/** When the zombie cannot detect the scientist */
	private static final int UNDETECTING_COUNT = 2;
	/** Whether the zombie is blocked by the barrier */
	private boolean blockedByBarrier;

	public KillerZombie() {
		super(WIDTH_UP_DOWN, HEIGHT_UP_DOWN, WIDTH_LEFT_RIGHT,
				HEIGHT_LEFT_RIGHT, RUNNING_SPEED, HEALTH_POINT, ZOMBIE_DAMAGE,
				-1, -1, DESTRUCTION_PEROID);
		openDetectionRegion();
		blockedByBarrier = false;
	}

	@Override
	public void update() {
		super.update();
		setSpeed(RUNNING_SPEED);
		if (blockedByBarrier && countToMarkedUpdateCount() > UNDETECTING_COUNT) {
			blockedByBarrier = false;
		}
	}

	@Override
	public void initialObjectType() {
		super.initialObjectType();
		addExpirableObjectType(ExpirableObjectType.KillerZombie);
	}

	@Override
	protected void detectScientist(Scientist scientist,
			DetectionContext detectionContext) {

		if (!scientist.isInvincible()
				&& scientist.getObjectState().getLifeState() == LifeState.NORMAL
				&& !blockedByBarrier) {
			Vector vector = new Vector(this.getCenter(), scientist.getCenter());
			Position end = new Position(getCenterX(), getCenterY());
			end.plus(vector);
			List<Entity> barriers = detectionContext.getBarriers();
			Random random = new Random();
			for (Entity barrier : barriers) {
				int temp = random.nextInt(4);
				if (temp == 0) {
					if (!barrier
							.isExpirableObjectType(ExpirableObjectType.ScreenBound)
							&& (((Rectangle) barrier).isIntersect(getTopLeft(),
									end))) {
						// the zombie cannot see the scientist
						return;
					}
				} else if (temp == 1) {
					if (!barrier
							.isExpirableObjectType(ExpirableObjectType.ScreenBound)
							&& (((Rectangle) barrier).isIntersect(
									getBottomRight(), end))) {
						// the zombie cannot see the scientist
						return;
					}
				} else if (temp == 2) {
					if (!barrier
							.isExpirableObjectType(ExpirableObjectType.ScreenBound)
							&& (((Rectangle) barrier).isIntersect(
									getTopRight(), end))) {
						// the zombie cannot see the scientist
						return;
					}
				} else if (temp == 3) {
					if (!barrier
							.isExpirableObjectType(ExpirableObjectType.ScreenBound)
							&& (((Rectangle) barrier).isIntersect(
									getBottomLeft(), end))) {
						// the zombie cannot see the scientist
						return;
					}
				}
			}
			setSpeed(RUNNING_SPEED_AFTER_DETECTION);
			runningPath = getCenter().linePosition(end);
			runningPositionIndex = 0;
		}
	}

	@Override
	public int score() {
		return ZOMBIE_SCORE;
	}

}