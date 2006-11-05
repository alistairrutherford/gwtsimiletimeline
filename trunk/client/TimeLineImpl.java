package com.gtraffic.gwt.simile.timeline.client;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;

class TimeLineImpl
{
    // -------------------------------------------------------------------
    // Timeline
    // -------------------------------------------------------------------

    public native static TimeLine create(JavaScriptObject bands, Element divElement) /*-{
        return $wnd.Timeline.create(divElement, bands);
    }-*/;
    
    public native static int getBandCount(TimeLine timeLine) /*-{
        return timeLine.getBandCount();
    }-*/;
    
    public native static void layout(TimeLine timeLine) /*-{
        try
        {
            timeLine.layout();
        }
        catch (e)
        {
            alert(e.name + "," + e.message);
        }
    }-*/;

    public native static void paint(TimeLine timeLine) /*-{
        timeLine.paint();
    }-*/;

    public native static void clearBubbles(TimeLine timeLine) /*-{
        var count = timeLine.getBandCount();
        for (var i=0; i<count; i++)
        {
            timeLine.getBand(i).closeBubble();
        }
    }-*/;
    
}
