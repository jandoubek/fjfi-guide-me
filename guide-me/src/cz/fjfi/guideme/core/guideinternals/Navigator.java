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
    private RouteLeg currentSegment;
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
        advanceToNextEdge();
    }

    /**
     * returns current navigations instruction given elapsed time
     */
    public final RoutePoint getCurrentRoutePoint(long time)
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
        return generateRoutePoint();
    }
    
    /**
     * advances to the next segment
     */
    public final void goToNextSegment(long time)
    {
        RouteLeg oldSegment = currentSegment;
        while (oldSegment == currentSegment && !reachedEnd)
        {
            advanceToNextEdge();
        }
        timeOnCurrentEdge = 0;
        timeOnCurrentSegment = 0;
        lastTime = time;
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
    public final RouteLeg getCurrentSegment()
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
     * checks if the end of the route has been reached
     * @return boolean indicating if the end has been reached
     */
    public boolean reachedEnd()
    {
        return reachedEnd;
    }

    /**
     * skips to the next instruction
     */
    private void advanceToNextEdge()
    {
    	if (currentIterator.hasNext())
    	{
    	    currentIterator.next();
    		currentEdge = currentIterator.get();
    		if (currentSegment != currentIterator.getLeg())
    		{
    		    timeOnCurrentSegment = 0;
    		    currentSegment = currentIterator.getLeg();
    		}
    	}
    	else
    	{
    		reachedEnd = true;
    	}
    }
    
    /**
     * generates the current route point
     * @return the current point on the route
     */
    private RoutePoint generateRoutePoint()
    {
        return new RoutePoint(timeOnCurrentEdge,timeOnCurrentSegment,currentIterator.copy());
    }

}
