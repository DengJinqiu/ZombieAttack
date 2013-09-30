package com.jinqiu.zombieattack.view.component.object;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Context;
import android.graphics.Canvas;

import com.jinqiu.zombieattack.listener.ExpirableObjectManagerListener;
import com.jinqiu.zombieattack.model.ExpirableObject;
import com.jinqiu.zombieattack.model.ExpirableObjectManager;
import com.jinqiu.zombieattack.model.ExpirableObjectType;
import com.jinqiu.zombieattack.model.entity.Entity;
import com.jinqiu.zombieattack.view.component.ViewComponentManager;
import com.jinqiu.zombieattack.view.factory.ViewBarrierLargeHorizontalFactory;
import com.jinqiu.zombieattack.view.factory.ViewBarrierLargeVerticalFactory;
import com.jinqiu.zombieattack.view.factory.ViewBarrierSmallHorizontalFactory;
import com.jinqiu.zombieattack.view.factory.ViewBarrierSmallVerticalFactory;
import com.jinqiu.zombieattack.view.factory.ViewBoulderEtherealFactory;
import com.jinqiu.zombieattack.view.factory.ViewBoulderFireFactory;
import com.jinqiu.zombieattack.view.factory.ViewBoulderHoverFactory;
import com.jinqiu.zombieattack.view.factory.ViewBoulderIceFactory;
import com.jinqiu.zombieattack.view.factory.ViewBoulderNormalFactory;
import com.jinqiu.zombieattack.view.factory.ViewEffectFireFactory;
import com.jinqiu.zombieattack.view.factory.ViewEffectIceSmallFactory;
import com.jinqiu.zombieattack.view.factory.ViewExpirableObjectFactory;
import com.jinqiu.zombieattack.view.factory.ViewGooFactory;
import com.jinqiu.zombieattack.view.factory.ViewScientistNormalFactory;
import com.jinqiu.zombieattack.view.factory.ViewScientistTeslaFactory;
import com.jinqiu.zombieattack.view.factory.ViewScreenBoundFactory;
import com.jinqiu.zombieattack.view.factory.ViewZombieCurseFactory;
import com.jinqiu.zombieattack.view.factory.ViewZombieFastFactory;
import com.jinqiu.zombieattack.view.factory.ViewZombieGiantFactory;
import com.jinqiu.zombieattack.view.factory.ViewZombieKillerFactory;
import com.jinqiu.zombieattack.view.factory.ViewZombieLeaderFactory;
import com.jinqiu.zombieattack.view.factory.ViewZombieNormalFactory;
import com.jinqiu.zombieattack.view.factory.ViewZombieSmartFactory;
import com.jinqiu.zombieattack.view.factory.ViewZombieStrongerFactory;

/** Manager the view expirable object */
public class ViewExpirableObjectManager<K> extends ViewComponentManager<K> {
	/** The map between expirable object type and view expirable object factory */
	private static final Map<ExpirableObjectType, ViewExpirableObjectFactory> viewFactoryMap = new HashMap<ExpirableObjectType, ViewExpirableObjectFactory>() {

		private static final long serialVersionUID = 6757071394855971761L;

		{
			put(ExpirableObjectType.BarrierLargeHorizontal,
					new ViewBarrierLargeHorizontalFactory());
			put(ExpirableObjectType.BarrierLargeVertical,
					new ViewBarrierLargeVerticalFactory());
			put(ExpirableObjectType.BarrierSmallHorizontal,
					new ViewBarrierSmallHorizontalFactory());
			put(ExpirableObjectType.BarrierSmallVertical,
					new ViewBarrierSmallVerticalFactory());
			put(ExpirableObjectType.Goo, new ViewGooFactory());
			put(ExpirableObjectType.NormalBoulder,
					new ViewBoulderNormalFactory());
			put(ExpirableObjectType.IceBoulder, new ViewBoulderIceFactory());
			put(ExpirableObjectType.FireBoulder, new ViewBoulderFireFactory());
			put(ExpirableObjectType.HoverBoulder, new ViewBoulderHoverFactory());
			put(ExpirableObjectType.EtherealBoulder,
					new ViewBoulderEtherealFactory());
			put(ExpirableObjectType.NormalScientist,
					new ViewScientistNormalFactory());
			put(ExpirableObjectType.Tesla, new ViewScientistTeslaFactory());
			put(ExpirableObjectType.NormalZombie, new ViewZombieNormalFactory());
			put(ExpirableObjectType.StrongerZombie,
					new ViewZombieStrongerFactory());
			put(ExpirableObjectType.FastZombie, new ViewZombieFastFactory());
			put(ExpirableObjectType.SmartZombie, new ViewZombieSmartFactory());
			put(ExpirableObjectType.LeaderZombie, new ViewZombieLeaderFactory());
			put(ExpirableObjectType.GiantZombie, new ViewZombieGiantFactory());
			put(ExpirableObjectType.CurseZombie, new ViewZombieCurseFactory());
			put(ExpirableObjectType.KillerZombie, new ViewZombieKillerFactory());
			put(ExpirableObjectType.iceBoulderToZombieEffect,
					new ViewEffectIceSmallFactory());
			put(ExpirableObjectType.fireBoulderToZombieEffect,
					new ViewEffectFireFactory());
			put(ExpirableObjectType.ScreenBound, new ViewScreenBoundFactory());
		}
	};

	/** All the view expirable object */
	private List<ViewExpirableObject> viewExpirableObjects;

	public ViewExpirableObjectManager(Context context) {
		super(context);
	}

	/**
	 * Add view object
	 * 
	 * @param expirableObject
	 *            The expirable object
	 */
	public void addViewObject(ExpirableObject expirableObject) {
		int index = 0;
		if (expirableObject.isExpirableObjectType(ExpirableObjectType.Goo)) {
			index = 0;
		} else if (!expirableObject
				.isExpirableObjectType(ExpirableObjectType.Boulder)) {
			index = Math.max(index, viewExpirableObjects.size());
		} else {
			index = viewExpirableObjects.size();
		}
		viewExpirableObjects.add(
				index,
				viewFactoryMap.get(
						expirableObject.getDetailExpirableObjectType())
						.getViewExpirableObject(expirableObject));
	}

	/**
	 * Initialize the view entity
	 * 
	 * @param expirableObjectManager
	 *            The expirable object manager
	 */
	public void initializeViewEntityManager(
			ExpirableObjectManager expirableObjectManager) {
		viewExpirableObjects = new ArrayList<ViewExpirableObject>();

		List<Entity> entities = expirableObjectManager
				.getEntityList(ExpirableObjectType.All);
		for (Entity entity : entities) {
			addViewObject(entity);
		}

		expirableObjectManager
				.addExpirableObjectManagerListeners(new ExpirableObjectManagerListener() {

					@Override
					public void cleanDeadViewObject() {
						for (int i = 0; i < viewExpirableObjects.size(); i++) {
							if (viewExpirableObjects.get(i).isShouldBeRemoved()) {
								viewExpirableObjects.remove(i);
							}
						}
					}

					@Override
					public void addViewExpirableObject(
							ExpirableObject expirableObject) {
						ViewExpirableObjectManager.this
								.addViewObject(expirableObject);
					}

				});
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		for (int i = 0; i < viewExpirableObjects.size(); i++) {
			viewExpirableObjects.get(i).draw(canvas);
		}
	}

}
