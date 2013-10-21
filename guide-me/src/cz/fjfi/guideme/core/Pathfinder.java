package cz.fjfi.guideme.core;

import java.util.*;

/**
 * This class contains the pathfinding logic for the GuideMe app.
 * @author Martin Sochor
 *
 */
public class Pathfinder {
    private Map map;
    private java.util.Map<Node, Long> distances;
    private java.util.Map<Node, Edge> previous;
    private Set<Node> openSet;
    
    public Pathfinder(Map map)
    {
        this.map = map;
        reset();
    }

    /**
     * finds the shortest route between nodes 'from' and 'to'
     */
    public final Route findRouteBetween(Node from, Node to)
    {
        return new Route(findEdgeListBetween(from, to));
    }
    
    /**
     * finds the shortest route between nodes 'from' and 'to' passing through all nodes contained in 'through'
     */
    public final Route findRouteBetween(Node from, Node to, List<Node> through)
    {
        ListIterator<Node> throughIterator = through.listIterator();
        Node currentStart = from;
        Node currentEnd = throughIterator.next();
        List<Edge> route = findEdgeListBetween(currentStart, currentEnd);
        while (throughIterator.hasNext())
        {
            currentStart = currentEnd;
            currentEnd = throughIterator.next();
            route.addAll(findEdgeListBetween(currentStart, currentEnd));
        }
        route.addAll(findEdgeListBetween(currentEnd,to));
        return new Route(route);
    }
    
    /**
     * finds the edges in the shortest path between nodes 'from' and 'to'
     */
    private List<Edge> findEdgeListBetween(Node from, Node to)
    {
        initializeDistances(from);
        
        while (!openSet.isEmpty())
        {
            Node closestOpenNode = getClosestOpenNode();
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
        previous = new HashMap<Node, Edge>();
        openSet = new HashSet<Node>(map.getNodes()); 
    }

    /**
     * initialize the distances array
     */
    private void initializeDistances(Node from)
    {
        distances = new HashMap<Node, Long>();
        for (Node n : map.getNodes())
        {
            distances.put(n, Long.MAX_VALUE);
        }
        distances.put(from, Long.valueOf(0));      
    }

    /**
     * find the node in openSet with lowest distance
     */
    private Node getClosestOpenNode()
    {
        long minDistance = Long.MAX_VALUE;
        Node closestOpenNode = openSet.iterator().next();
        for (Node n : openSet)
        {
            long currentDistance = distances.get(n);
            if (minDistance < currentDistance)
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
    private void updatePaths(Node closestOpenNode)
    {
        long distanceToClosestNode = distances.get(closestOpenNode);
        List<Node> neighbors = map.getNeighborsOf(closestOpenNode);
        for (Node n : neighbors)
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
    private void updatePathFor(Node n, Node closestOpenNode,
            long distanceToClosestNode)
    {
        Edge connectingEdge = map.getEdgeConnectingNodes(closestOpenNode, n);
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
    private List<Edge> constructRoute(Node from, Node to)
    {
        List<Edge> route = new ArrayList<Edge>();
        Node currentNode = to;
        while (currentNode != from)
        {
            Edge currentEdge = previous.get(currentNode);
            currentNode = currentEdge.getStart();
            route.add(currentEdge);
        }
        Collections.reverse(route);
        return route;
    }
}
