package cz.fjfi.guideme.core;

/**
 * A single edge on the route
 * @author Martin Sochor
 *
 */
public class RouteEdge
{
    //== CLASS CONSTANTS ===========================================================
    //== CLASS VARIABLES ===========================================================
    //== INSTANCE VARIABLES ========================================================
    
    private GMEdge edge;
    private RouteSegment segment;
    
    //==============================================================================
    //== CONSTRUCTORS ==============================================================
    /**
     * Creates the RouteEdge from the edge and the segment it belongs to
     * @param edge
     * @param segment
     */
    public RouteEdge(GMEdge edge, RouteSegment segment)
    {
        this.edge = edge;
        this.segment = segment;
    }
    //== GETTERS AND SETTERS =======================================================

    /**
     * returns the edge
     * @return the edge
     */
    public GMEdge getEdge()
    {
        return edge;
    }

    /**
     * returns the segment the edge belongs to
     * @return the segment
     */
    public RouteSegment getSegment()
    {
        return segment;
    }

    //== OTHER METHODS =============================================================
}
