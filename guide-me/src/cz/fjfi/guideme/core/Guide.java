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

    private GMMap map;
    private Navigator navigator;

//==============================================================================
//== CONSTRUCTORS ==============================================================
    
    /***************************************************************************
     * TODO: comment
     */
    //TODO: constructor parameters and body
    public Guide(GMMap map)
    {
        this.map = map;
    }
    
//== GETTERS AND SETTERS =======================================================
//== OTHER METHODS =============================================================
    
    /**
     * prepares the instance for navigation
     */
    public final Navigator beginNavigation(Route route)
    {
        navigator = new Navigator(route);
        return navigator;
    }
    
    /***************************************************************************
    * returns navigation instructions given elapsed time
    * takes a Navigator parameter due to temporal coupling
    */
    public final String getCurrentLabel(Navigator nav, long time)
    {
        return navigator.getCurrentLabel(time);
    }
    
    /**
     * skips to the next navigation instruction and returns it
     * takes a Navigator parameter due to temporal coupling
     */
    public final String getNextLabel(Navigator nav)
    {
        return navigator.getNextLabel();
    }

    /***************************************************************************
    * finds the shortest route between nodes 'from' and 'to'
    */
    public final Route findRouteBetween(GMNode from, GMNode to)
    {
        Pathfinder finder = new Pathfinder(map);
        return finder.findRouteBetween(from, to);
    }

    /***************************************************************************
    * finds the shortest route between nodes 'from' and 'to', passing through all nodes contained in 'through'
    */
    public final Route findRouteBetween(GMNode from, GMNode to, List<GMNode> through)
    {
        Pathfinder finder = new Pathfinder(map);
        return finder.findRouteBetween(from, to, through);
    }

    /**
     * returns the map Guide operates on
     */
    public final GMMap getMap()
    {
        return map;
    }
}
