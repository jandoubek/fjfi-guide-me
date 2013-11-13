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
    private RouteLeg leg;
    private int legIndex;
    
    //==============================================================================
    //== CONSTRUCTORS ==============================================================
    /**
     * Creates the RouteItem from the edge and the leg it belongs to
     * @param edge
     * @param leg
     */
    RouteItem(GMEdge edge, RouteLeg leg, int legIndex)
    {
        this.edge = edge;
        this.leg = leg;
        this.legIndex = legIndex;
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
     * returns the leg the edge belongs to
     * @return the leg
     */
    public RouteLeg getLeg()
    {
        return leg;
    }

    /**
     * returns the index of the edge in the leg
     * @return leg index of the edge
     */
	public int getLegIndex() {
		return legIndex;
	}

    //== OTHER METHODS =============================================================
}
