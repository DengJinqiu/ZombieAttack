package com.jinqiu.zombieattack.view.activities;

import java.util.ArrayList;
import java.util.List;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.PointF;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.WindowManager;

import com.jinqiu.zombieattack.listener.ModelListener;
import com.jinqiu.zombieattack.model.ExpirableObjectType;
import com.jinqiu.zombieattack.model.GameModel;
import com.jinqiu.zombieattack.model.GameModelState;
import com.jinqiu.zombieattack.model.attached.Accelerate;
import com.jinqiu.zombieattack.model.attached.Position;
import com.jinqiu.zombieattack.model.entity.Entity;
import com.jinqiu.zombieattack.view.attached.ModelViewScreenTrans;
import com.jinqiu.zombieattack.view.component.Button;
import com.jinqiu.zombieattack.view.component.DoubleViewButton;
import com.jinqiu.zombieattack.view.component.DoubleViewIcon;
import com.jinqiu.zombieattack.view.component.NumberCounter;
import com.jinqiu.zombieattack.view.component.ProcessingBar;
import com.jinqiu.zombieattack.view.component.Texture;
import com.jinqiu.zombieattack.view.component.object.ViewExpirableObjectManager;

/** The game play screen for the game */
public class GamePlay extends Menu<GamePlay.ViewComponentTypes> {
	/** The game model */
	GameModel gameModel;
	/** The zombie number counter */
	private NumberCounter zombieNumCounter;
	/** The score counter */
	private NumberCounter scoreCounter;
	/** Motion sensor */
	private SensorManager sensorManager;
	/** The sensor listener */
	private SensorEventListenerImpl sensorEventListenerImpl;

