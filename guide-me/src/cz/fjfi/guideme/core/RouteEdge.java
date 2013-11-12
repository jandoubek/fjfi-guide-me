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
    private int segmentIndex;
    
    //==============================================================================
    //== CONSTRUCTORS ==============================================================
    /**
     * Creates the RouteEdge from the edge and the segment it belongs to
     * @param edge
     * @param segment
     */
    RouteEdge(GMEdge edge, RouteSegment segment, int segmentIndex)
    {
        this.edge = edge;
        this.segment = segment;
        this.segmentIndex = segmentIndex;
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

    /**
     * returns the index of the edge in the segment
     * @return segment index of the edge
     */
	public int getSegmentIndex() {
		return segmentIndex;
	}

    //== OTHER METHODS =============================================================
}
