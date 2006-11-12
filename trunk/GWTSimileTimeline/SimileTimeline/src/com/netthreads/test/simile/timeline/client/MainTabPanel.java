package com.netthreads.test.simile.timeline.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.SourcesTabEvents;
import com.google.gwt.user.client.ui.TabListener;
import com.google.gwt.user.client.ui.TabPanel;

import com.netthreads.gwt.simile.timeline.client.TimeLineWidget;


/**
 * Main Panel
 *
 * Note: The Timeline view does not like any operation performed upon it unless it is the
 * focussed view. Not sure why not but you will save yourself endless grief if you remember
 * this.
 *
 */
public class MainTabPanel extends Composite
{
    private TabPanel panelTabbed = null;
    private AboutTab tabHelp = null;
    private TimeLineTab tabTimeLine = null;

    /**
     * MainTabPanel
     *
     */
    public MainTabPanel()
    {
        panelTabbed = new TabPanel();

        // Addition is backwards from order of display!
        // Help
        tabTimeLine = new TimeLineTab();
        panelTabbed.add(tabTimeLine, "Timeline", true);

        // Help
        tabHelp = new AboutTab();
        panelTabbed.add(tabHelp, "Help", true);

        panelTabbed.selectTab(0);
        panelTabbed.setSize("100%", "100%");

        initWidget(panelTabbed);

        // Hook up a tab listener to do something when the user selects a tab.
        panelTabbed.addTabListener(new TabListener()
            {
            	TimeLineWidget widget = tabTimeLine.getTimeLineWidget();
            	
                public void onTabSelected(SourcesTabEvents sender, int tabIndex)
                {
                    widget.layout();
                }

                public boolean onBeforeTabSelected(SourcesTabEvents sender, int tabIndex)
                {
                    widget.clear();
                    return true;
                }
            });
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
     * resizeTabs
     * @param width
     * @param height
     */
    private void resizeTabs(int width, int height)
    {
        if ((width > 0) && (height > 0))
        {
            int tabBarAbsoluteLeft = panelTabbed.getTabBar().getAbsoluteLeft();
            int tabBarOffsetHeight = panelTabbed.getTabBar().getOffsetHeight();

            int viewWidth = width - tabBarAbsoluteLeft;
            int viewHeight = height - tabBarOffsetHeight;

            tabTimeLine.onWindowResized(viewWidth, viewHeight);
            tabHelp.onWindowResized(viewWidth, viewHeight);

            panelTabbed.setWidth(Integer.toString(width) + "px");
            panelTabbed.setHeight(Integer.toString(height) + "px");
        }
    }

    /**
     * Returns help tab
     *
     * @return map tab
     */
    public AboutTab getTabHelp()
    {
        return tabHelp;
    }

    /**
     * Returns timeline control
     *
     * @return map control
     */
    public TimeLineTab getTabTimeLine()
    {
        return tabTimeLine;
    }

    /**
     * Return tab
     * @return
     */
    public TabPanel getPanelTabbed()
    {
        return panelTabbed;
    }
}
