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

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.Widget;

import java.util.ArrayList;


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
    private ArrayList bandInfos = null;
    private TimeLine timeline = null;
    private Element divElement = null;

    public TimeLineWidget(String height, String width)
    {
        eventSource = EventSource.create();

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
        ArrayList bandInfos = new ArrayList();
        ArrayList bandHotZones = new ArrayList();
        ArrayList bandDecorators = new ArrayList();

        // ---------------------------------------------------------------
        // Create Theme object
        // ---------------------------------------------------------------
        Theme theme = createTheme();
        theme.setEventLabelWidth(400);
        
        // ---------------------------------------------------------------
        // HotZones
        // ---------------------------------------------------------------
        
        // ---------------------------------------------------------------
        // Band Decorators
        // ---------------------------------------------------------------
        
        // Phase 1
        SpanHighlightDecoratorOptions phase1Opts = SpanHighlightDecoratorOptions.create();
        phase1Opts.setStartDate("2900 BC");
        phase1Opts.setEndDate("2700 BC");
        phase1Opts.setColor("#FFC080");
        phase1Opts.setOpacity(50);
        phase1Opts.setStartLabel("");
        phase1Opts.setEndLabel("");
        phase1Opts.setTheme(theme);
        SpanHighlightDecorator phase1decorator = SpanHighlightDecorator.create(phase1Opts);
        bandDecorators.add(phase1decorator);        

        // Phase 2
        SpanHighlightDecoratorOptions phase2Opts = SpanHighlightDecoratorOptions.create();
        phase2Opts.setStartDate("2900 BC");
        phase2Opts.setEndDate("2400 BC");
        phase2Opts.setColor("#CDCDCD");
        phase2Opts.setOpacity(50);
        phase2Opts.setStartLabel("");
        phase2Opts.setEndLabel("");
        phase2Opts.setTheme(theme);
        SpanHighlightDecorator phase2decorator = SpanHighlightDecorator.create(phase2Opts);
        bandDecorators.add(phase2decorator);        

        // Phase 3
        SpanHighlightDecoratorOptions phase3Opts = SpanHighlightDecoratorOptions.create();
        phase3Opts.setStartDate("2600 BC");
        phase3Opts.setEndDate("1600 BC");
        phase3Opts.setColor("#FFC080");
        phase3Opts.setOpacity(50);
        phase3Opts.setStartLabel("Stone");
        phase3Opts.setEndLabel("");
        phase3Opts.setTheme(theme);
        SpanHighlightDecorator phase3decorator = SpanHighlightDecorator.create(phase3Opts);
        bandDecorators.add(phase3decorator);        
        
        PointHighlightDecoratorOptions startPointOpts = PointHighlightDecoratorOptions.create();
        startPointOpts.setDate("4000 BC");
        startPointOpts.setColor("#FFC080");
        startPointOpts.setOpacity(50);
        startPointOpts.setTheme(theme);
        PointHighlightDecorator startPointDecorator = PointHighlightDecorator.create(startPointOpts); 
        bandDecorators.add(startPointDecorator);
        

        PointHighlightDecoratorOptions endPointOpts = PointHighlightDecoratorOptions.create();
        endPointOpts.setDate("1600 BC");
        endPointOpts.setColor("#FFC080");
        endPointOpts.setOpacity(50);
        endPointOpts.setTheme(theme);
        PointHighlightDecorator endPointDecorator = PointHighlightDecorator.create(endPointOpts); 
        bandDecorators.add(endPointDecorator);
        
        // ---------------------------------------------------------------
        // Bands
        // ---------------------------------------------------------------
        
        BandOptions topOpts = BandOptions.create();
        topOpts.setWidth("5%");
        topOpts.setIntervalUnit(DateTime.CENTURY());
        topOpts.setIntervalPixels(200);
        topOpts.setShowEventText(false);
        topOpts.setTheme(theme);
        topOpts.setDate("3701 BC");

        BandInfo top = BandInfo.create(topOpts);
        top.setDecorators(bandDecorators);
        bandInfos.add(top);

        // Bands
        BandOptions bottomOpts = BandOptions.create();
        bottomOpts.setWidth("95%");
        bottomOpts.setTrackHeight(1.3f);
        bottomOpts.setTrackGap(0.1f);
        bottomOpts.setIntervalUnit(DateTime.CENTURY());
        bottomOpts.setIntervalPixels(50);
        bottomOpts.setShowEventText(true);
        bottomOpts.setTheme(theme);
        bottomOpts.setEventSource(eventSource);
        bottomOpts.setDate("3701 BC");

        BandInfo bottom = BandInfo.create(bottomOpts);
        bottom.setDecorators(bandDecorators);
        bandInfos.add(bottom);

        bottom.setSyncWith(0);
        bottom.setHighlight(true);

        // ---------------------------------------------------------------
        // Timeline
        // ---------------------------------------------------------------
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
     * Clear display artifacts.
     * 
     */
    public void clear()
    {
        if (visible())
        {
        	int count = bandInfos.size();
        	while (--count>0)
        	{
        		timeline.closeBubble(count);
        	}
        }
    }

    /**
     * Load data into widget through handler.
     *
     * @param dataUrl
     * @param handler
     */
    public void load(String dataUrl, TimelineXMLHandler handler)
    {
        timeline.loadXML(dataUrl, handler);
    }

    /**
     * Load data into widget through EventSource object.
     *
     * @param dataUrl
     */
    public void load(String dataUrl)
    {
    	eventSource.loadXML(dataUrl);
    }
    
    /**
     * Get timeline instance
     *
     * @return
     */
    public TimeLine getTimeLine()
    {
        if (timeline == null)
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

    public EventSource getEventSource()
    {
        return eventSource;
    }
}
