/*
 * Copyright 2006 Alistair Rutherford (http://code.google.com/p/gwtsimiletimeline/)
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.gtraffic.gwt.simile.timeline.client;

import java.util.ArrayList;

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.Widget;


/**
 * The SIMILE Timeline Widget
 * <br/>Example:
 * <br/>TimeLineWidget simWidget = new SimileWidget(e);
 * <br/>
 * <br/>access the Simile object by:
 * <br/>Simile sim = simWidget.getTimeLine();
 * 
 * @author ajr
 *
 */
public class TimeLineWidget extends Widget
{
    private EventSource eventSource = null;
    private TimeLine timeline = null;
    private ArrayList bandInfos = null;
    private Element divElement = null;

    public TimeLineWidget(String height, String width)
    {
        eventSource = EventSource.create();
        bandInfos = new ArrayList();
        
        divElement = DOM.createDiv();
        setElement(divElement);
        setHeight(height);
        setWidth(width);
    }

    /**
     * Creates default timeline view, override this to generate your own
     *
     */
    protected TimeLine create()
    {
        // Create Theme object
        Theme theme = createTheme();
        theme.setEventLabelWidth(400);

        BandOptions topOpts = BandOptions.create();
        topOpts.setWidth("5%");
        topOpts.setIntervalUnit(DateTime.YEAR());
        topOpts.setIntervalPixels(400);
        topOpts.setShowEventText(false);
        topOpts.setTheme(theme);

        BandInfo top = BandInfo.create(topOpts);
        bandInfos.add(top);

        BandOptions bottomOpts = BandOptions.create();
        bottomOpts.setWidth("95%");
        bottomOpts.setTrackHeight(1.3f);
        bottomOpts.setTrackGap(0.1f);
        bottomOpts.setIntervalUnit(DateTime.MONTH());
        bottomOpts.setIntervalPixels(100);
        bottomOpts.setShowEventText(true);
        bottomOpts.setTheme(theme);
        bottomOpts.setEventSource(eventSource);
        
        BandInfo bottom = BandInfo.create(bottomOpts);
        bandInfos.add(bottom);

        bottom.setSyncWith(0);
        bottom.setHighlight(true);
        
        TimeLine timeLine = TimeLine.create(bandInfos, eventSource, divElement);

        return timeLine;
    }

    /**
     * Creates default theme, override to apply your own.
     * 
     */
    public Theme createTheme()
    {
        Theme theme = Theme.create();

        return theme;
    }

    /**
     * Repaint widget 
     */
    public void layout()
    {
        if (visible())
        {
            getTimeLine().layout();
        }
    }
    
    /**
     * Clear display artifacts 
     */
    public void clear()
    {
        if (visible())
        {
            getTimeLine().clear();
        }
    }
    
    /**
     * Load data into widget
     * 
     * @param dataUrl
     */
    public void load(String dataUrl)
    {
        eventSource.load(dataUrl);
    }

    /**
     * Get timeline instance
     * 
     * @return
     */
    public TimeLine getTimeLine()
    {
        if (timeline==null)
        {
            timeline = create();
        }
        
        return timeline;
    }

    /**
     * Returns whether the timeline view is visible or not. Operations on the timeline
     * will throw an exception unless it is visible.
     * 
     * @return visible status
     */
    public boolean visible()
    {
        return TimeLineImpl.visible(divElement);
    }
    
}
