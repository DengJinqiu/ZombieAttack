package com.jinqiu.zombieattack.view.component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

/** The view component on the game menu: the backgrounds and buttons */
public class ViewComponentManager<K> extends View {
	/** The view component which has the key */
	private Map<K, ViewComponent> viewComponentsWithKey = new LinkedHashMap<K, ViewComponent>();

	/** The view component which does not have the key */
	private List<ViewComponent> viewComponentsWithoutKey = new ArrayList<ViewComponent>();

	public ViewComponentManager(Context context) {
		super(context);
	}

	/**
	 * Get the view component by the key
	 * 
	 * @param key
	 *            The given key
	 * @return The corresponding view component
	 */
	public ViewComponent getViewComponent(K key) {
		return this.viewComponentsWithKey.get(key);
	}

	/**
	 * Get the view components with key
	 * 
	 * @return The view components
	 */
	public Map<K, ViewComponent> getViewComponentsWithKey() {
		return viewComponentsWithKey;
	}

	/**
	 * Get the view components without key
	 * 
	 * @return The view components
	 */
	public List<ViewComponent> getViewComponentsWithoutKey() {
		return viewComponentsWithoutKey;
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		Iterator<ViewComponent> iterator = viewComponentsWithKey.values()
				.iterator();
		while (iterator.hasNext()) {
			iterator.next().draw(canvas);
		}
		for (ViewComponent viewComponent : viewComponentsWithoutKey) {
			viewComponent.draw(canvas);
		}
	}

}
