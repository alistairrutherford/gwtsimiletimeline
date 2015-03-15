Tips and Tricks - How to get the most out of the timeline.

# Introduction #

This describes the answers to a few commonly asked questions.


# Details #

**- Clearing infobubble in tabbed panel**

In a tabbed panel where one (or more) of the tabs contains a timeline you must make sure that when another tab is selected any open infobubbles are closed. If you don’t they will just stay there and look bad. To avoid this add an event handler to catch the tab switching and close any open bubbles.

```
panelTabbed.addTabListener(new TabListener()
{
TimeLineWidget widget = tabTimeLine.getTimeLineWidget();

public void onTabSelected(SourcesTabEvents sender, int tabIndex)
{
resizeTabs(ClientSizeHelper.getClientWidth(), ClientSizeHelper.getClientHeight());
}

public boolean onBeforeTabSelected(SourcesTabEvents sender, int tabIndex)
{
widget.clearBubbles();
return true;
}
});
```

This is in the sample application..

**- Clearing the timeline**

Want to have multiple datasets but use the same timeline control? Simply call the widget clearData call i.e.

```
widget.clearData();
```

**- Calling back into your application from the timeline.**

if you examine gTraffic you will see that it is possible to click on an infobubble and flip back to the map.

I implement a function in my map data handler like so

```
private native void initJavaScriptFunctions(MapDataHandler context) /*-{
$wnd.selectMarker = function (id) {
context.@com.gtraffic.client.MapDataHandler::selectMarker(Ljava/lang/String;)(id) };
}-*/;
```

This defines a javascript function ’selectMarker’ which is called directly from a link on the infobubble. I have assigned a unique id to each of the markers on the currently displayed dataset. The infobubble link calls this function which in turn calls a method of MapDataHandler confusingly also called ’selectMarker’ which takes the id and opens an info window.