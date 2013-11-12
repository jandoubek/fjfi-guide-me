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
    private int length;
    
    //==============================================================================
    //== CONSTRUCTORS ==============================================================
    
    RouteSegment (List<GMEdge> edges)
    {
        this.start = edges.get(0).getStart();
        this.end = edges.get(edges.size()-1).getEnd();
        this.direction = edges.get(0).getDirection();
        this.timeDistance = 0;
        for (GMEdge e : edges)
        {
            this.timeDistance += e.getTimeDistance();
        }
        this.length = edges.size();
    }
    //== GETTERS AND SETTERS =======================================================

    /**
     * returns the beginning node of the segment
     * @return the start
     */
    public GMNode getStart()
    {
        return start;
    }
    /**
     * returns the final node of the segment
     * @return the end
     */
    public GMNode getEnd()
    {
        return end;
    }
    /**
     * returns the direction of the segment
     * @return the direction
     */
    public Direction getDirection()
    {
        return direction;
    }
    /**
     * returns the total time/distance of the segment
     * @return the timeDistance
     */
    public long getTimeDistance()
    {
        return timeDistance;
    }
    
    /**
     * returns the number of edges in the segment
     * @return number of edges
     */
    public int getLength() {
		return length;
	}
}
