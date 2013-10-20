
package cz.fjfi.guideme.core;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
	public UUID getGuid() {
		//return guid;
		return this.guid;
	}	

    /***************************************************************************
    * Getter of name of the map
    */
    public String getName()
    {
    	return this.name;
    }
    
    /***************************************************************************
    * Getter of name of the map author  
    */
    public String getAuthorName()
    {
    	return this.authorName;
    }
    
    /***************************************************************************
    * Getter of email of the map author 
    */
    public String getAuthorEmail()
    {
    	return this.authorEmail;
    }
    
    /***************************************************************************
    * Getter of description of the map
    */
    public String getDescription()
    {
    	return this.getDescription();
    }
    
    /***************************************************************************
    * Getter for a nodes
    */ 
	public List<Node> getNodes() {
		return this.mappedNodes;
	}
	
	/***************************************************************************
	* Getter for a locations
	*/ 
	public List<Location> getLocations() {
		return this.mappedLocations;
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
      
     //============================================================================== 
     //== OTHER METHODS =============================================================
    
    /***************************************************************************
    * TODO: comment
    */
    //TODO: body
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
    public final void addNode(Node newNode)
    {
    	this.mappedNodes.add(newNode);
    }
    
    /***************************************************************************
    * Add a new single edge to the map (between two nodes)
    */
    public final void addEdge(Edge newEdge)
    {
    	this.mappedEdges.add(newEdge);
    }
    
    /***************************************************************************
    * Add a new location to the map
    */
    public final void addLocation(Location newLocation)
    {
    	this.mappedLocations.add(newLocation);
    }
    
	public void exportXML(File outputFile)
	{
		String output = new String("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
									+ "<map guid=\"" + this.getGuid() + "\">"
									+ "<name>" + this.getName() + "</name>\n"
									+ "<author name=\"" + this.getAuthorName() + "\" email=\"" + this.getAuthorEmail() + "\" />\n"
									+ "<description>" + this.getDescription() + "</description>\n"
									+ "<nodelist>\n");
		for(Node node:this.mappedNodes)
		{
			output = output.concat(node.exportXML());
		}
		output.concat("</nodelist>\n<edgelist>\n");
		
		for(Edge edge:this.mappedEdges)
		{
			output = output.concat(edge.exportXML());
		}
		output.concat("</edgelist>\n<locationlist>\n");
		
		for(Location loc:this.mappedLocations)
		{
			output = output.concat(loc.exportXML());
		}
		output.concat("</locationlist>\n</map>\n");
		
		System.out.print(output);
		PrintWriter out;
		try {
			out = new PrintWriter(new FileWriter(outputFile));
			out.print(output);
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
      
