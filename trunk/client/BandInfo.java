package com.gtraffic.gwt.simile.timeline.client;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Band
 *
 * @author ajr
 */
public class BandInfo extends JavaScriptObject
{
    protected BandInfo(int opaque)
    {
        super(opaque);
    }
    
    public static BandInfo create(BandOptions options)
    {
        return BandInfoImpl.create(options);
    }
    
    public void closeBubble()
    {
        BandInfoImpl.closeBubble(this);
    }
    
    public void setSyncWith(int value)
    {
        BandInfoImpl.setSyncWith(this, value);
    }

    public void setHighlight(boolean value)
    {
        BandInfoImpl.setHighlight(this, value);
    }
    
}
