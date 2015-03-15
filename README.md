# gwtsimiletimeline
GWT API library to support SIMILE Timeline within the GWT framework.

This was developed as part of web site www.gTraffic.info. The gTraffic site displays UK Traffic information on a Google Map.

The SIMILE Timeline is a DHTML-based widget for visualizing time-based events.

To use in your own projects:

- Get the latest jar file from the 'release' directory - Add the following to your

<appname>
.gwt.xml file (replace APPNAME with the name of your app).
<inherits name="com.netthreads.gwt.simile.timeline.Timeline">
</inherits>
NEW in v1.0.0.1

load xml as text directly into timeline source object
  EventSource::loadXMLText
load json text directly into timeline source object
  EventSource::loadJSON 
6 Nov 2007: Plans are finally underway to port this to GWT 1.4.

5 Apr 2008: I have (finally) updated the timeline code to work with GWT 1.4..

1 July 2008: Timeline source has been updated to work with GWT 1.5. Many thanks to Terrance for undertaking this work.
