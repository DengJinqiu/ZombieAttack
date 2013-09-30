package com.jinqiu.zombieattack.view.activities;

import android.content.Intent;
import android.graphics.PointF;
import android.os.Bundle;
import android.view.MotionEvent;

import com.jinqiu.zombieattack.view.component.Button;
import com.jinqiu.zombieattack.view.component.DoubleViewButton;
import com.jinqiu.zombieattack.view.component.Texture;

/** The main menu of the project */
public class MainMenu extends Menu<MainMenu.ViewComponentTypes> {
	/** The view component type */
	public static enum ViewComponentTypes {
		MAIN_MENU_TUTORIAL_BUTTON, MAIN_MENU_PLAY_BUTTON, MAIN_MENU_INFO_BUTTON, MAIN_MENU_MUSIC_BUTTON, MAIN_MENU_HIGH_SCORES_BUTTON, MAIN_MENU_BACKGROUND
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		addViewComponent(ViewComponentTypes.MAIN_MENU_BACKGROUND, new Texture(
				R.drawable.main_menu_background, new PointF(427, 240)));

		addViewComponent(ViewComponentTypes.MAIN_MENU_PLAY_BUTTON, new Button(
				R.drawable.main_menu_play_button,
				R.drawable.main_menu_play_button_down, new PointF(427, 387)));

		addViewComponent(ViewComponentTypes.MAIN_MENU_HIGH_SCORES_BUTTON,
				new Button(R.drawable.main_menu_high_scores_button,
						R.drawable.main_menu_high_scores_button_down,
						new PointF(804, 48)));

		addViewComponent(ViewComponentTypes.MAIN_MENU_INFO_BUTTON, new Button(
				R.drawable.main_menu_info_button,
				R.drawable.main_menu_info_button_down, new PointF(804, 430)));

		addViewComponent(ViewComponentTypes.MAIN_MENU_TUTORIAL_BUTTON,
				new Button(R.drawable.main_menu_tutorial_button,
						R.drawable.main_menu_tutorial_button_down, new PointF(
								48, 430)));

		addViewComponent(ViewComponentTypes.MAIN_MENU_MUSIC_BUTTON,
				new DoubleViewButton(R.drawable.main_menu_music_on_button,
						R.drawable.main_menu_music_on_button_down,
						R.drawable.main_menu_music_off_button,
						R.drawable.main_menu_music_off_button_down, new PointF(
								48, 48)));
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		super.onTouchEvent(event);

		PointF touchPoint = new PointF(event.getX(), event.getY());

		if (viewComponentManager
				.getViewComponent(ViewComponentTypes.MAIN_MENU_PLAY_BUTTON)
				.getViewRect().isInside(touchPoint)) {
			if (event.getAction() == MotionEvent.ACTION_DOWN) {
				((Button) viewComponentManager
						.getViewComponent(ViewComponentTypes.MAIN_MENU_PLAY_BUTTON))
						.buttonDown();
			} else if (event.getAction() == MotionEvent.ACTION_UP) {
				Intent intent = new Intent();
				intent.setClass(MainMenu.this, GamePlay.class);
				startActivity(intent);
			}
		}

		if (viewComponentManager
				.getViewComponent(ViewComponentTypes.MAIN_MENU_TUTORIAL_BUTTON)
				.getViewRect().isInside(touchPoint)) {
			if (event.getAction() == MotionEvent.ACTION_DOWN) {
				((Button) viewComponentManager
						.getViewComponent(ViewComponentTypes.MAIN_MENU_TUTORIAL_BUTTON))
						.buttonDown();
			} else if (event.getAction() == MotionEvent.ACTION_UP) {
				Intent intent = new Intent();
				intent.setClass(MainMenu.this, TutorialMenu.class);
				startActivity(intent);
			}
		}

		if (viewComponentManager
				.getViewComponent(ViewComponentTypes.MAIN_MENU_INFO_BUTTON)
				.getViewRect().isInside(touchPoint)) {
			if (event.getAction() == MotionEvent.ACTION_DOWN) {
				((Button) viewComponentManager
						.getViewComponent(ViewComponentTypes.MAIN_MENU_INFO_BUTTON))
						.buttonDown();
			} else if (event.getAction() == MotionEvent.ACTION_UP) {
				Intent intent = new Intent();
				intent.setClass(MainMenu.this, CreditMenu.class);
				startActivity(intent);
			}
		}

		if (viewComponentManager
				.getViewComponent(
						ViewComponentTypes.MAIN_MENU_HIGH_SCORES_BUTTON)
				.getViewRect().isInside(touchPoint)) {
			if (event.getAction() == MotionEvent.ACTION_DOWN) {
				((Button) viewComponentManager
						.getViewComponent(ViewComponentTypes.MAIN_MENU_HIGH_SCORES_BUTTON))
						.buttonDown();
			} else if (event.getAction() == MotionEvent.ACTION_UP) {
				Intent intent = new Intent();
				intent.setClass(MainMenu.this, HighScoresMenu.class);
				startActivity(intent);
			}
		}

		if (viewComponentManager
				.getViewComponent(ViewComponentTypes.MAIN_MENU_MUSIC_BUTTON)
				.getViewRect().isInside(touchPoint)) {
			if (event.getAction() == MotionEvent.ACTION_DOWN) {
				((DoubleViewButton) viewComponentManager
						.getViewComponent(ViewComponentTypes.MAIN_MENU_MUSIC_BUTTON))
						.buttonDown();
			} else if (event.getAction() == MotionEvent.ACTION_UP) {
				((DoubleViewButton) viewComponentManager
						.getViewComponent(ViewComponentTypes.MAIN_MENU_MUSIC_BUTTON))
						.changeButton();
			}
		}

		if (event.getAction() == MotionEvent.ACTION_UP) {
			((Button) viewComponentManager
					.getViewComponent(ViewComponentTypes.MAIN_MENU_HIGH_SCORES_BUTTON))
					.buttonUp();
			((Button) viewComponentManager
					.getViewComponent(ViewComponentTypes.MAIN_MENU_INFO_BUTTON))
					.buttonUp();
			((Button) viewComponentManager
					.getViewComponent(ViewComponentTypes.MAIN_MENU_PLAY_BUTTON))
					.buttonUp();
			((Button) viewComponentManager
					.getViewComponent(ViewComponentTypes.MAIN_MENU_TUTORIAL_BUTTON))
					.buttonUp();
			((DoubleViewButton) viewComponentManager
					.getViewComponent(ViewComponentTypes.MAIN_MENU_MUSIC_BUTTON))
					.buttonUp();
		}
		viewComponentManager.invalidate();
		return true;
	}

	@Override
	public void onBackPressed() {
		super.onBackPressed();
		this.finish();
		System.exit(0);
	}

}
