package cz.fjfi.guideme.core;

import java.util.*;

/**
 * This class contains the pathfinding and navigation interface for the GuideMe app.
 * @author Martin Sochor
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
    public Guide(Map map)
    {
        this.map = map;
    }
    
//== GETTERS AND SETTERS =======================================================
//== OTHER METHODS =============================================================
    
     /***************************************************************************
     * TODO: comment
     */
    //TODO: body
    public final String getCurrentLabel(long time){return "";}

    /***************************************************************************
    * finds the shortest route between nodes 'from' and 'to'
    * returns an empty list if no route exists
    */
    public final List<Node> findRouteBetween(Node from, Node to)
    {
        Pathfinder finder = new Pathfinder(map);
        return finder.findRouteBetween(from, to);
    }

    /***************************************************************************
    * finds the shortest route between nodes 'from' and 'to', passing through all nodes contained in 'through'
    */
    public final List<Node> findRouteBetween(Node from, Node to, List<Node> through)
    {
        ListIterator<Node> throughIterator = through.listIterator();
        Node currentStart = from;
        Node currentEnd = throughIterator.next();
        List<Node> route = findRouteBetween(currentStart, currentEnd);
        while (throughIterator.hasNext()) {
            route.remove(route.size() - 1);
            currentStart = currentEnd;
            currentEnd = throughIterator.next();
            route.addAll(findRouteBetween(currentStart, currentEnd));
        }
        route.remove(route.size() - 1);
        route.addAll(findRouteBetween(currentEnd,to));
        return route;
    }
}
