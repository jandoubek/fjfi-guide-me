package cz.fjfi.guideme.core;

/**
 * A single edge on the route
 * @author Martin Sochor
 *
 */
class RouteItem
{
    //== CLASS CONSTANTS ===========================================================
    //== CLASS VARIABLES ===========================================================
    //== INSTANCE VARIABLES ========================================================
    
    private GMEdge edge;
    private RouteStretch stretch;
    private int stretchIndex;
    
    //==============================================================================
    //== CONSTRUCTORS ==============================================================
    /**
     * Creates the RouteItem from the edge and the stretch it belongs to
     * @param edge
     * @param stretch
     */
    RouteItem(GMEdge edge, RouteStretch stretch, int stretchIndex)
    {
        this.edge = edge;
        this.stretch = stretch;
        this.stretchIndex = stretchIndex;
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
     * returns the stretch the edge belongs to
     * @return the stretch
     */
    public RouteStretch getStretch()
    {
        return stretch;
    }

    /**
     * returns the index of the edge in the stretch
     * @return stretch index of the edge
     */
	public int getStretchIndex() {
		return stretchIndex;
	}

    //== OTHER METHODS =============================================================
}
