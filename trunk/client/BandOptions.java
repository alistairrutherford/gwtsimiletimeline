package com.gtraffic.gwt.simile.timeline.client;

import com.google.gwt.core.client.JavaScriptObject;


/**
 * BandOptions
 *
 * @author ajr
 */
public class BandOptions extends JavaScriptObject
{
    protected BandOptions(int opaque)
    {
        super(opaque);
    }

    public static BandOptions create()
    {
        return BandOptionsImpl.create();
    }

    /**
     * how much of the timeline's space this band takes up, expressed as a percent in a string, e.g., "30%"
     *
     */
    public String getWidth()
    {
        return JavaScriptObjectHelper.getAttribute(this, "width");
    }

    /**
     * required, how much of the timeline's space this band takes up, expressed as a percent in a string, e.g., "30%"
     */
    public void setWidth(String width)
    {
        JavaScriptObjectHelper.setAttribute(this, "width", width);
    }

    /**
     * a time unit from Timeline.DateTime, e.g., Timeline.DateTime.WEEK.
     *
     */
    public int getIntervalUnit()
    {
        return JavaScriptObjectHelper.getAttributeAsInt(this, "intervalUnit");
    }

    /**
     * required, a time unit from Timeline.DateTime, e.g., Timeline.DateTime.WEEK.
     */
    public void setIntervalUnit(int value)
    {
        JavaScriptObjectHelper.setAttribute(this, "intervalUnit", value);
    }

    /**
     * the number of pixels that the time unit above is mapped to, e.g., 100.
     *
     */
    public int getIntervalPixels()
    {
        return JavaScriptObjectHelper.getAttributeAsInt(this, "intervalPixels");
    }

    /**
     * required, the number of pixels that the time unit above is mapped to, e.g., 100.
     */
    public void setIntervalPixels(int value)
    {
        JavaScriptObjectHelper.setAttribute(this, "intervalPixels", value);
    }

    /**
     * a boolean specifying whether event titles are to be painted. The default is true. 
     *
     */
    public boolean getShowEventText()
    {
        return JavaScriptObjectHelper.getAttributeAsBoolean(this, "showEventText");
    }

    /**
     * optional, a boolean specifying whether event titles are to be painted. The default is true.
     */
    public void setShowEventText(boolean value)
    {
        JavaScriptObjectHelper.setAttribute(this, "showEventText", value);
    }
    
    /**
     * the number of em  (dependent on the current font) to be left between adjacent
     * tracks on which events are painted. The default value is retrieved from the provided or 
     * default theme. E.g., 0.5.
     *
     */
    public float getTrackGap()
    {
        return JavaScriptObjectHelper.getAttributeAsFloat(this, "trackGap");
    }

    /**
     * optional, the number of em  (dependent on the current font) to be left between adjacent
     * tracks on which events are painted. The default value is retrieved from the provided or 
     * default theme. E.g., 0.5.
     */
    public void setTrackGap(float value)
    {
        JavaScriptObjectHelper.setAttribute(this, "trackGap", value);
    }

    /**
     * the height of each track in em  (dependent on the current font). 
     * The default value is retrieved from the provided or default theme. E.g., 1.5.
     *
     */
    public float getTrackHeight()
    {
        return JavaScriptObjectHelper.getAttributeAsFloat(this, "trackHeight");
    }

    /**
     * optional, the height of each track in em  (dependent on the current font). 
     * The default value is retrieved from the provided or default theme. E.g., 1.5.
     */
    public void setTrackHeight(float value)
    {
        JavaScriptObjectHelper.setAttribute(this, "trackHeight", value);
    }

    /**
     * required, Band theme
     */
    public void setTheme(Theme value)
    {
        JavaScriptObjectHelper.setAttribute(this, "theme", value);
    }

    /**
     * Band theme
     */
    public JavaScriptObject getTheme()
    {
        return JavaScriptObjectHelper.getAttributeAsJavaScriptObject(this, "theme");
    }

    /**
     * required, Event source
     */
    public void setEventSource(EventSource value)
    {
        JavaScriptObjectHelper.setAttribute(this, "eventSource", value);
    }

    /**
     * Event source
     */
    public JavaScriptObject getEventSource()
    {
        return JavaScriptObjectHelper.getAttributeAsJavaScriptObject(this, "eventSource");
    }
    
}
