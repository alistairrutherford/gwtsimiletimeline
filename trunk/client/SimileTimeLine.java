package com.gtraffic.gwt.simile.timeline.client;

import com.google.gwt.user.client.Element;

import java.util.ArrayList;


/**
 * Simile Timline GWT wrapper class.
 *
 * @author ajr
 */
public class SimileTimeLine
{
    private Element divElement = null;
    private EventSource eventSource = null;
    private ArrayList bandInfos = null;
    private TimeLine timeLine = null;

    public SimileTimeLine(Element e)
    {
        bandInfos = new ArrayList();
        
        divElement = e;
        eventSource = EventSource.create();

        timeLine = createTimeLine();
    }

    /**
     * Creates default timeline view, override this to generate your own
     *
     */
    protected TimeLine createTimeLine()
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
     * Load timeline data from url.
     * @param dataUrl
     */
    public void load(String dataUrl)
    {
        eventSource.load(dataUrl);
    }

    /**
     * Redraws timline view to fit enclosing frame.
     *
     */
    public void layout()
    {
        timeLine.layout();
    }

    /**
     * Clear all display artifacts (i.e. bubbles) from view
     *
     */
    public void clear()
    {
        timeLine.clear();
    }

    /**
     * Reset timeline data display. Clears out current timeline display.
     *
     */
    public void reset()
    {
        eventSource.clear();
    }

    public TimeLine getTimeLine()
    {
        return timeLine;
    }

    public ArrayList getBands()
    {
        return bandInfos;
    }
}
