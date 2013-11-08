package cz.fjfi.guideme.core;

import cz.fjfi.guideme.core.*;

/**
 * This class represents a "rough" edge on the route, used to generate instructions
 * @author Martin Sochor
 *
 */
public class RouteEdge
{
    //== CLASS CONSTANTS ===========================================================
    //== CLASS VARIABLES ===========================================================
    //== INSTANCE VARIABLES ========================================================
    
    private GMNode start;
    private GMNode end;
    private Direction direction;
    private long timeDistance;
    
    //==============================================================================
    //== CONSTRUCTORS ==============================================================
    
    public RouteEdge (GMNode start, GMNode end, Direction direction, long timeDistance)
    {
        this.start = start;
        this.end = end;
        this.direction = direction;
        this.timeDistance = timeDistance;
    }
    //== GETTERS AND SETTERS =======================================================

    /**
     * TODO: Comment
     * @return the start
     */
    public GMNode getStart()
    {
        return start;
    }
    /**
     * TODO: Comment
     * @param start the start to set
     */
    public void setStart(GMNode start)
    {
        this.start = start;
    }
    /**
     * TODO: Comment
     * @return the end
     */
    public GMNode getEnd()
    {
        return end;
    }
    /**
     * TODO: Comment
     * @param end the end to set
     */
    public void setEnd(GMNode end)
    {
        this.end = end;
    }
    /**
     * TODO: Comment
     * @return the direction
     */
    public Direction getDirection()
    {
        return direction;
    }
    /**
     * TODO: Comment
     * @param direction the direction to set
     */
    public void setDirection(Direction direction)
    {
        this.direction = direction;
    }
    /**
     * TODO: Comment
     * @return the timeDistance
     */
    public long getTimeDistance()
    {
        return timeDistance;
    }
    /**
     * TODO: Comment
     * @param timeDistance the timeDistance to set
     */
    public void setTimeDistance(long timeDistance)
    {
        this.timeDistance = timeDistance;
    }
    //== OTHER METHODS =============================================================
}
