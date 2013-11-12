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
        checkForMap("getCurrentMap called before setMap");
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

    /**
     * sets the route to navigate on
     * @param route
     */
    public final void setRoute(Route route)
    {
        checkForMap("setRoute called before setMap");
        navigator = new Navigator(route);
    }
    
    /**
     * returns currently used route
     * @return
     */
    public final Route getCurrentRoute()
    {
        checkForNavigator("getCurrentRoute called before setRoute");
        return navigator.getRoute();
    }
    
    //== OTHER METHODS =============================================================
    
    /**
     * finds the shortest route between nodes 'from' and 'to'
     */
    public final Route findRouteBetween(GMNode from, GMNode to)
    {
        checkForMap("findRouteBetween called before setMap");
        return Pathfinder.findRouteBetween(map, from, to);
    }

    /**
     * finds the shortest route between nodes 'from' and 'to', passing through all nodes contained in 'through'
     */
    public final Route findRouteBetween(GMNode from, GMNode to, List<GMNode> through)
    {
        checkForMap("findRouteBetween called before setMap");
        return Pathfinder.findRouteBetween(map, from, to, through);
    }
    
    /**
     * returns navigation instructions given elapsed time
     */
    public final RoutePoint getCurrentRoutePoint(long time)
    {
        checkForNavigator("getCurrentRoutePoint called before setRoute");
        return navigator.getCurrentRoutePoint(time);
    }
    
    /**
     * advances navigation to the next point
     */
    public final void goToNextSegment(long time)
    {
        checkForNavigator("goToNextSegment called before setRoute");
        navigator.goToNextSegment(time);
    }
    
    /**
     * checks whether destination has been reached
     */
    public final boolean reachedDestination()
    {
        checkForNavigator("reachedDestination called before setRoute");
        return navigator.reachedEnd();
    }
    
    private final void checkForMap(String message)
    {
        if (map == null)
        {
            throw new IllegalStateException(message);
        }
    }
    
    private final void checkForNavigator(String message)
    {
        if (navigator == null)
        {
            throw new IllegalStateException(message);
        }
    }
}
