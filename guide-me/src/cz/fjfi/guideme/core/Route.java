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
    private List<Edge> route;
    private final Node start, end;
    
    public Route(List<Edge> edges)
    {
        this.route = edges;
        this.start = edges.get(0).getStart();
        this.end = edges.get(edges.size()-1).getEnd();
    }
    
    /**
     * Returns the start node of the route
     */
    public final Node getStart()
    {
        return start;
    }

    /**
     * Returns the end node of the route
     */
    public final Node getEnd()
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
    
    /**
     * Returns an iterator pointing to a given index in the route
     */
    public final RouteIterator iterator(int location)
    {
        return new RouteIterator(route.listIterator(location));
    }
}
