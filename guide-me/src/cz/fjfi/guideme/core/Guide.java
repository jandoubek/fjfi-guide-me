package cz.fjfi.guideme.core;

/**
 * This class contains the pathfinding and navigation logic of the GuideMe app.
 * @author 
 * @version
 */
public class Guide 
{
//== CLASS CONSTANTS ===========================================================
//== CLASS VARIABLES ===========================================================
//== INSTANCE VARIABLES ========================================================

    private Map map;

//==============================================================================
//== CONSTRUCTORS ==============================================================
    
    /***************************************************************************
     * TODO: comment
     */
    //TODO: constructor parameters and body
    public Guide(Map map){}
    
//== GETTERS AND SETTERS =======================================================
//== OTHER METHODS =============================================================
    
     /***************************************************************************
     * TODO: comment
     */
    //TODO: body
    public final String getCurrentLabel(long time){return "";}

    /***************************************************************************
    * TODO: comment
    */
    //TODO: body
    public final List<Node> findRouteBetween(Node from, Node to){return new List();}

    /***************************************************************************
    * TODO: comment
    */
    //TODO: body
    public final List<Node> findRouteBetween(Node from, Node to, List<Node> through){return new List();}
}
