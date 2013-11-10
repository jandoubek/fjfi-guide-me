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
    
    private GMEdge edge;
    private RouteSegment segment;
    private RouteIterator iterator;
    private long edgeDistancePassed;
    private long segmentDistancePassed;

    //==============================================================================
    //== CONSTRUCTORS ==============================================================

    /**
     * Constructs the route point from the given parameters
     * @param edge
     * @param segment
     * @param iterator
     * @param distancePassed
     */
    public RoutePoint(GMEdge edge, RouteSegment segment,
            RouteIterator iterator, long edgeDistancePassed,
            long segmentDistancePassed)
    {
        this.edge = edge;
        this.segment = segment;
        this.iterator = iterator;
        this.edgeDistancePassed = edgeDistancePassed;
        this.segmentDistancePassed = segmentDistancePassed;
    }    
    
    //== GETTERS AND SETTERS =======================================================
    
    /**
     * returns the current edge
     * @return the edge
     */
    public GMEdge getEdge()
    {
        return edge;
    }
    /**
     * returns the current segment
     * TODO: Comment
     * @return
     */
    public RouteSegment getSegment()
    {
        return segment;
    }
    /**
     * returns the iterator to the current point on the route
     * @return the iterator
     */
    public RouteIterator getIterator()
    {
        return iterator;
    }
    /**
     * returns the distance passed on the current edge
     * @return the distancePassed
     */
    public long getEdgeDistancePassed()
    {
        return edgeDistancePassed;
    }
    /**
     * returns the distance passed on the current segment
     * @return the segmentDistancePassed
     */
    public long getSegmentDistancePassed()
    {
        return segmentDistancePassed;
    }
}
