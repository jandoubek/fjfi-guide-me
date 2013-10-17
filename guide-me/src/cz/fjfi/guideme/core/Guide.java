package cz.fjfi.guideme.core;

import java.util.*;

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
    * finds the shortest route between nodes 'from' and 'to'
    * returns an empty list if no route exists
    */
    public final List<Node> findRouteBetween(Node from, Node to) {
        // initialize
        List<Node> route = new ArrayList<Node>();
        
        // distances set to infinity, except for start, which is set to 0
        java.util.Map<Node, Long> distances = new HashMap<Node, Long>();
        for (Node n : map.getNodes()) {
            distances.put(n, Long.MAX_VALUE);
        }
        distances.put(from, Long.valueOf(0));
        
        // previous node on the shortest discovered path
        java.util.Map<Node, Node> previous = new HashMap<Node, Node>();
        
        // nodes not yet visited
        Set<Node> openSet = new HashSet<Node>(map.getNodes());
        
        while (!openSet.isEmpty()) {
            // find closest node not yet visited
            long minDistance = Long.MAX_VALUE;
            Node closestOpenNode = from;
            for (Node n : openSet) {
                long currentDistance = distances.get(n);
                if (minDistance < currentDistance) {
                    minDistance = currentDistance;
                    closestOpenNode = n;
                }
            }
            if (closestOpenNode == to) {
                break; // reached target, end search
            }
            openSet.remove(closestOpenNode);

            long distanceToClosestNode = minDistance;
            if (distanceToClosestNode == Long.MAX_VALUE) {
                return route; // no route exists, returns empty list
                // TODO: throw a proper exception
            }
            
            // update distances and previous for all neighbors
            List<Node> neighbors = map.getNeighborsOf(closestOpenNode);
            for (Node n : neighbors) {
                if (openSet.contains(n)) {
                    Edge connectingEdge = map.getEdgeConnectingNodes(closestOpenNode, n);
                    long newDistance = distanceToClosestNode + connectingEdge.getTimeDistance();
                    if (newDistance < distances.get(n)) {
                        distances.put(n, newDistance);
                        previous.put(n, closestOpenNode);
                    }
                }
            }
        }
        
        // construct the route
        Node currentNode = to;
        route.add(currentNode);
        while (currentNode != from) {
            currentNode = previous.get(currentNode);
            route.add(currentNode);
        }
        Collections.reverse(route);

        return route;
    }

    /***************************************************************************
    * finds the shortest route between nodes 'from' and 'to', passing through all nodes contained in 'through'
    */
    public final List<Node> findRouteBetween(Node from, Node to, List<Node> through) {
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
