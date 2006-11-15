package com.netthreads.test.simile.timeline.client;

import com.google.gwt.user.client.ui.Composite;

import com.netthreads.gwt.simile.timeline.client.TimeLineWidget;
import com.netthreads.gwt.simile.timeline.client.ITimeLineRender;

/**
 * A composite that holds SIMILE Timeline control
 */
public class TimeLineTab extends Composite
{
    // GUI elements
    private TimeLineWidget simileWidget = null;

    /**
     * Constructor
     */
    public TimeLineTab()
    {
    	ITimeLineRender render = new StonehengeRender();
    	
        simileWidget = new TimeLineWidget("100%", "100%", render);

        initWidget(simileWidget);

        // Apply default style
        simileWidget.setStyleName("timeline-default");
    }
    
    /**
     * onWindowResized
     * @param width
     * @param height
     */
    public void onWindowResized(int width, int height)
    {
        resize(width, height);
    }

    /**
     * resizeMap
     * @param width
     * @param height
     */
    private void resize(int width, int height)
    {
        if ((width > 0) && (height > 0))
        {
            simileWidget.setWidth(Integer.toString(width) + "px");
            simileWidget.setHeight(Integer.toString(height) + "px");
            
            simileWidget.layout();
        }
        
    }

    /**
     * Returns timeline widget to other UI components.
     * 
     * @return widget reference.
     */
    public TimeLineWidget getTimeLineWidget()
    {
        return simileWidget;
    }
    
}
