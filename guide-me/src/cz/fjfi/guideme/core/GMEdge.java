package cz.fjfi.guideme.core;

import java.util.List;
import java.util.UUID;

/**
 * This class represents simple edge from one node to another in GuideMe map. It
 * provides getters and setters for it attributes.
 * 
 * @author
 * @version
 */

public class GMEdge
{
//== CLASS CONSTANTS ===========================================================
//== CLASS VARIABLES ===========================================================
//== INSTANCE VARIABLES ========================================================
	private UUID guid;
	private String name;
	private long timeDistance;
	private GMNode start;
	private GMNode end;
	private Direction direction;
	private String description;
	private GMMap myMap;
	
//==============================================================================
//== CONSTRUCTORS ==============================================================
    
    /***************************************************************************
     * TODO: comment
     */
    //TODO: constructor parameters and body
    public GMEdge(UUID guid, String name, long timeDistance, GMNode start, GMNode end, Direction direction,
    			String description, GMMap myMap)
    {
    	this.guid = guid;
    	this.name = name;
    	this.timeDistance = timeDistance;
    	this.start = start;
    	this.end = end;
    	this.direction = direction;
    	this.description = description;
    	this.myMap = myMap;
    }
    
//== GETTERS AND SETTERS =======================================================
    
    /***************************************************************************
     * Getter of guid
     */
    public final UUID getGUID()
    {
        return this.guid;
    }
    
    /***************************************************************************
     * Getter of name
     */
    public final String getName()
    {
    	return this.name;
    }
    
    /***************************************************************************
     * Getter of time distance
     */
    public final long getTimeDistance()
    {
    	return this.timeDistance;
    }
    
    /***************************************************************************
     * Getter of starting Node
     */
    public final GMNode getStart()
    {
    	return this.start;
    }
    
    /***************************************************************************
     * Getter of ending Node
     */
    public final GMNode getEnd()
    {
    	return this.end;
    }
    
    /***************************************************************************
     * Getter of edge direction
     */
    public final Direction getDirection()
    {
    	return this.direction;
    }
    
    /***************************************************************************
     * Getter of description
     */
    public final String getDescription()
    {return this.description;
    }
    
    /***************************************************************************
     * Getter of map
     */
    final GMMap getMyMap()
    {
    	return this.myMap;
    }
    
    /***************************************************************************
     * Setter of guid
     */
    public final void setGUID(UUID newGUID)
    {
    	this.guid = newGUID;
    }
    
    /***************************************************************************
     * Setter of name
     */
    public final void setName(String newName)
    {
    	this.name = newName;
    }
    
    /***************************************************************************
     * Setter of time distance
     */
    public final void setTimeDistance(long newTimeDistance)
    {
    	this.timeDistance = newTimeDistance;
    }
    
    /***************************************************************************
     * Setter of start Node
     */
    public final void setStart(GMNode newStart)
    {
    	this.start = newStart;
    }
    
    /***************************************************************************
     * Setter of end Node
     */
    public final void setEnd(GMNode newEnd)
    {
    	this.end = newEnd;
    }
    
    /***************************************************************************
     * Setter of direction
     */
    public final void setDirection(Direction newDirection)
    {
    	this.direction = newDirection;
    }
    
    /***************************************************************************
     * Setter of description
     */
    public final void setDescription(String newDescription)
    {
    	this.description = newDescription;
    }
    
//== OTHER METHODS =============================================================
    /***************************************************************************
     * Function for exporting all Edge parameters into XML format
     */
    public String exportXML()
    {
    	return new String("<edge guid=\"" + this.getGUID() + "\">\n"
    						+ "<name>" + this.getName() + "</name>\n" 
    						+ "<distance time=\"" + this.getTimeDistance() + "\" />\n"
    						+ "<start guid=\"" + this.getStart().getGUID() + "\" />\n" 
    						+ "<end guid=\"" + this.getEnd().getGUID() + "\" />\n"
    						+ "<direction>" + this.getDirection() + "</direction>\n"
    				//		+ "<location guid=\">" + this.getLocation().getGUID() + "\"/>\n"
    						+ "<desc>" + this.getDescription() + "</desc>\n"
    						+ "</edge>\n");
    }
    
}
