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

    private List<GMEdge> detailedRoute;
    private List<RouteEdge> route = null;
    private final GMNode start, end;
    
//==============================================================================
//== CONSTRUCTORS ==============================================================
    
    /***************************************************************************
     * TODO: comment
     */
    public Route(List<GMEdge> edges)
    {
        this.detailedRoute = edges;
        this.start = edges.get(0).getStart();
        this.end = edges.get(edges.size()-1).getEnd();
        constructRoute(detailedRoute);
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
        return new RouteIterator(detailedRoute.listIterator());
    }
    
    /**
     * Returns an iterator pointing to a given index in the route
     */
    public final RouteIterator iterator(int location)
    {
        return new RouteIterator(detailedRoute.listIterator(location));
    }
    
//== OTHER METHODS =============================================================
    /**
     * Constructs a "rough" route out of the list of GMEdges
     * TODO: Handling empty lists, handling changing locations
     * @param edges
     */
    private void constructRoute(List<GMEdge> edges)
    {
        GMNode currentStart = getStart();
        GMNode currentNode = getStart();
        ListIterator<GMEdge> currentIterator = edges.listIterator();
        GMEdge currentEdge = currentIterator.next();
        Direction currentDirection = currentEdge.getDirection();

        while (currentIterator.hasNext())
        {
            long accumulatedDistance = 0;
            while (currentIterator.hasNext() && currentDirection == currentEdge.getDirection())
            {
                accumulatedDistance += currentEdge.getTimeDistance();
                currentNode = currentEdge.getEnd();
                currentEdge = currentIterator.next();
            }
            route.add(new RouteEdge(currentStart, currentNode, currentDirection, accumulatedDistance));
            currentStart = currentNode;
            currentDirection = currentEdge.getDirection();
        }
    }
}
