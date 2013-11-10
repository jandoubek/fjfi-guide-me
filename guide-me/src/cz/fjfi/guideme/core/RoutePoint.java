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
    private int routeIndex;
    
    //==============================================================================
    //== CONSTRUCTORS ==============================================================
    /**
     * TODO: Comment
     * @param routeEdge
     * @param edgeDistancePassed
     * @param segmentDistancePassed
     * @param routeIndex
     */
    public RoutePoint(long edgeDistancePassed,
            long segmentDistancePassed, int routeIndex)
    {
        this.edgeDistancePassed = edgeDistancePassed;
        this.segmentDistancePassed = segmentDistancePassed;
        this.routeIndex = routeIndex;
    }   
    //== GETTERS AND SETTERS =======================================================

    /**
     * TODO: Comment
     * @return the edgeDistancePassed
     */
    public long getEdgeDistancePassed()
    {
        return edgeDistancePassed;
    }

    /**
     * TODO: Comment
     * @return the segmentDistancePassed
     */
    public long getSegmentDistancePassed()
    {
        return segmentDistancePassed;
    }

    /**
     * TODO: Comment
     * @return the routeIndex
     */
    public int getRouteIndex()
    {
        return routeIndex;
    }
}
