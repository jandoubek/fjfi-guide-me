package cz.fjfi.guideme.core.guideinternals;

import java.util.*;

import cz.fjfi.guideme.core.GMEdge;
import cz.fjfi.guideme.core.GMMap;
import cz.fjfi.guideme.core.GMNode;
import cz.fjfi.guideme.core.Route;

/**
 * This class contains the pathfinding logic for the GuideMe app.
 * @author Martin Sochor
 *
 */
public class Pathfinder
{
//== CLASS CONSTANTS ===========================================================
//== CLASS VARIABLES ===========================================================
//== INSTANCE VARIABLES ========================================================
	
    private GMMap map;
    private Map<GMNode, Long> distances;
    private Map<GMNode, GMEdge> previous;
    private Set<GMNode> openSet;
    
//==============================================================================
//== CONSTRUCTORS ==============================================================
    
    private Pathfinder(GMMap map)
    {
        this.map = map;
        reset();
    }
    
  //== GETTERS AND SETTERS =======================================================
  //== OTHER METHODS ============================================================= 

   
    /**
     * finds the shortest route through nodes in the list 'nodes'
     */
    public static final Route findRouteBetween(GMMap map, List<GMNode> nodes)
    {
        Pathfinder finder = new Pathfinder(map);
        ListIterator<GMNode> throughIterator = nodes.listIterator();
        GMNode currentStart = throughIterator.next();
        GMNode currentEnd = currentStart;
        List<GMEdge> route = new ArrayList<GMEdge>();
        while (throughIterator.hasNext())
        {
            currentStart = currentEnd;
            currentEnd = throughIterator.next();
            route.addAll(finder.findEdgeListBetween(currentStart, currentEnd));
        }
        return new Route(route);
    }
    
    /**
     * finds the edges in the shortest path between nodes 'from' and 'to'
     */
    private List<GMEdge> findEdgeListBetween(GMNode from, GMNode to)
    {
        initializeDistances(from);
        
        while (!openSet.isEmpty())
        {
            GMNode closestOpenNode = getClosestOpenNode();
            openSet.remove(closestOpenNode);
            
            if (closestOpenNode == to)
            {
                break; // reached target, end search
            }

            long distanceToClosestNode = distances.get(closestOpenNode);
            if (distanceToClosestNode == Long.MAX_VALUE)
            {
                throw new IllegalArgumentException("No route exists.");
            }
            
            updatePaths(closestOpenNode);
        }

        return constructRoute(from, to);
    }
    
    private void reset()
    {
        previous = new HashMap<GMNode, GMEdge>();
        openSet = new HashSet<GMNode>(map.getNodes()); 
    }

    /**
     * initialize the distances array
     */
    private void initializeDistances(GMNode from)
    {
        distances = new HashMap<GMNode, Long>();
        for (GMNode n : map.getNodes())
        {
            distances.put(n, Long.MAX_VALUE);
        }
        distances.put(from, Long.valueOf(0));      
    }

    /**
     * find the node in openSet with lowest distance
     */
    private GMNode getClosestOpenNode()
    {
        long minDistance = Long.MAX_VALUE;
        GMNode closestOpenNode = openSet.iterator().next();
        for (GMNode n : openSet)
        {
            long currentDistance = distances.get(n);
            if (currentDistance < minDistance)
            {
                minDistance = currentDistance;
                closestOpenNode = n;
            }
        }
        return closestOpenNode;
    }

    /**
     * update the distances and previous arrays if necessary
     */
    private void updatePaths(GMNode closestOpenNode)
    {
        long distanceToClosestNode = distances.get(closestOpenNode);
        List<GMNode> neighbors = map.getNeighborsOf(closestOpenNode);
        for (GMNode n : neighbors)
        {
            if (openSet.contains(n))
            {
                updatePathFor(n, closestOpenNode, distanceToClosestNode);
            }
        }        
    }

    /**
     * update the distance and previous arrays for node 'n' if necessary
     */
    private void updatePathFor(GMNode n, GMNode closestOpenNode,
            long distanceToClosestNode)
    {
        GMEdge connectingEdge = map.getEdgeConnectingNodes(closestOpenNode, n);
        long newDistance = distanceToClosestNode + connectingEdge.getTimeDistance();
        if (newDistance < distances.get(n))
        {
            distances.put(n, newDistance);
            previous.put(n, connectingEdge);
        }
    }

    /**
     * construct the route from the distance and previous arrays
     */
    private List<GMEdge> constructRoute(GMNode from, GMNode to)
    {
        List<GMEdge> route = new ArrayList<GMEdge>();
        GMNode currentNode = to;
        while (currentNode != from)
        {
            GMEdge currentEdge = previous.get(currentNode);
            currentNode = currentEdge.getStart();
            route.add(currentEdge);
        }
        Collections.reverse(route);
        return route;
    }
}
