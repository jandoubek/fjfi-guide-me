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

public class Edge
{
//== CLASS CONSTANTS ===========================================================
//== CLASS VARIABLES ===========================================================
//== INSTANCE VARIABLES ========================================================
	private UUID guid;
	private String name;
	private long timeDistance;
	private Node start;
	private Node end;
	private Direction direction;
	private String description;
	private Map myMap;
	private List<Location> locations;
//==============================================================================
//== CONSTRUCTORS ==============================================================
    
    /***************************************************************************
     * TODO: comment
     */
    //TODO: constructor parameters and body
    public Edge(UUID guid, String name, long timeDistance, Node start, Node end, Direction direction,
    			String description, Map myMap, List<Location> locations)
    {
    	this.guid = guid;
    	this.name = name;
    	this.timeDistance = timeDistance;
    	this.start = start;
    	this.end = end;
    	this.direction = direction;
    	this.description = description;
    	this.myMap = myMap;
    	this.locations = locations;
    }
    
//== GETTERS AND SETTERS =======================================================
    
    /***************************************************************************
     * TODO: comment
     */
    //TODO: body
    public final UUID getGUID(){return this.guid;}
    
    /***************************************************************************
     * TODO: comment
     */
    //TODO: body
    public final String getName(){return this.name;}
    
    /***************************************************************************
     * TODO: comment
     */
    //TODO: body
    public final long getTimeDistance(){return this.timeDistance;}
    
    /***************************************************************************
     * TODO: comment
     */
    //TODO: body
    public final Node getStart(){return this.start;}
    
    /***************************************************************************
     * TODO: comment
     */
    //TODO: body
    public final Node getEnd(){return this.end;}
    
    /***************************************************************************
     * TODO: comment
     */
    //TODO: body
    public final Direction getDirection(){return this.direction;}
    
    /***************************************************************************
     * TODO: comment
     */
    //TODO: body
    public final String getDescription(){return this.description;}
    
    /***************************************************************************
     * TODO: comment
     */
    //TODO: body
    protected final Map getMyMap(){return this.myMap;}
    
    /***************************************************************************
     * TODO: comment
     */
    //TODO: body
    public final void setGUID(UUID newGUID){this.guid = newGUID;}
    
    /***************************************************************************
     * TODO: comment
     */
    //TODO: body
    public final void setName(String newName){this.name = newName;}
    
    /***************************************************************************
     * TODO: comment
     */
    //TODO: body
    public final void setTimeDistance(long newTimeDistance){this.timeDistance = newTimeDistance;}
    
    /***************************************************************************
     * TODO: comment
     */
    //TODO: body
    public final void setStart(Node newStart){this.start = newStart;}
    
    /***************************************************************************
     * TODO: comment
     */
    //TODO: body
    public final void setEnd(Node newEnd){this.end = newEnd;}
    
    /***************************************************************************
     * TODO: comment
     */
    //TODO: body
    public final void setDirection(Direction newDirection){this.direction = newDirection;}
    
    /***************************************************************************
     * TODO: comment
     */
    //TODO: body
    public final void setDescription(String newDescription){this.description = newDescription;}
    
//== OTHER METHODS =============================================================
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
