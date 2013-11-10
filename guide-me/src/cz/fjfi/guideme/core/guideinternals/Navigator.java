package cz.fjfi.guideme.core.guideinternals;

import cz.fjfi.guideme.core.*;

/***
 * This class contains the navigation logic for the GuideMe app.
 * @author Martin Sochor
 *
 */

public class Navigator
{
	private boolean reachedEnd;
    private Route route;
    private RouteIterator currentIterator;
    private GMEdge currentEdge;
    private RouteSegment currentSegment;
    private long lastTime;
    private long timeOnCurrentEdge;
    private long timeOnCurrentSegment;
    
    public Navigator(Route route)
    {
        this.route = route;
        this.currentIterator = route.iterator();
        this.lastTime = 0;
        this.timeOnCurrentEdge = 0;
        this.timeOnCurrentSegment = 0;
        this.reachedEnd = false;
        getNextLabel();
    }

    /**
     * returns current navigations instruction given elapsed time
     */
    public final String getCurrentLabel(long time)
    {
        long timeDelta = time - lastTime + timeOnCurrentEdge;
        timeOnCurrentSegment -= timeOnCurrentEdge;
        // advance to the proper point on the route
        while (timeDelta > currentEdge.getTimeDistance() && !reachedEnd)
        {
            timeOnCurrentSegment += currentEdge.getTimeDistance();
            timeDelta -= currentEdge.getTimeDistance();
            advanceToNextEdge();
        }
        timeOnCurrentEdge = timeDelta;
        timeOnCurrentSegment += timeOnCurrentEdge;
        lastTime = time;
        return generateLabel();
    }

    /**
     * skips to the next instruction and returns it
     */
    public final String getNextLabel()
    {
        if (!reachedEnd)
        {
            advanceToNextEdge();
        }
        return generateLabel();
    }
    
    /**
     * returns route
     */
    public final Route getRoute()
    {
        return route;
    }
    
    /**
     * returns current edge
     */
    public final GMEdge getCurrentEdge()
    {
    	return currentEdge;
    }

    /**
     * returns current segment
     * @return the currentSegment
     */
    public final RouteSegment getCurrentSegment()
    {
        return currentSegment;
    }
    
    /**
     * returns the index of the current RouteEdge on the route
     * @return
     */
    public int getCurrentIndex()
    {
        return currentIterator.previousIndex();
    }

    /**
     * skips to the next instruction
     */
    private void advanceToNextEdge()
    {
    	if (currentIterator.hasNext())
    	{
    	    RouteEdge nextEdge = currentIterator.next();
    		currentEdge = nextEdge.getEdge();
    		if (currentSegment != nextEdge.getSegment())
    		{
    		    timeOnCurrentSegment = 0;
    		    currentSegment = nextEdge.getSegment();
    		}
    	}
    	else
    	{
    		reachedEnd = true;
    	}
    }
    
    /**
     * generates instructions from the current edge
     */
    private String generateLabel()
    {
        GMNode endpoint = currentEdge.getEnd();
        String label;
    	if (reachedEnd)
    	{
    		label = "Dosazen cil " + endpoint.getDescription();
        }
    	else
    	{
    		label = "Prave prochazite: " + currentEdge.getDescription() + "\n" +
            		"Dalsiho bodu " + endpoint.getDescription() +
            		" dosahnete za: " + (currentEdge.getTimeDistance() - timeOnCurrentEdge)/1000 + "s";
    	}
        return label;
    }
    
    /**
     * generates the current route point
     * @return the current point on the route
     */
    private RoutePoint generateRoutePoint()
    {
        return new RoutePoint(timeOnCurrentEdge,timeOnCurrentSegment,getCurrentIndex());
    }
}
