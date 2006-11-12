package com.netthreads.test.simile.timeline.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Frame;


/**
 * A composite that holds html frame
 */
public class AboutTab extends Composite
{
    // GUI elements
    private Frame frameAbout = null;

    /**
     * Constructor
     */
    public AboutTab()
    {
        // About
        frameAbout = new Frame("help/about.html");

        initWidget(frameAbout);
    }

    /**
     * onWindowResized
     * @param width
     * @param height
     */
    public void onWindowResized(int width, int height)
    {
        resizeTabs(width, height);
    }

    /**
     * resizeMap
     * @param width
     * @param height
     */
    private void resizeTabs(int width, int height)
    {
        if ((width > 0) && (height > 0))
        {
            frameAbout.setWidth(Integer.toString(width) + "px");
            frameAbout.setHeight(Integer.toString(height) + "px");
        }
    }

}
