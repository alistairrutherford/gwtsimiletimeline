/*
 * Copyright 2006 Alistair Rutherford (http://code.google.com/p/gwtsimiletimeline/)
 * 
 * JSON handling contributed jdwyah, Feb 26, 2007.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.netthreads.gwt.simile.timeline.client;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * EventSourceImpl
 * 
 * @author ajr
 *
 */
class EventSourceImpl
{
    // -------------------------------------------------------------------
    // EventSource
    // -------------------------------------------------------------------
    
    public native static EventSource createEventSourceObject() /*-{
        var source = new $wnd.Timeline.DefaultEventSource();
        return source;
    }-*/;

    public native static void clear(EventSource source) /*-{
        source.clear();
    }-*/;

    public native static void loadXML(JavaScriptObject xml, String url, EventSource source) /*-{
    	source.loadXML(xml, url);
    }-*/;

    public native static void loadXMLText(String xml, String url, EventSource source) /*-{
		var xmlDoc = $wnd.TimelineHelper.parseXML(xml);
		
		source.loadXML(xmlDoc, url);
	}-*/;
    
    public native static void loadXML(String dataUrl, EventSource eventSource) /*-{
        $wnd.Timeline.loadXML(dataUrl, function(xml, url) { eventSource.loadXML(xml, url); });
    }-*/;

    public native static void loadJSON(String jsonString,String url,EventSource eventSource)/*-{
		var jsonData = eval('(' + jsonString + ')');
		eventSource.loadJSON(jsonData, url);	
	}-*/;
    
}
