package cz.fjfi.guideme.core;
import java.util.*;

/**
 * This class represents map of GuideMe app. It provides getter and setters for
 * its attributes and basic methods for its creation.
 * @author 
 * @version
 */
public class Map 
{
//== CLASS CONSTANTS ===========================================================
//== CLASS VARIABLES ===========================================================
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
    public Map(){}
    
//== GETTERS AND SETTERS =======================================================
    
    /***************************************************************************
     * TODO: comment
     */
    //TODO: body
    public UUID getGUID(){return null;}
    
    /***************************************************************************
     * TODO: comment
     */
    //TODO: body
    public String getName(){return "";}
    
    /***************************************************************************
     * TODO: comment
     */
    //TODO: body
    public String getAuthorName(){return "";}
    
    /***************************************************************************
     * TODO: comment
     */
    //TODO: body
    public String getAuthosEmail(){return "";}
    
    /***************************************************************************
     * TODO: comment
     */
    //TODO: body
    public String getDescription(){return "";}
    
    /***************************************************************************
     * TODO: comment
     */
    //TODO: body
    public void setGUID(UUID newGUID){}
    
    /***************************************************************************
     * TODO: comment
     */
    //TODO: body
    public void setName(String newName){}
    
    /***************************************************************************
     * TODO: comment
     */
    //TODO: body
    public void setAuthorName(String newAuthorName){}
    
    /***************************************************************************
     * TODO: comment
     */
    //TODO: body
    public void setAuthorEmail(String newAuthorEmail){}
    
    /***************************************************************************
     * TODO: comment
     */
    //TODO: body
    public void setDescription(String newDescription){}
     
//== OTHER METHODS =============================================================
    
     /***************************************************************************
     * TODO: comment
     */
    //TODO: body
    public final UUID generateGUID(){return UUID.randomUUID();}

    public List<Node> getNeighborsOf(Node node) {
        List<Node> neighbors = new ArrayList<Node>();
        List<Edge> outwardEdges = getEdgesStartingIn(node);
        for (Edge e : outwardEdges) {
            neighbors.add(e.getEnd());
        }
        return neighbors;
    }
    
    public List<Edge> getEdgesStartingIn(Node start) {
        List<Edge> edges = new ArrayList<Edge>();
        for (Edge e : this.mappedEdges) {
            if (e.getStart() == start) {
                edges.add(e);
            }
        }
        return edges;
    }

}
