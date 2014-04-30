package com.re.eventbus;

import com.googlecode.androidannotations.annotations.EBean;
import com.googlecode.androidannotations.api.Scope;

import de.greenrobot.event.EventBus;

@EBean(scope = Scope.Singleton)
public class MyEventBus {
	
	private static EventBus eventBus = new EventBus();
	
	public static EventBus getEventBus() {
		return eventBus;
	}

	public void setEventBus(EventBus eventBus) {
		MyEventBus.eventBus = eventBus;
	}
	
	// fire event
	//getEventBus().post(new SomeEvent(params...));
	
	// recieve event
	//public void onEvent(SomeEvent event){
	//   do stuff...
	//}

}
