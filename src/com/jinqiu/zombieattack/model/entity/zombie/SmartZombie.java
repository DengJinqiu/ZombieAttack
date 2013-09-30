package com.jinqiu.zombieattack.model.entity.zombie;

import java.util.List;

import com.jinqiu.zombieattack.model.ExpirableObjectType;
import com.jinqiu.zombieattack.model.GameModel;
import com.jinqiu.zombieattack.model.attached.DetectionContext;
import com.jinqiu.zombieattack.model.attached.Position;
import com.jinqiu.zombieattack.model.attached.Vector;
import com.jinqiu.zombieattack.model.entity.Entity;
import com.jinqiu.zombieattack.model.entity.Rectangle;
import com.jinqiu.zombieattack.model.entity.boulder.Boulder;

/** This zombie will run away from the boulder */
public class SmartZombie extends Zombie {
	/** The width of moving up and down */
	private static final int WIDTH_UP_DOWN = 31;
	/** The height of moving up and down */
	private static final int HEIGHT_UP_DOWN = 60;
	/** The width of moving left and right */
	private static final int WIDTH_LEFT_RIGHT = 23;
	/** The height of moving left and right */
	private static final int HEIGHT_LEFT_RIGHT = 58;
	/** The number of disappearance count */
	private static final int DESTRUCTION_PEROID = 11;
	/** The running speed */
	private static final int RUNNING_SPEED = 3;
	/** The health point */
	private static final int HEALTH_POINT = 2;
	/** The zombie damage to the scientist */
	private static final int ZOMBIE_DAMAGE = 1;
	/** The score of killing this zombie */
	private static final int ZOMBIE_SCORE = 5;
	/** The running speed when running away from the boulder */
	private static final int RUNNING_SPEED_AFTER_DETECTION = 10;

	public SmartZombie() {
		super(WIDTH_UP_DOWN, HEIGHT_UP_DOWN, WIDTH_LEFT_RIGHT,
				HEIGHT_LEFT_RIGHT, RUNNING_SPEED, HEALTH_POINT, ZOMBIE_DAMAGE,
				-1, -1, DESTRUCTION_PEROID);
		openDetectionRegion();
	}

	@Override
	public void initialObjectType() {
		super.initialObjectType();
		addExpirableObjectType(ExpirableObjectType.SmartZombie);
	}

	@Override
	public void update() {
		super.update();
		setSpeed(RUNNING_SPEED);
	}

	@Override
	protected void detectBoulder(Boulder boulder,
			DetectionContext detectionContext) {
		setSpeed(RUNNING_SPEED_AFTER_DETECTION);

		Vector vector = new Vector(boulder.getCenter(), this.getCenter());
		Position end = new Position(getCenterX(), getCenterY());
		end.plus(vector);
		runningPath = getCenter().linePosition(end, HEIGHT_UP_DOWN);

		Position nextPosition = runningPath.get(runningPath.size() - 1);

		List<Entity> barriers = detectionContext.getBarriers();

		for (int i = 0; i < barriers.size(); i++) {
			if (((Rectangle) barriers.get(i)).isInside(nextPosition)) {
				int temp = barriers.get(i).onWhichSide(getCenter());
				if (temp == 0 || temp == 2) {
					if (boulder.getCenterX() > GameModel.getGameFrameWidth() / 2) {
						end = new Position(0, getCenterY());
					} else {
						end = new Position(GameModel.getGameFrameWidth(),
								getCenterY());
					}
				} else {
					if (boulder.getCenterY() > GameModel.getGameFrameHeight() / 2) {
						end = new Position(getCenterX(), 0);
					} else {
						end = new Position(getCenterX(),
								GameModel.getGameFrameHeight());
					}
				}
				runningPath = getCenter().linePosition(end);
				break;
			}
		}

		runningPositionIndex = 0;
	}

	@Override
	public int score() {
		return ZOMBIE_SCORE;
	}

}
