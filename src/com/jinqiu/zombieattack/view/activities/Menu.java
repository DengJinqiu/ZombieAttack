package com.jinqiu.zombieattack.view.activities;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;

import com.jinqiu.zombieattack.view.attached.BitmapManager;
import com.jinqiu.zombieattack.view.attached.ModelViewScreenTrans;
import com.jinqiu.zombieattack.view.component.ViewComponent;
import com.jinqiu.zombieattack.view.component.ViewComponentManager;

/** The basic menu */
public abstract class Menu<K> extends Activity {
	protected ViewComponentManager<K> viewComponentManager;

	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		Log.d("on menu create", "start");
		// lock the screen
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

		Display display = getWindowManager().getDefaultDisplay();

		// deprecation with API 13
		ModelViewScreenTrans
				.initialize(display.getWidth(), display.getHeight());

		BitmapManager.setResources(getResources());

		FrameLayout.LayoutParams p = new FrameLayout.LayoutParams(
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

		initializeViewComponentManager();
		this.addContentView(viewComponentManager, p);
//		Log.d("on menu create", "end");
	}

	/** Initialize view component manager */
	protected void initializeViewComponentManager() {
		viewComponentManager = new ViewComponentManager<K>(this);
	}

	/** Add view component */
	public void addViewComponent(K key, ViewComponent viewComponent) {
		viewComponentManager.getViewComponentsWithKey().put(key, viewComponent);
	}

	/** Remove vew component */
	public void removeViewComponent(K key) {
		viewComponentManager.getViewComponentsWithKey().remove(key);
	}

	/**
	 * Get the view component manager
	 * 
	 * @return The view component manager
	 */
	public ViewComponentManager<K> getViewComponentManager() {
		return viewComponentManager;
	}

}
