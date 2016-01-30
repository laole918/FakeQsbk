package com.laole918.fakeqsbk.utils;

import de.greenrobot.event.EventBus;

public class EventBusUtils {
	
	private static boolean isRegistered(Object subscriber) {
		return EventBus.getDefault().isRegistered(subscriber);
	}
	
	public static void register(Object subscriber) {
		if(!isRegistered(subscriber)) {
			EventBus.getDefault().register(subscriber);
		}
	}
	
	public static void register(Object subscriber, int priority) {
		if(!isRegistered(subscriber)) {
			EventBus.getDefault().register(subscriber, priority);
		}
	}
	
	public static void registerSticky(Object subscriber) {
		if(!isRegistered(subscriber)) {
			EventBus.getDefault().registerSticky(subscriber);
		}
	}
	
	public static void unregister(Object subscriber) {
		EventBus.getDefault().unregister(subscriber);
	}
	
	public static void post(Object event) {
		EventBus.getDefault().post(event);
	}
	
	public static void postSticky(Object event) {
		EventBus.getDefault().postSticky(event);
	}
	
	public static <T> T getStickyEvent(Class<T> eventType) {
		return EventBus.getDefault().getStickyEvent(eventType);
	}
	
	public static boolean removeStickyEvent(Object event) {
		return EventBus.getDefault().removeStickyEvent(event);
	}
	
}
