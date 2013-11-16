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
    private long stretchDistancePassed;
    private RouteIterator iterator;
    
    //==============================================================================
    //== CONSTRUCTORS ==============================================================
    /**
     * constructor
     * @param edgeDistancePassed time passed since edge was reached
     * @param stretchDistancePassed time passed since stretch was reached
     * @param iterator iterator pointing at the current edge
     */
    public RoutePoint(long edgeDistancePassed,
            long stretchDistancePassed, RouteIterator iterator)
    {
        this.edgeDistancePassed = edgeDistancePassed;
        this.stretchDistancePassed = stretchDistancePassed;
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
     * returns how much time has passed since the current stretch was started
     * @return the stretch distance passed
     */
    public long getStretchDistancePassed()
    {
        return stretchDistancePassed;
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
