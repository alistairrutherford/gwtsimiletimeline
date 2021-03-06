/**
 * Created by: Billy Wagner
 * Sep 17, 2008
 */
package com.netthreads.gwt.simile.timeline.client;

/**
 * @author Billy Wagner
 *
 * Implementation of the Event javascript object functions
 * 
 * Note there are still more functions that can be used here- accessors and such
 */
public class EventImpl {

	public native static Event createEvent(String start, String end, String latestStart,String earliestEnd,boolean isInstance,
						String text,String description, String image, String link,String icon, String color, String textColor)/*-{
						
						var event=new $wnd.Timeline.DefaultEventSource.Event(start, end, latestStart, earliestEnd, isInstance, text,
																	description, image, link, icon, color, textColor);
						return event;
						}-*/;
																
				
}
