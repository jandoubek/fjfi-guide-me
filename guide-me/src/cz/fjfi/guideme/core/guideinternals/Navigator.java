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
    private RouteStretch currentStretch;
    private long lastTime;
    private long timeOnCurrentEdge;
    private long timeOnCurrentStretch;
    
    public Navigator(Route route)
    {
        this.route = route;
        this.currentIterator = route.iterator();
        this.lastTime = 0;
        this.timeOnCurrentEdge = 0;
        this.timeOnCurrentStretch = 0;
        this.reachedEnd = false;
        advanceToNextEdge();
    }

    /**
     * returns current navigations instruction given elapsed time
     */
    public final RoutePoint getCurrentRoutePoint(long time)
    {
        long timeDelta = time - lastTime + timeOnCurrentEdge;
        timeOnCurrentStretch -= timeOnCurrentEdge;
        // advance to the proper point on the route
        while (timeDelta > currentEdge.getTimeDistance() && !reachedEnd)
        {
            timeOnCurrentStretch += currentEdge.getTimeDistance();
            timeDelta -= currentEdge.getTimeDistance();
            advanceToNextEdge();
        }
        timeOnCurrentEdge = timeDelta;
        timeOnCurrentStretch += timeOnCurrentEdge;
        lastTime = time;
        return generateRoutePoint();
    }
    
    /**
     * advances to the next stretch
     */
    public final void goToNextStretch(long time)
    {
        advanceToNextStretch();
        timeOnCurrentEdge = 0;
        timeOnCurrentStretch = 0;
        lastTime = time;
    }
    
    /**
     * moves back to the previous stretch
     */
    public final void goToPreviousStretch(long time)
    {
        moveBackToPreviousStretch();
        timeOnCurrentEdge = 0;
        timeOnCurrentStretch = 0;
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
     * returns current stretch
     * @return the current stretch
     */
    public final RouteStretch getCurrentStretch()
    {
        return currentStretch;
    }
    
    /**
     * returns the index of the current RouteItem on the route
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
     * skips to the next edge
     */
    private void advanceToNextEdge()
    {
    	if (currentIterator.hasNext())
    	{
    	    currentIterator.next();
    		currentEdge = currentIterator.get();
    		if (currentStretch != currentIterator.getStretch())
    		{
    		    timeOnCurrentStretch = 0;
    		    currentStretch = currentIterator.getStretch();
    		}
    	}
    	else
    	{
    		reachedEnd = true;
    	}
    }
    
    /**
     * skips to the next stretch
     */
    private void advanceToNextStretch()
    {
        if (currentIterator.hasNextStretch())
        {
            timeOnCurrentStretch = 0;
            currentStretch = currentIterator.nextStretch();
            currentEdge = currentIterator.next();
        }
        else
        {
            skipToEnd();
        }
    }
    
    /**
     * moves back to the previous stretch
     */
    private void moveBackToPreviousStretch()
    {
        if (currentIterator.hasPreviousStretch())
        {
            timeOnCurrentStretch = 0;
            currentStretch = currentIterator.previousStretch();
            currentEdge = currentIterator.next();
        }
    }
    
    /**
     * skips to the end
     */
    private void skipToEnd()
    {
        while (currentIterator.hasNext())
        {
            currentIterator.next();
        }
        reachedEnd = true;
        timeOnCurrentStretch = 0;
    }
    
    /**
     * generates the current route point
     * @return the current point on the route
     */
    private RoutePoint generateRoutePoint()
    {
        return new RoutePoint(timeOnCurrentEdge,timeOnCurrentStretch,currentIterator.copy());
    }

}
