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

/**
 * BandInfo
 *
 * @author ajr
 */
public class BandInfo extends JavaScriptObject
{
    protected BandInfo(int opaque)
    {
        super(opaque);
    }
    
    public static BandInfo create(BandOptions options)
    {
        return BandInfoImpl.create(options);
    }
    
    public void closeBubble()
    {
        BandInfoImpl.closeBubble(this);
    }
    
    public void setSyncWith(int value)
    {
        BandInfoImpl.setSyncWith(this, value);
    }

    public void setHighlight(boolean value)
    {
        BandInfoImpl.setHighlight(this, value);
    }
    
}
