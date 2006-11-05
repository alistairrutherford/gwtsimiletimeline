package com.gtraffic.gwt.simile.timeline.client;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;

import java.util.List;


/**
 * TimeLine
 *
 * @author ajr
 */
public class TimeLine extends JavaScriptObject
{
    protected TimeLine(int opaque)
    {
        super(opaque);
    }

    /**
     * Create TimeLine object
     */
    public static TimeLine create(List bands, EventSource source, Element divElement)
    {
        BandInfo[] bandArr = listToBandArray(bands);

        JavaScriptObject jarr = JavaScriptObjectHelper.arrayConvert(bandArr);

        return TimeLineImpl.create(jarr, divElement);
    }

    /**
     * Helper function to create [] array from List.
     * @param list
     * @return
     */
    private static BandInfo[] listToBandArray(List list)
    {
        BandInfo[] array = new BandInfo[list.size()];

        for (int i = 0; i < array.length; i++)
        {
            array[i] = (BandInfo)list.get(i);
        }

        return array;
    }

    public void layout()
    {
        TimeLineImpl.layout(this);
    }

    public void clear()
    {
        TimeLineImpl.clearBubbles(this);
    }
}
