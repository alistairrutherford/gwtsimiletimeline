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
package com.netthreads.gwt.simile.timeline.client;

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
    private Theme theme = null; 
    private ArrayList bandInfos = null;
    private ArrayList bandHotZones = null;
    private ArrayList bandDecorators = null;
    private TimeLine timeline = null;
    private Element divElement = null;
    private ITimeLineRender renderer = null;

    /**
     * Create timeline elements and assign renderer. The renderer must implement 
     * the ITimeLineRender interface 'render' function which manipulates
     * the widget timeline elements to make the timeline.
     * 
     * @param height
     * @param width
     * @param render
     */
    public TimeLineWidget(String height, String width, ITimeLineRender render)
    {
        // ---------------------------------------------------------------
    	// Bands
        // ---------------------------------------------------------------
        bandInfos = new ArrayList();
        bandHotZones = new ArrayList();
        bandDecorators = new ArrayList();

        // ---------------------------------------------------------------
        // Create Theme object
        // ---------------------------------------------------------------
        theme = createTheme();
        theme.setEventLabelWidth(400);
        
        // ---------------------------------------------------------------
        // Event source
        // ---------------------------------------------------------------
        eventSource = EventSource.create();

        // ---------------------------------------------------------------
        // Create div to draw timeline into
        // ---------------------------------------------------------------
        divElement = DOM.createDiv();
        setElement(divElement);
        setHeight(height);
        setWidth(width);
        
        // ---------------------------------------------------------------
        // Set timeline render
        // ---------------------------------------------------------------
        this.renderer = render;
    }
    
    /**
     * Called when the element DIV is attached to the client DOM.
     */
    protected void onAttach() 
    {
        super.onAttach();

        initialise();
    }
    
    /**
     * Initialise timeline views
     * 
     * Took a while to figure this out but you have to set the widget width _after_
     * it has been created in order for the timeline creation to work. 
     *
     */
    public void initialise()
    {
    	setWidth(Integer.toString(ClientSizeHelper.getClientWidth()) + "px");
    	setHeight(Integer.toString(ClientSizeHelper.getClientHeight()) + "px");
    	layout();
    }
    

    /**
     * Creates timeline, elements have to be setup prior to calling this.
     *
     */
    public TimeLine create()
    {
        // ---------------------------------------------------------------
        // Render timeline into this widget
        // ---------------------------------------------------------------
    	renderer.render(this);
    	
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

            while (--count > 0)
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

    public ArrayList getBandDecorators()
    {
        return bandDecorators;
    }

    public ArrayList getBandHotZones()
    {
        return bandHotZones;
    }

    public ArrayList getBandInfos()
    {
        return bandInfos;
    }

	public Theme getTheme() 
	{
		return theme;
	}
}
