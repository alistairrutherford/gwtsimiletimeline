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

    public native static void loadXML(String dataUrl, TimelineXMLHandler handler) /*-{
	    $wnd.Timeline.loadXML(dataUrl, function(xml, url) { handler.@com.netthreads.gwt.simile.timeline.client.TimelineXMLHandler::onCompletion(Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;)(xml,url) });
	}-*/;

    public native static int getBandCount(TimeLine timeLine) /*-{
        return timeLine.getBandCount();
    }-*/;
    
    public native static void layout(TimeLine timeLine) /*-{
        timeLine.layout();
    }-*/;

    public native static void closeBubble(int index, TimeLine timeLine) /*-{
        timeLine.getBand(index).closeBubble();
    }-*/;
    
    // TODO: Mibbe move this into actual rtns
    public native static boolean visible(Element divElement) /*-{
        if (divElement.style.display!='none')
            return true;
        else
            return false;
    }-*/;

    
}
