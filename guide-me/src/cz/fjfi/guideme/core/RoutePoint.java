package cz.fjfi.guideme.core;

/**
 * This class contains information returned by Navigator about the current point on the route
 * @author Martin Sochor
 *
 */
public class RoutePoint
{
    //== CLASS CONSTANTS ===========================================================
    //== CLASS VARIABLES ===========================================================
    //== INSTANCE VARIABLES ========================================================
    
    private long edgeDistancePassed;
    private long legDistancePassed;
    private RouteIterator iterator;
    
    //==============================================================================
    //== CONSTRUCTORS ==============================================================
    /**
     * constructor
     * @param edgeDistancePassed time passed since edge was reached
     * @param legDistancePassed time passed since leg was reached
     * @param iterator iterator pointing at the current edge
     */
    public RoutePoint(long edgeDistancePassed,
            long legDistancePassed, RouteIterator iterator)
    {
        this.edgeDistancePassed = edgeDistancePassed;
        this.legDistancePassed = legDistancePassed;
        this.iterator = iterator;
    }   
    //== GETTERS AND SETTERS =======================================================

    /**
     * returns how much time has passed since the current edge was reached
     * @return the edge distance passed
     */
    public long getEdgeDistancePassed()
    {
        return edgeDistancePassed;
    }

    /**
     * returns how much time has passed since the current leg was started
     * @return the leg distance passed
     */
    public long getLegDistancePassed()
    {
        return legDistancePassed;
    }

    /**
     * returns an iterator pointing to the current edge
     * @return current iterator
     */
    public RouteIterator getIterator()
    {
        return iterator.copy();
    }
}
