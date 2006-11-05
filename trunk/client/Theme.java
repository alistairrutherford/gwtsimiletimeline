package com.gtraffic.gwt.simile.timeline.client;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Theme, currently only creates the classic theme.
 *
 * @author ajr
 */
public class Theme extends JavaScriptObject
{
    protected Theme(int opaque)
    {
        super(opaque);
    }
    
    public static Theme create()
    {
        return ThemeImpl.create();
    }

    public void setEventLabelWidth(int width)
    {
        ThemeImpl.setEventLabelWidth(this, width);
    }
        
    
}
