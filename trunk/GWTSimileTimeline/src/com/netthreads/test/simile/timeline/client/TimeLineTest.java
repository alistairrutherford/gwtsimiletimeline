package com.netthreads.test.simile.timeline.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.WindowResizeListener;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */

public class TimeLineTest implements EntryPoint, WindowResizeListener
{
    public static MainTabPanel mainPanel = null;

    public TimeLineTest()
    {
        mainPanel = new MainTabPanel();
    }

    /**
     * This is the entry point method.
     */
    public void onModuleLoad()
    {
        // Add resize listner to pass brower window changes down to enclosed views
        Window.addWindowResizeListener(this);

        RootPanel.get().add(mainPanel);

        RootPanel.get("loadingtext").setVisible(false);

        // Load dataset 
        DatasetHandler.getInstance().initialise(this, getInitialDataset());
        
        // Call the window resized handler to get the initial sizes setup.
        // Note there is an issue with the timeline drawing itself into
        // a div which hasn't been attached to the DOM. The resize will 
        // ultimately trigger a 'layout' call which seems to generate the
        // view correctly as long as it's done through _this_ mechanism and
        // not in the constructor, say, of the timline tab. TODO need to 
        // get to the bottom of this.
        onWindowResized(Window.getClientWidth(), Window.getClientHeight());
    }

    /**
     * getInitialDataset 
     * 
     * <p>Returns dataset to load on startup. </p>
     * 
     * @return dataset name
     */
    private String getInitialDataset()
    {
        String dataset = "site/data/stonehenge.xml";

        /** 
         * Put your permalink code here to set the inital dataset from url params.
         * 
         */
        
        return (dataset);
    }
    
    /**
     * Resize all components
     */
    public void onWindowResized(int width, int height)
    {
        mainPanel.onWindowResized(width, height);
    }

    public static MainTabPanel getMainPanel()
    {
        return mainPanel;
    }
}
