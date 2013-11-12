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
    private long segmentDistancePassed;
    private RouteIterator iterator;
    
    //==============================================================================
    //== CONSTRUCTORS ==============================================================
    /**
     * constructor
     * @param edgeDistancePassed time passed since edge was reached
     * @param segmentDistancePassed time passed since segment was reached
     * @param iterator iterator pointing at the current edge
     */
    public RoutePoint(long edgeDistancePassed,
            long segmentDistancePassed, RouteIterator iterator)
    {
        this.edgeDistancePassed = edgeDistancePassed;
        this.segmentDistancePassed = segmentDistancePassed;
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
     * returns how much time has passed since the current segment was reached
     * @return the segment distance passed
     */
    public long getSegmentDistancePassed()
    {
        return segmentDistancePassed;
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