	/**
	 * get the broadcast from the pause menu, go to the main menu, resume or
	 * restart
	 */
	private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
		@Override
		public void onReceive(Context context, Intent intent) {
			if (intent.getAction().equals("finishGamePlay")) {
				GamePlay.this.finish();
			} else if (intent.getAction().equals("resumeGame")) {
				gameModel.resumeGame();
			} else if (intent.getAction().equals("retryGame")) {
				startNewGame();
			} else if (intent.getAction().equals("moveToNextLevel")) {
				startNextLevel();
			}
		}
	};

	/** The view component in this game play screen */
	public static enum ViewComponentTypes {
		GAME_PLAY_BACKGROUND, GAME_PLAY_PAUSE_BUTTON, GAME_PLAY_MUSIC_BUTTON, GAME_PLAY_PROCESSING_BAR, GAME_PLAY_BOULDER_1, GAME_PLAY_BOULDER_2, GAME_PLAY_BOULDER_3, GAME_PLAY_SCIENTIST_1, GAME_PLAY_SCIENTIST_2, GAME_PLAY_SCIENTIST_3
	};

	@Override
	protected void onPause() {
		Log.d("on pause", "");
		gameModel.pauseGame();
		super.onPause();
	}

	@Override
	protected void onResume() {
		// register this class as a listener for the orientation and
		// accelerometer sensors
		Log.d("on resume", "");
		sensorEventListenerImpl = new SensorEventListenerImpl();
		sensorManager.registerListener(sensorEventListenerImpl,
				sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
				SensorManager.SENSOR_DELAY_NORMAL);

		IntentFilter intentFilter = new IntentFilter();
		intentFilter.addAction("finishGamePlay");
		intentFilter.addAction("resumeGame");
		intentFilter.addAction("retryGame");
		intentFilter.addAction("moveToNextLevel");
		registerReceiver(broadcastReceiver, intentFilter);

		super.onResume();

	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d("on create", "");

		// add buttons
		addViewComponent(ViewComponentTypes.GAME_PLAY_BACKGROUND, new Texture(
				R.drawable.game_play_background, new PointF(427, 240)));

		addViewComponent(ViewComponentTypes.GAME_PLAY_PAUSE_BUTTON, new Button(
				R.drawable.game_play_pause, R.drawable.game_play_pause_down,
				new PointF(26, 30)));

		addViewComponent(
				ViewComponentTypes.GAME_PLAY_MUSIC_BUTTON,
				new DoubleViewButton(R.drawable.game_play_music_on,
						R.drawable.game_play_music_on_down,
						R.drawable.game_play_music_off,
						R.drawable.game_play_music_off_down, new PointF(26, 84)));

		// add processing bar
		addViewComponent(ViewComponentTypes.GAME_PLAY_PROCESSING_BAR,
				new ProcessingBar(24, 480, new PointF(854, 480),
						R.drawable.game_play_processing_bar));

		// add zombie counter
		zombieNumCounter = new NumberCounter(new PointF(815, 60));
		getViewComponentManager().getViewComponentsWithoutKey().addAll(
				zombieNumCounter.getViewComponents());

		// add score counter
		scoreCounter = new NumberCounter(new PointF(815, 10));
		getViewComponentManager().getViewComponentsWithoutKey().addAll(
				scoreCounter.getViewComponents());

		// start the game
		startNewGame();

		// Motion sensor
		sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

		// keep screen on
//		getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

	}

	@Override
	protected void onStop() {
		Log.d("on stop", "");
		gameModel.endGame();

		unregisterReceiver(broadcastReceiver);
		sensorManager.unregisterListener(sensorEventListenerImpl);

		super.onStop();
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		Log.d("on touch", "");
		super.onTouchEvent(event);

		PointF touchPoint = new PointF(event.getX(), event.getY());

		PointF touchPointInModel = ModelViewScreenTrans
				.getScreenToModelTransformation().transform(touchPoint);
		if (0 < touchPointInModel.x
				&& touchPointInModel.x < GameModel.getGameFrameWidth()
				&& 0 < touchPointInModel.y
				&& touchPointInModel.y < GameModel.getGameFrameHeight()) {
			gameModel.addNewBoulder(new Position((int) touchPointInModel.x,
					(int) touchPointInModel.y));
		}

		if (viewComponentManager
				.getViewComponent(ViewComponentTypes.GAME_PLAY_PAUSE_BUTTON)
				.getViewRect().isInside(touchPoint)) {
			if (event.getAction() == MotionEvent.ACTION_DOWN) {
				((Button) viewComponentManager
						.getViewComponent(ViewComponentTypes.GAME_PLAY_PAUSE_BUTTON))
						.buttonDown();
			} else if (event.getAction() == MotionEvent.ACTION_UP) {
				Intent intent = new Intent();
				intent.setClass(GamePlay.this, PauseMenu.class);
				startActivity(intent);
				gameModel.pauseGame();
			}
		}

		if (viewComponentManager
				.getViewComponent(ViewComponentTypes.GAME_PLAY_MUSIC_BUTTON)
				.getViewRect().isInside(touchPoint)) {
			if (event.getAction() == MotionEvent.ACTION_DOWN) {
				((DoubleViewButton) viewComponentManager
						.getViewComponent(ViewComponentTypes.GAME_PLAY_MUSIC_BUTTON))
						.buttonDown();
			} else if (event.getAction() == MotionEvent.ACTION_UP) {
				((DoubleViewButton) viewComponentManager
						.getViewComponent(ViewComponentTypes.GAME_PLAY_MUSIC_BUTTON))
						.changeButton();
			}
		}

		if (event.getAction() == MotionEvent.ACTION_UP) {
			((Button) viewComponentManager
					.getViewComponent(ViewComponentTypes.GAME_PLAY_PAUSE_BUTTON))
					.buttonUp();

			((DoubleViewButton) viewComponentManager
					.getViewComponent(ViewComponentTypes.GAME_PLAY_MUSIC_BUTTON))
					.buttonUp();
		}
		viewComponentManager.invalidate();
		return true;
	}

	@Override
	protected void initializeViewComponentManager() {
		viewComponentManager = new ViewExpirableObjectManager<GamePlay.ViewComponentTypes>(
				this);
	}

	/** Start new game */
	private void startNewGame() {
		Log.d("game play screen", "Start a new game");
		gameModel = new GameModel();
		Log.d("Score", gameModel.getScore() + "");
		startNextLevel();
	}

	/** Start the next level */
	private void startNextLevel() {
		Log.d("game play screen", "Start a new Level");

		gameModel.startNextLevel();
		gameModel.pauseGame();
		((ViewExpirableObjectManager<ViewComponentTypes>) viewComponentManager)
				.initializeViewEntityManager(gameModel
						.getExpirableObjectManager());
		gameModel.addModelListener(new ModelListener() {
			@Override
			public void update(GameModelState gameModelState) {

				runOnUiThread(new Runnable() {

					@Override
					public void run() {
						((ProcessingBar) viewComponentManager
								.getViewComponent(ViewComponentTypes.GAME_PLAY_PROCESSING_BAR))
								.setPercentage(gameModel
										.getExpirableObjectManager()
										.getNumLeftZombie()
										/ (float) gameModel.getCurrentLevel()
												.getZombieNumberUpperBound());
						zombieNumCounter.updateNum(gameModel.getCurrentLevel()
								.getZombieNeedToKill()
								- gameModel.getExpirableObjectManager()
										.getNumDeadZombie());
						scoreCounter.updateNum(gameModel.getScore());
						viewComponentManager.invalidate();
					}
				});

				if (gameModelState == GameModelState.LOSE) {
					Intent intent = new Intent();
					intent.setClass(GamePlay.this, LoseMenu.class);
					startActivity(intent);
					gameModel.endGame();
				} else if (gameModelState == GameModelState.WIN_ONE_LEVEL) {
					Intent intent = new Intent();
					intent.setClass(GamePlay.this, WinMenu.class);
					startActivity(intent);
					gameModel.endGame();
				}
			}
		});

		// boulder icon
		List<Entity> boulderLeft = gameModel.getExpirableObjectManager()
				.getBouldersLeft();
		List<ViewComponentTypes> viewComponentTypes = new ArrayList<GamePlay.ViewComponentTypes>();
		viewComponentTypes.add(ViewComponentTypes.GAME_PLAY_BOULDER_1);
		viewComponentTypes.add(ViewComponentTypes.GAME_PLAY_BOULDER_2);
		viewComponentTypes.add(ViewComponentTypes.GAME_PLAY_BOULDER_3);

		for (int i = 0; i < 3; i++) {
			int turnOnID = R.drawable.icon_standard_boulder;
			int turnOffID = R.drawable.icon_boulder_used;
			if (boulderLeft.get(i).isExpirableObjectType(
					ExpirableObjectType.EtherealBoulder)) {
				turnOnID = R.drawable.icon_ethereal_boulder;
			} else if (boulderLeft.get(i).isExpirableObjectType(
					ExpirableObjectType.FireBoulder)) {
				turnOnID = R.drawable.icon_fire_boulder;
			} else if (boulderLeft.get(i).isExpirableObjectType(
					ExpirableObjectType.IceBoulder)) {
				turnOnID = R.drawable.icon_ice_boulder;
			} else if (boulderLeft.get(i).isExpirableObjectType(
					ExpirableObjectType.HoverBoulder)) {
				turnOnID = R.drawable.icon_hover_boulder;
			} else if (boulderLeft.get(i).isExpirableObjectType(
					ExpirableObjectType.FireBoulder)) {
				turnOnID = R.drawable.icon_fire_boulder;
			}

			removeViewComponent(viewComponentTypes.get(i));

			addViewComponent(viewComponentTypes.get(i), new DoubleViewIcon(
					turnOnID, turnOffID, new PointF(26, 138 + (48 + 6) * i),
					boulderLeft.get(i)));
		}

		// scientist icon
		List<Entity> scientistLeft = gameModel.getExpirableObjectManager()
				.getEntityList(ExpirableObjectType.Scientist);
		viewComponentTypes.clear();
		viewComponentTypes.add(ViewComponentTypes.GAME_PLAY_SCIENTIST_1);
		viewComponentTypes.add(ViewComponentTypes.GAME_PLAY_SCIENTIST_2);
		viewComponentTypes.add(ViewComponentTypes.GAME_PLAY_SCIENTIST_3);

		for (int i = 0; i < 3; i++) {
			int turnOnID = R.drawable.icon_standard_scientist;
			int turnOffID = R.drawable.icon_standard_scientist_dead;
			if (scientistLeft.get(i).isExpirableObjectType(
					ExpirableObjectType.Tesla)) {
				turnOnID = R.drawable.icon_tesla;
				turnOffID = R.drawable.icon_tesla_dead;
			}

			removeViewComponent(viewComponentTypes.get(i));

			addViewComponent(viewComponentTypes.get(i), new DoubleViewIcon(
					turnOnID, turnOffID, new PointF(26, 306 + (60 + 6) * i),
					scientistLeft.get(i)));
		}

		gameModel.resumeGame();
	}

	/** Implement the sensor listener */
	private class SensorEventListenerImpl implements SensorEventListener {

		/** How to rate from the gravity to the accelerate */
		private static final float RATE = 2;

		@Override
		public void onAccuracyChanged(Sensor sensor, int accuracy) {
		}

		@Override
		public void onSensorChanged(SensorEvent event) {
			if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
				gameModel.changeAccelerate(new Accelerate(event.values[1]
						* RATE, event.values[0] * RATE));
			}
		}
	}

	@Override
	public void onAttachedToWindow() {

//		this.getWindow().setType(WindowManager.LayoutParams.TYPE_KEYGUARD);
		super.onAttachedToWindow();
	}

}
