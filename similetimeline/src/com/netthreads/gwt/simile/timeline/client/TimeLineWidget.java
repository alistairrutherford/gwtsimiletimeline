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
import com.google.gwt.user.client.ui.UIObject;
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
    private TimeLine timeLine = null;
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

        if (timeLine==null) initialise();
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
    	create();
    }
    

    /**
     * Creates timeline, elements have to be setup prior to calling this.
     *
     */
    public void create()
    {
        // ---------------------------------------------------------------
        // Render timeline into this widget
        // ---------------------------------------------------------------
    	renderer.render(this);

        // ---------------------------------------------------------------
        // Timeline
        // ---------------------------------------------------------------
        timeLine = TimeLine.create(bandInfos, eventSource, divElement, getClientElement());
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
     * 
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
    public void clearBubbles()
    {
        if (visible())
        {
            int count = bandInfos.size();

            while (--count > 0)
            {
            	timeLine.closeBubble(count);
            }
        }
        
    }

    public void clearData()
    {
        eventSource.clear();
    }
    
    /**
     * Load data into widget through handler.
     *
     * @param dataUrl
     * @param handler
     */
    public void load(String dataUrl, TimelineXMLHandler handler)
    {
    	timeLine.loadXML(dataUrl, handler);
    }

    /**
     * Load data into widget through EventSource object.
     *
     * @param dataUrl
     */
    public void load(String dataUrl)
    {
        eventSource.loadXML(dataUrl);
        
        createEvent("Joker Spotted", "Jan 23 2009 00:00:00 GMT", "Feb 23 2009 00:00:00 GMT", true, null, null, "Oh, MY! The Joker is running madly about!!!!");
        createEvent("Doughnuts bought", "Jun 23 2007 08:00:00 GMT", "Jun 23 2007 08:00:00 GMT", false, null, null, "Who wanted the Cruelers??");
   /*     StringBuffer myBuff=new StringBuffer();
        myBuff.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        myBuff.append("<data>");
        myBuff.append("<event start=\"Jun 23 2009 00:00:00 GMT\" end=\"Jun 24 2009 12:00:00 GMT\" isDuration=\"true\" title=\"Joker Spotted\" icon=\"timelineData/images/icons/green-circle.png\" image=\"images/batman.jpg\"> Joker Alert</event></data>");
        eventSource.loadXMLText(myBuff.toString());*/
    }

    /**
     * Is timeline visible within containing view
     *
     * @return visible status
     */
    public boolean visible()
    {
    	/**
        * There might be an issue around this to do with how many views the widget is embedded down
        * into. This will examine the visibility of the client div and the parent but if you were
        * to put a parent view inside yet another view and stick that inside a tab, you might get
        * into trouble. 
        * */
    	Element clientElement = getClientElement();
    	Element containerElement = getElement();
    	
    	boolean client = UIObject.isVisible(clientElement);
    	boolean container = UIObject.isVisible(containerElement);
    	
        return (client&&container);
    }

    /**
     * Get client div element reference.
     * 
     * @return element ref
     */
    private Element getClientElement()
    {
    	Element element = getElement();
        if (getParent() != this)
        	element = getParent().getElement();
        
        return (element);
    }

    
    public TimeLine getTimeLine()
    {
        return timeLine;
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
/**
 * Event creation from parameters- takes in much data to process..
 * NOTE: you must have the util/timeline-helper.js file included in the module to operate this
 * 
 * @param title-Title for the event	
 * @param start- start time for the event- as a GMT String
 * @param end- end time for event- as string. NOTE: For non-duration events, you must insure that start =end
 * @param isDur Duration event?
 * @param icon- icon to use for this event
 * @param image- image to use for this event
 * @param body- html body of this event to display when user selects event
 */
	public void createEvent(String title, String start, String end, boolean isDur, String icon, String image, String body){
		StringBuffer myBuff=new StringBuffer();
        myBuff.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        myBuff.append("<data><event ");
        myBuff.append("start=\" "+start+"\" ");
        myBuff.append("end=\" "+end+"\" ");
        myBuff.append(" isDuration=\""+Boolean.toString(isDur)+"\" ");
        myBuff.append("title=\""+title+"\" ");
        if(icon!=null)
        	myBuff.append("icon=\""+icon+"\"");
        if(image!=null)
        	myBuff.append("image=\""+image+"\"");
        myBuff.append(">");
        myBuff.append(body);
        myBuff.append("</event></data>");		
        eventSource.loadXMLText(myBuff.toString());
	}
	
	/**
	 *  Event creation from xml text- similar to the author's example
	 *  NOTE: you must have the util/timeline-helper.js file included in the module to operate this
	 *  
	 * @param xmlText- XML text in the author's format
	 * 
	 * 
	 */
	public void createEvent(String xmlText){
		eventSource.loadXMLText(xmlText);
	}
	
	public void centerData(String date){
		this.renderer.centerData(this,date);
	}
}
