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
    private RouteLeg currentLeg;
    private long lastTime;
    private long timeOnCurrentEdge;
    private long timeOnCurrentLeg;
    
    public Navigator(Route route)
    {
        this.route = route;
        this.currentIterator = route.iterator();
        this.lastTime = 0;
        this.timeOnCurrentEdge = 0;
        this.timeOnCurrentLeg = 0;
        this.reachedEnd = false;
        advanceToNextEdge();
    }

    /**
     * returns current navigations instruction given elapsed time
     */
    public final RoutePoint getCurrentRoutePoint(long time)
    {
        long timeDelta = time - lastTime + timeOnCurrentEdge;
        timeOnCurrentLeg -= timeOnCurrentEdge;
        // advance to the proper point on the route
        while (timeDelta > currentEdge.getTimeDistance() && !reachedEnd)
        {
            timeOnCurrentLeg += currentEdge.getTimeDistance();
            timeDelta -= currentEdge.getTimeDistance();
            advanceToNextEdge();
        }
        timeOnCurrentEdge = timeDelta;
        timeOnCurrentLeg += timeOnCurrentEdge;
        lastTime = time;
        return generateRoutePoint();
    }
    
    /**
     * advances to the next leg
     */
    public final void goToNextLeg(long time)
    {
        advanceToNextLeg();
        timeOnCurrentEdge = 0;
        timeOnCurrentLeg = 0;
        lastTime = time;
    }
    
    /**
     * moves back to the previous leg
     */
    public final void goToPreviousLeg(long time)
    {
        moveBackToPreviousLeg();
        timeOnCurrentEdge = 0;
        timeOnCurrentLeg = 0;
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
    public final RouteLeg getCurrentLeg()
    {
        return currentLeg;
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
     * skips to the next edge
     */
    private void advanceToNextEdge()
    {
    	if (currentIterator.hasNext())
    	{
    	    currentIterator.next();
    		currentEdge = currentIterator.get();
    		if (currentLeg != currentIterator.getLeg())
    		{
    		    timeOnCurrentLeg = 0;
    		    currentLeg = currentIterator.getLeg();
    		}
    	}
    	else
    	{
    		reachedEnd = true;
    	}
    }
    
    /**
     * skips to the next leg
     */
    private void advanceToNextLeg()
    {
        if (currentIterator.hasNextLeg())
        {
            timeOnCurrentLeg = 0;
            currentLeg = currentIterator.nextLeg();
            currentEdge = currentIterator.next();
        }
        else
        {
            skipToEnd();
        }
    }
    
    /**
     * moves back to the previous leg
     */
    private void moveBackToPreviousLeg()
    {
        if (currentIterator.hasPreviousLeg())
        {
            timeOnCurrentLeg = 0;
            currentLeg = currentIterator.previousLeg();
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
        timeOnCurrentLeg = 0;
    }
    
    /**
     * generates the current route point
     * @return the current point on the route
     */
    private RoutePoint generateRoutePoint()
    {
        return new RoutePoint(timeOnCurrentEdge,timeOnCurrentLeg,currentIterator.copy());
    }

}
