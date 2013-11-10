package cz.fjfi.guideme.core;

import java.util.*;

/**
 * This class represents a "rough" edge on the route, used to generate instructions
 * @author Martin Sochor
 *
 */
public class RouteSegment
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
    
    public RouteSegment (List<GMEdge> edges)
    {
        this.start = edges.get(0).getStart();
        this.end = edges.get(edges.size()-1).getEnd();
        this.direction = edges.get(0).getDirection();
        this.timeDistance = 0;
        for (GMEdge e : edges)
        {
            this.timeDistance += e.getTimeDistance();
        }
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
}
