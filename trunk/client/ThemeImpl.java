package com.gtraffic.gwt.simile.timeline.client;

class ThemeImpl
{
    // -------------------------------------------------------------------
    // Theme
    // -------------------------------------------------------------------
    
    public native static Theme create() /*-{
        var theme = $wnd.Timeline.ClassicTheme.create();
        theme.event.label.width = 400; // default px 
        return theme;
    }-*/;

    public native static void setEventLabelWidth(Theme theme, int width) /*-{
        theme.event.label.width = width; // px 
    }-*/;
    
}
