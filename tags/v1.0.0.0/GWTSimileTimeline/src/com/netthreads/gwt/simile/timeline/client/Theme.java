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

/**
 * Theme, currently only creates the classic theme.
 *
 * @author ajr
 */
public class Theme extends JavaScriptObject
{
    protected Theme(int opaque)
    {
        super(opaque);
    }
    
    public static Theme create()
    {
        return ThemeImpl.create();
    }

    public void setEventLabelWidth(int width)
    {
        ThemeImpl.setEventLabelWidth(this, width);
    }
        
    
}