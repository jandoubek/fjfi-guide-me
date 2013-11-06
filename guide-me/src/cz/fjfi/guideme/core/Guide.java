package cz.fjfi.guideme.core;

import java.util.*;
import cz.fjfi.guideme.core.guideinternals.*;

/**
 * This class contains the pathfinding and navigation interface for the GuideMe app.
 * @author Martin Sochor
 * @version
 */
public class Guide 
{
//== CLASS CONSTANTS ===========================================================
//== CLASS VARIABLES ===========================================================
    
    private static class SingletonHolder {
        public static final Guide INSTANCE = new Guide();
    }
    
//== INSTANCE VARIABLES ========================================================

    private GMMap map = null;
    private Navigator navigator = null;

//==============================================================================
//== CONSTRUCTORS ==============================================================
    
    /***************************************************************************
     * TODO: comment
     */
    //TODO: constructor parameters and body
    private Guide()
    {
    }
    
//== GETTERS AND SETTERS =======================================================

    /**
     * returns the singleton instance of Guide
     */
    public static final Guide getInstance()
    {
        return SingletonHolder.INSTANCE;
    }
    
    /**
     * returns the map Guide operates on
     */
    public final GMMap getCurrentMap()
    {
        if (map == null)
        {
            throw new IllegalStateException("getCurrentMap called before setMap");
        }
        return map;
    }

    /**
     * sets the map for Guide to operate on
     */
    public final void setMap(GMMap map)
    {
        this.map = map;
        this.navigator = null;
    }
    
    public final void setRoute(Route route)
    {
        if (map == null)
        {
            throw new IllegalStateException("setRoute called before setMap");
        }
        navigator = new Navigator(route);
    }
    
    public final Route getCurrentRoute()
    {
        if (navigator == null)
        {
            throw new IllegalStateException("getCurrentRoute called before setRoute");
        }
        return navigator.getRoute();
    }
    
//== OTHER METHODS =============================================================
    
    /***************************************************************************
    * returns navigation instructions given elapsed time
    * takes a Navigator parameter due to temporal coupling
     * beginNavigation has to be called before this method
    */
    public final String getCurrentLabel(long time)
    {
    	if (navigator == null)
    	{
			throw new IllegalStateException("getCurrentLabel called before setRoute");
		}
        return navigator.getCurrentLabel(time);
    }

    /***************************************************************************
    * finds the shortest route between nodes 'from' and 'to'
    */
    public final Route findRouteBetween(GMNode from, GMNode to)
    {
        if (map == null)
        {
            throw new IllegalStateException("findRouteBetween called before setMap");
        }
        return Pathfinder.findRouteBetween(map, from, to);
    }

    /***************************************************************************
    * finds the shortest route between nodes 'from' and 'to', passing through all nodes contained in 'through'
    */
    public final Route findRouteBetween(GMNode from, GMNode to, List<GMNode> through)
    {
        if (map == null)
        {
            throw new IllegalStateException("findRouteBetween called before setMap");
        }
        return Pathfinder.findRouteBetween(map, from, to, through);
    }

}
