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

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;

/**
 * TimeLineImpl
 * 
 * @author ajr
 *
 */
class TimeLineImpl
{
    // -------------------------------------------------------------------
    // Timeline
    // -------------------------------------------------------------------

    public native static TimeLine create(JavaScriptObject bands, Element divElement) /*-{
        return $wnd.Timeline.create(divElement, bands);
    }-*/;
    
    public native static int getBandCount(TimeLine timeLine) /*-{
        return timeLine.getBandCount();
    }-*/;
    
    public native static void layout(TimeLine timeLine) /*-{
        try
        {
            timeLine.layout();
        }
        catch (e)
        {
            alert(e.name + "," + e.message);
        }
    }-*/;

    public native static void clearBubbles(TimeLine timeLine) /*-{
        var count = timeLine.getBandCount();
        for (var i=0; i<count; i++)
        {
            timeLine.getBand(i).closeBubble();
        }
    }-*/;
    
    public native static boolean visible(Element divElement) /*-{
        if (divElement.style.display!='none')
            return true;
        else
            return false;
    }-*/;

    
}
