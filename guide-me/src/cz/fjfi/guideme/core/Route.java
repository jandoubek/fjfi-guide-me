package cz.fjfi.guideme.core;

import java.util.*;

/***
 * This class encapsulates routes found by the GuideMe app
 * Accessing the actual route is done with iterators
 * @author Martin Sochor
 *
 */

public class Route
{
//== CLASS CONSTANTS ===========================================================
//== CLASS VARIABLES ===========================================================
//== INSTANCE VARIABLES ========================================================

    private List<RouteItem> route = new ArrayList<RouteItem>();
    private final GMNode start, end;
    
//==============================================================================
//== CONSTRUCTORS ==============================================================
    
    /**
     * constructs a Route from a list of edges
     */
    public Route(List<GMEdge> edges)
    {
        this.start = edges.get(0).getStart();
        this.end = edges.get(edges.size()-1).getEnd();
        constructRoute(edges);
    }
   
//== GETTERS AND SETTERS =======================================================
    
    /**
     * Returns the start node of the route
     */
    public final GMNode getStart()
    {
        return start;
    }

    /**
     * Returns the end node of the route
     */
    public final GMNode getEnd()
    {
        return end;
    }
    
    /**
     * Returns the edge located at the index
     * @param location
     * @return edge at location
     */
    public final GMEdge getEdge(int location)
    {
        return route.get(location).getEdge();
    }
    
    /**
     * Returns the segment the edge located at the index belongs to
     * @param location
     * @return segment at location
     */
    public final RouteLeg getLeg(int location)
    {
        return route.get(location).getLeg();
    }
    
    /**
     * Returns an iterator pointing to the beginning of the route
     */
    public final RouteIterator iterator()
    {
        return new RouteIterator(route);
    }
    
//== OTHER METHODS =============================================================
    /**
     * Given a list of GMEdges, constructs the legs of the route
     * TODO: Handling changing locations
     * @param edges
     */
    private void constructRoute(List<GMEdge> edges)
    {
        ListIterator<GMEdge> currentIterator = edges.listIterator();
        if (!currentIterator.hasNext())
        {
            return;
        }
        GMEdge currentEdge = currentIterator.next();
        Direction currentDirection = currentEdge.getDirection();
        List<GMEdge> currentLegList = new ArrayList<GMEdge>();
        boolean lastEdgeFound = false;

        while (!lastEdgeFound)
        {
            if (currentDirection == currentEdge.getDirection())
            {
                currentLegList.add(currentEdge);
                if (currentIterator.hasNext())
                {
                    currentEdge = currentIterator.next();
                }
                else
                {
                    lastEdgeFound = true;
                }
            }
            if (currentDirection != currentEdge.getDirection() || lastEdgeFound)
            {
                RouteLeg newLeg = new RouteLeg(currentLegList);
                int i = 0;
                for (GMEdge newEdge : currentLegList)
                {
                    route.add(new RouteItem(newEdge, newLeg, i++));
                }
                currentLegList = new ArrayList<GMEdge>();
                currentDirection = currentEdge.getDirection();
            }
        }
    }
}
