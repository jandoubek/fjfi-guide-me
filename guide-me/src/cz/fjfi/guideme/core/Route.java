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

    private List<RouteEdge> route = new ArrayList<RouteEdge>();
    private final GMNode start, end;
    
//==============================================================================
//== CONSTRUCTORS ==============================================================
    
    /***************************************************************************
     * TODO: comment
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
     * Returns an iterator pointing to the beginning of the route
     */
    public final RouteIterator iterator()
    {
        return new RouteIterator(route.listIterator());
    }
    
//== OTHER METHODS =============================================================
    /**
     * Constructs a "rough" route out of the list of GMEdges
     * TODO: Handling empty lists, handling changing locations
     * @param edges
     */
    private void constructRoute(List<GMEdge> edges)
    {
        ListIterator<GMEdge> currentIterator = edges.listIterator();
        GMEdge currentEdge = currentIterator.next();
        Direction currentDirection = currentEdge.getDirection();
        List<GMEdge> currentSegmentList = new ArrayList<GMEdge>();
        boolean lastEdgeFound = false;

        while (!lastEdgeFound)
        {
            if (currentDirection == currentEdge.getDirection())
            {
                currentSegmentList.add(currentEdge);
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
                RouteSegment newSegment = new RouteSegment(currentSegmentList);
                for (GMEdge newEdge : currentSegmentList)
                {
                    route.add(new RouteEdge(newEdge, newSegment));
                }
                currentSegmentList = new ArrayList<GMEdge>();
                currentDirection = currentEdge.getDirection();
            }
        }
    }
}
