
package cz.fjfi.guideme.core;
//import java.util.UUID;
import java.util.*;

/**
 * This class represents map of GuideMe app. It provides getter and setters for
 * its attributes and basic methods for its creation.
 * @author Petr Fort
 * @author Martin Sochor 
 * @version 
 */
public class Map 
{

    //== CLASS CONSTANTS ===========================================================
	 
    //== CLASS VARIABLES ===========================================================	
	private UUID guid;	
	private String name;
	private String authorName;
	private String authorEmail;
	private String description;	
	
	//== INSTANCE VARIABLES ========================================================
    private List<Node> mappedNodes;
    private List<Edge> mappedEdges;
    private List<Location> mappedLocations;
	
    //==============================================================================
    //== CONSTRUCTORS ==============================================================
    
    /***************************************************************************
     * TODO: comment
     */
    //TODO: constructor parameters and body
    public Map()
    {
    	
    }
    
    //==============================================================================
    //== GETTERS AND SETTERS =======================================================       
    
    /***************************************************************************
    // Getter of guid
    */
    // TODO: body
	public UUID getGuid() {
		//return guid;
		return null;
	}	

    /***************************************************************************
    * Getter of name of the map
    */
    //TODO: body
    public String getName()
    {
    	return "";
    }
    
    /***************************************************************************
    * Getter of name of the map author  
    */
    //TODO: body
    public String getAuthorName()
    {
    	return "";
    }
    
    /***************************************************************************
    * Getter of email of the map author 
    */
    //TODO: body
    public String getAuthorEmail()
    {
    	return "";
    }
    
    /***************************************************************************
    * Getter of description of the map
    */
    //TODO: body
    public String getDescription()
    {
    	return "";
    }

    /***************************************************************************
    * Setter for guid
    */
	public void setGuid(UUID newGUID)
    {
    	this.guid = newGUID;
    }
     
    /***************************************************************************
    * Setter for name of the map   
    */  
    public void setName(String newName)
    {
    	this.name = newName;
    }
     
    /***************************************************************************
    * Setter for name of author of the map  
    */
    public void setAuthorName(String newAuthorName)
    {
    	 this.authorName = newAuthorName;
    }
     
    /***************************************************************************
    * Setter for email of author of the map  
    */
    public void setAuthorEmail(String newAuthorEmail)
    {
    	this.authorEmail = newAuthorEmail;     	
    }
     
    /***************************************************************************
    * Setter for a description
    */
    public void setDescription(String newDescription)
    {
     	this.description = newDescription;    	
    }
     
    /***************************************************************************
    * Setter for a nodes
    */ 
	public List<Node> getNodes() {
		return this.mappedNodes;
	}
    
     //============================================================================== 
     //== OTHER METHODS =============================================================
    
    /***************************************************************************
    * TODO: comment
    */
    //TODO: body
	public final UUID generateGUID()
	{
    	return UUID.randomUUID();
    }

    public List<Node> getNeighborsOf(Node node)
    {
        List<Node> neighbors = new ArrayList<Node>();
        List<Edge> outwardEdges = getEdgesStartingIn(node);
        for (Edge e : outwardEdges) {
            neighbors.add(e.getEnd());
        }
        return neighbors;
    }
    
    public List<Edge> getEdgesStartingIn(Node start)
    {
        List<Edge> edges = new ArrayList<Edge>();
        for (Edge e : this.mappedEdges) {
            if (e.getStart() == start) {
                edges.add(e);
            }
        }
        return edges;
    }
    
    public Edge getEdgeConnectingNodes(Node from, Node to)
    {
        for (Edge e : this.mappedEdges) {
            if (e.getStart() == from && e.getEnd() == to) {
                return e;
            }
        }
        throw new IllegalArgumentException("Nodes are not connected.");
    }
    
    /***************************************************************************
    * Add a new single node to the map
    */
    //TODO: arguments, body
    public final boolean addNode()
    {
    	// if not success, then return false;
    	// (a nebo zmenit boolean na void, nevim co je lepsi)
    	return true;
    }
    
    /***************************************************************************
    * Add a new single edge to the map (between two nodes)
    */
    //TODO: arguments, body
    public final boolean addEdge()
    {
    	// if not success, then return false;
    	// (a nebo zmenit boolean na void, nevim co je lepsi)
    	return true;
    }
    
    /***************************************************************************
    * Add a new location to the map
    */
    //TODO: arguments, body
    public final boolean addLocation()
    {
    	// if not success, then return false;
    	// (a nebo zmenit boolean na void, nevim co je lepsi)    	
    	return true;
    }
    
}
      
