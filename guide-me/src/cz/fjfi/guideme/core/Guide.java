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
        if (getCurrentMap() != route.getMap())
        {
            throw new IllegalArgumentException("The route is not on the current map");
        }
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
     * finds the shortest route through the nodes in the list
     */
    public final Route findRouteBetween(List<GMNode> nodes)
    {
        checkForMap("findRouteBetween called before setMap");
        if (nodes.size() < 2)
        {
            throw new IllegalArgumentException("Fewer than two nodes");
        }
        for (GMNode n : nodes)
        {
            if (getCurrentMap() != n.getMyMap())
            {
                throw new IllegalArgumentException("Found node from a different map");
            }
        }
        return Pathfinder.findRouteBetween(map, nodes);
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
    public final void goToNextLeg(long time)
    {
        checkForNavigator("goToNextLeg called before setRoute");
        navigator.goToNextLeg(time);
    }
    
    /**
     * moves navigation back to the previous point
     */
    public final void goToPreviousLeg(long time)
    {
        checkForNavigator("goToPreviousLeg called before setRoute");
        navigator.goToPreviousLeg(time);
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
