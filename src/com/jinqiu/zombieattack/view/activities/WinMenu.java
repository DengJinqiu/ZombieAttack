package com.jinqiu.zombieattack.view.activities;

import java.util.Timer;
import java.util.TimerTask;

import android.content.Intent;
import android.graphics.PointF;
import android.os.Bundle;

import com.jinqiu.zombieattack.view.component.Texture;

/** The win menu */
public class WinMenu extends Menu<WinMenu.ViewComponentTypes> {
	/** The view component type */
	public static enum ViewComponentTypes {
		BASIC_BACKGROUND, LOSE_MENU_BACKGROUND
	};

	/** The timer to stop the menu */
	Timer timer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		addViewComponent(ViewComponentTypes.LOSE_MENU_BACKGROUND, new Texture(
				R.drawable.win_menu_background, new PointF(427, 240)));

		timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				sendBroadcast(new Intent("moveToNextLevel"));

				Intent intent = new Intent();
				intent.setClass(WinMenu.this, GamePlay.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
				startActivity(intent);
				finish();
			}
		}, 2000);
	}

}
