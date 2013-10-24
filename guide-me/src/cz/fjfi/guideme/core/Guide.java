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
        this.navigator = null;
    }
    
//== GETTERS AND SETTERS =======================================================
//== OTHER METHODS =============================================================
    
    /**
     * prepares the instance for navigation
     * has to be called before getCurrentLabel or getNextLabel
     */
    public final void beginNavigation(Route route)
    {
        navigator = new Navigator(route);
    }
    
    /***************************************************************************
    * returns navigation instructions given elapsed time
    * takes a Navigator parameter due to temporal coupling
     * beginNavigation has to be called before this method
    */
    public final String getCurrentLabel(long time)
    {
    	if (navigator == null) {
			throw new IllegalStateException("Guide.beginNavigation was not called before Guide.getCurrentLabel.");
		}
        return navigator.getCurrentLabel(time);
    }
    
    /**
     * skips to the next navigation instruction and returns it
     * beginNavigation has to be called before this method
     */
    public final String getNextLabel()
    {
    	if (navigator == null) {
			throw new IllegalStateException("Guide.beginNavigation was not called before Guide.getNextLabel.");
		}
        return navigator.getNextLabel();
    }

    /***************************************************************************
    * finds the shortest route between nodes 'from' and 'to'
    */
    public final Route findRouteBetween(GMNode from, GMNode to)
    {
        return Pathfinder.findRouteBetween(map, from, to);
    }

    /***************************************************************************
    * finds the shortest route between nodes 'from' and 'to', passing through all nodes contained in 'through'
    */
    public final Route findRouteBetween(GMNode from, GMNode to, List<GMNode> through)
    {
        return Pathfinder.findRouteBetween(map, from, to, through);
    }

    /**
     * returns the map Guide operates on
     */
    public final GMMap getMap()
    {
        return map;
    }
}
