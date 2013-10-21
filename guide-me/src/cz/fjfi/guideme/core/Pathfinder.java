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
    private java.util.Map<Node, Node> previous;
    private Set<Node> openSet;
    
    public Pathfinder(Map map)
    {
        this.map = map;
        this.distances = new HashMap<Node, Long>();
        this.previous = new HashMap<Node, Node>();
        this.openSet = new HashSet<Node>(map.getNodes()); 
    }
    
    /**
     * finds the shortest route between nodes 'from' and 'to'
     */
    public final List<Node> findRouteBetween(Node from, Node to)
    {
        initializeDistances(from);
        
        while (!openSet.isEmpty()) {
            Node closestOpenNode = getClosestOpenNode();
            openSet.remove(closestOpenNode);
            
            if (closestOpenNode == to) {
                break; // reached target, end search
            }

            long distanceToClosestNode = distances.get(closestOpenNode);
            if (distanceToClosestNode == Long.MAX_VALUE) {
                throw new IllegalArgumentException("No route exists.");
            }
            
            updatePaths(closestOpenNode);
        }

        return constructRoute(from, to);
    }

    /**
     * initialize the distances array
     */
    private void initializeDistances(Node from)
    {
        for (Node n : map.getNodes()) {
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
        for (Node n : openSet) {
            long currentDistance = distances.get(n);
            if (minDistance < currentDistance) {
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
        for (Node n : neighbors) {
            if (openSet.contains(n)) {
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
        if (newDistance < distances.get(n)) {
            distances.put(n, newDistance);
            previous.put(n, closestOpenNode);
        }
    }

    /**
     * construct the route from the distance and previous arrays
     */
    private List<Node> constructRoute(Node from, Node to)
    {
        List<Node> route = new ArrayList<Node>();
        Node currentNode = to;
        route.add(currentNode);
        while (currentNode != from) {
            currentNode = previous.get(currentNode);
            route.add(currentNode);
        }
        Collections.reverse(route);
        return route;
    }
}
