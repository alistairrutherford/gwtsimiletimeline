package com.gtraffic.gwt.simile.timeline.client;

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

    public native static void loadXML(String dataUrl, EventSource eventSource) /*-{
        $wnd.Timeline.loadXML(dataUrl, function(xml, url) { eventSource.loadXML(xml, url); });
    }-*/;
    
}
