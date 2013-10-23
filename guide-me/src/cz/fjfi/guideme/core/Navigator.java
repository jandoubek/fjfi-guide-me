package cz.fjfi.guideme.core;

/***
 * This class contains the navigation logic for the GuideMe app.
 * @author Martin Sochor
 *
 */

public class Navigator
{
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
        getNextLabel();
    }

    /**
     * returns current navigations instruction given elapsed time
     */
    public final String getCurrentLabel(long time)
    {
        long timeDelta = time - lastTime + timeOnCurrentEdge;
        // advance to the proper point on the route
        while (timeDelta > currentEdge.getTimeDistance() && currentIterator.hasNext())
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
        if (currentIterator.hasNext())
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
     * skips to the next instruction
     */
    private void advanceToNextEdge()
    {
        currentEdge = currentIterator.next();
    }
    
    /**
     * generates instructions from the current edge
     */
    private String generateLabel()
    {
        GMNode endpoint = currentEdge.getEnd();
        String label = currentEdge.getDescription() + "\n-> " + endpoint.getDescription();
        return label;
    }
}
