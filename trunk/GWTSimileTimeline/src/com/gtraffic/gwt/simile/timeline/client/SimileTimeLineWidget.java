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

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.Widget;


/**
 * The SIMILE widget
 * <br/>Example:
 * <br/>SimileWidget simWidget = new SimileWidget(e);
 * <br/>
 * <br/>access the Simile object by:
 * <br/>Simile sim = simWidget.getSimile();
 * @author ajr
 *
 */
public class SimileTimeLineWidget extends Widget
{
    public SimileTimeLine source = null;
    private Element el = null;

    public SimileTimeLineWidget(String height, String width)
    {
        el = DOM.createDiv();
        setElement(el);
        setHeight(height);
        setWidth(width);
    }

    public SimileTimeLine getSimile()
    {
        //The preference here is lazy initalization
        if (source == null)
        {
            source = new SimileTimeLine(getElement());
        }

        return source;
    }
    
}
