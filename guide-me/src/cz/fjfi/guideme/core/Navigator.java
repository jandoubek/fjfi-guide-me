package cz.fjfi.guideme.core;

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
    private long lastTime;
    private long timeOnCurrentEdge;
    
    public Navigator(Route route)
    {
        this.route = route;
        this.currentIterator = route.iterator();
        this.lastTime = 0;
        this.timeOnCurrentEdge = 0;
        this.reachedEnd = false;
        getNextLabel();
    }

    /**
     * returns current navigations instruction given elapsed time
     */
    public final String getCurrentLabel(long time)
    {
        long timeDelta = time - lastTime + timeOnCurrentEdge;
        // advance to the proper point on the route
        while (timeDelta > currentEdge.getTimeDistance() && !reachedEnd)
        {
            timeDelta -= currentEdge.getTimeDistance();
            advanceToNextEdge();
        }
        timeOnCurrentEdge = timeDelta;
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
     * skips to the next instruction
     */
    private void advanceToNextEdge()
    {
    	if (currentIterator.hasNext())
    	{
    		currentEdge = currentIterator.next();
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
    		label = "Reached final destination " + endpoint.getDescription();
        }
    	else
    	{
    		label = "Currently going through: " + currentEdge.getDescription() + "\n" +
            		"Will reach " + endpoint.getDescription() +
            		" in: " + (currentEdge.getTimeDistance() - timeOnCurrentEdge) + "ms";
    	}
        return label;
    }
}
