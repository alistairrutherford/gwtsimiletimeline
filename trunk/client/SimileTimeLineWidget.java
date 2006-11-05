package com.gtraffic.gwt.simile.timeline.client;

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.Widget;


/**
 * The SIMILE widget
 * <br/>Example:
 * <br/>SimileWidget simWidget = new SimileWidget(e);
 * <br/>
 * <br/>access the Simile object by:
 * <br/>Simile sim = simWidget.getSimile();
 * @author ajr
 *
 */
public class SimileTimeLineWidget extends Widget
{
    public SimileTimeLine source = null;
    private Element el = null;

    public SimileTimeLineWidget(String height, String width)
    {
        el = DOM.createDiv();
        setElement(el);
        setHeight(height);
        setWidth(width);
    }

    public SimileTimeLine getSimile()
    {
        //The preference here is lazy initalization
        if (source == null)
        {
            source = new SimileTimeLine(getElement());
        }

        return source;
    }
    
}
