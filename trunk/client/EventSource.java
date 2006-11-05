package com.gtraffic.gwt.simile.timeline.client;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * EventSource
 *
 * @author ajr
 */
public class EventSource extends JavaScriptObject
{
    protected EventSource(int opaque)
    {
        super(opaque);
    }

    public static EventSource create()
    {
        return EventSourceImpl.createEventSourceObject();
    }
    
    /**
     * Load data stream into timeline event source
     * @param dataUrl
     */
    public void load(String dataUrl)
    {
        EventSourceImpl.loadXML(dataUrl, this);
    }
    

    public void clear()
    {
        EventSourceImpl.clear(this);
    }
    
}
