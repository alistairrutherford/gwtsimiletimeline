package com.gtraffic.gwt.simile.timeline.client;

import com.google.gwt.core.client.JavaScriptObject;


/**
 * Implement this interface to receive Timeline XML completion events.
 * 
 */
public interface TimelineXMLHandler
{
    /**
     * Called when an asynchronous HTTP request completes successfully.
     *
     * @param responseText the text returned from the server
     * @param url
     */
    void onCompletion(JavaScriptObject xml, String url);
}
