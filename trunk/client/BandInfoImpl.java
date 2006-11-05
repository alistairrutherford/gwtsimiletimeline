package com.gtraffic.gwt.simile.timeline.client;


class BandInfoImpl
{
    // -------------------------------------------------------------------
    // Band
    // -------------------------------------------------------------------

    public native static BandInfo create(BandOptions options) /*-{
        return $wnd.Timeline.createBandInfo(options)
    }-*/;
    
    public native static void closeBubble(BandInfo band) /*-{
        band.closeBubble();
    }-*/;
    
    public native static void setSyncWith(BandInfo band, int index) /*-{
        band.syncWith = index;
    }-*/;
    
    public native static void setHighlight(BandInfo band, boolean value) /*-{
        band.highlight = value;
    }-*/;
    
}