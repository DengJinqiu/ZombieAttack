package com.jinqiu.zombieattack.view.factory;

import com.jinqiu.zombieattack.model.ExpirableObject;
import com.jinqiu.zombieattack.view.component.object.ViewExpirableObject;

public interface ViewExpirableObjectFactory {
	public ViewExpirableObject getViewExpirableObject(ExpirableObject expirableObject);
}
