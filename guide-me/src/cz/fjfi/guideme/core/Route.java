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

    private List<GMEdge> route;
    private final GMNode start, end;
    
//==============================================================================
//== CONSTRUCTORS ==============================================================
    
    /***************************************************************************
     * TODO: comment
     */
    public Route(List<GMEdge> edges)
    {
        this.route = edges;
        this.start = edges.get(0).getStart();
        this.end = edges.get(edges.size()-1).getEnd();
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
    
    /**
     * Returns an iterator pointing to a given index in the route
     */
    public final RouteIterator iterator(int location)
    {
        return new RouteIterator(route.listIterator(location));
    }
    
//== OTHER METHODS =============================================================
    
}
