package com.gtraffic.gwt.simile.timeline.client;

/**
 * DateTimeImpl returns actual values from javascript.
 * 
 * @author ajr
 *
 */
class DateTimeImpl
{
    public native static int MILLISECOND()/*-{
        return $wnd.Timeline.DateTime.MILLISECOND;
    }-*/;

    public native static int SECOND()/*-{
    return $wnd.Timeline.DateTime.SECOND;
    }-*/;
    
    public native static int MINUTE()/*-{
    return $wnd.Timeline.DateTime.MINUTE;
    }-*/;
    
    public native static int HOUR()/*-{
    return $wnd.Timeline.DateTime.HOUR;
    }-*/;

    public native static int DAY()/*-{
    return $wnd.Timeline.DateTime.DAY;
    }-*/;

    public native static int WEEK()/*-{
    return $wnd.Timeline.DateTime.WEEK;
    }-*/;
    
    public native static int MONTH()/*-{
    return $wnd.Timeline.DateTime.MONTH;
    }-*/;
    
    public native static int YEAR()/*-{
    return $wnd.Timeline.DateTime.YEAR;
    }-*/;
    
    public native static int DECADE()/*-{
    return $wnd.Timeline.DateTime.DECADE;
    }-*/;
    
    public native static int CENTURY()/*-{
    return $wnd.Timeline.DateTime.CENTURY;
    }-*/;
    
    public native static int MILLENNIUM()/*-{
    return $wnd.Timeline.DateTime.MILLENNIUM;
    }-*/;

    public native static int EPOCH()/*-{
    return $wnd.Timeline.DateTime.EPOCH;
    }-*/;

    public native static int ERA()/*-{
    return $wnd.Timeline.DateTime.ERA;
    }-*/;
    
}
