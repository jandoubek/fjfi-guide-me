package cz.fjfi.guideme.core;

import java.util.List;
import java.util.NoSuchElementException;

/***
 * This class allows iteration over Route
 * @author Martin Sochor
 *
 */

public class RouteIterator
{
//== CLASS CONSTANTS ===========================================================
//== CLASS VARIABLES ===========================================================
//== INSTANCE VARIABLES ========================================================
	
	private List<RouteItem> route;
	private int cursor = 0;
	private int lastEdgeRet = -1;
	private int lastLegRet = -1;
    
//==============================================================================
//== CONSTRUCTORS ==============================================================
    
    RouteIterator(List<RouteItem> route)
    {
    	this.route = route;
    }
    
    RouteIterator(List<RouteItem> route, int index)
    {
    	this.route = route;
    	this.cursor = index;
    }

    /**
     * creates a deep copy of the iterator
     * @return a copy of the iterator
     */
    public RouteIterator copy()
    {
    	RouteIterator iterator = new RouteIterator(route, cursor);
    	iterator.lastEdgeRet = lastEdgeRet;
    	iterator.lastLegRet = lastLegRet;
    	return iterator;
    }

//== GETTERS AND SETTERS =======================================================
//== OTHER METHODS =============================================================
    
    /**
     * checks if there is a next element in the route
     * @return boolean indicating if there is a next element
     */
    public boolean hasNext()
    {
        return cursor != route.size();
    }

    /**
     * checks if there is a previous element in the route
     * @return boolean indicating if there is a previous element
     */
    public boolean hasPrevious()
    {
        return cursor != 0;
    }

    /**
     * returns the next element in the route and advances the iterator
     * @return the next element
     */
    public GMEdge next()
    {
    	try
    	{
    		GMEdge next = route.get(cursor).getEdge();
    		lastEdgeRet = lastLegRet = cursor++;
    		return next;
    	}
    	catch (IndexOutOfBoundsException e)
    	{
    		throw new NoSuchElementException();
    	}
    }

    /**
     * returns the index of the next element in the route
     * @return index of the next element
     */
    public int nextIndex()
    {
        return cursor;
    }

    /**
     * returns the previous element in the route and moves the iterator backwards
     * @return the previous element
     */
    public GMEdge previous()
    {
    	try
    	{
    		int i = cursor - 1;
    		GMEdge previous = route.get(i).getEdge();
    		lastEdgeRet = lastLegRet = cursor = i;
    		return previous;
    	}
    	catch (IndexOutOfBoundsException e)
    	{
    		throw new NoSuchElementException();
    	}
    }

    /**
     * returns the index of the previous element
     * @return the index of the previous element
     */
    public int previousIndex()
    {
        return cursor - 1;
    }
    
    /**
     * returns the element returned by the most recent call to next() or previous()
     * @return the most recently returned element
     */
    public GMEdge get()
    {
    	try
    	{
    		return route.get(lastEdgeRet).getEdge();
    	}
    	catch (IndexOutOfBoundsException e)
    	{
    		throw new NoSuchElementException();
    	}
    }
    
    /**
     * checks if there is a next leg in the route
     * @return boolean indicating if there is a next leg
     */
    public boolean hasNextLeg()
    {
    	return nextLegIndex() < route.size();
    }
    
    /**
     * checks if there is a previous leg in the route
     * @return boolean indicating if there is a previous leg
     */
    public boolean hasPreviousLeg()
    {
    	return previousLegIndex() >= 0;
    }
    
    /**
     * returns the next leg in the route and advances the iterator to it
     * @return the next leg
     */
    public RouteLeg nextLeg()
    {
    	try
    	{
            cursor = nextLegIndex();
    		RouteLeg next = route.get(cursor).getLeg();
    		lastEdgeRet = cursor - 1;
    		lastLegRet = cursor;
    		return next;
    	}
    	catch (IndexOutOfBoundsException e)
    	{
    		throw new NoSuchElementException();
    	}
    }
    
    /**
     * returns the index of the first edge in the next leg in the route
     * @return index of the next leg
     */
    public int nextLegIndex()
    {
    	try
    	{
    		RouteItem edge = route.get(lastLegRet);
    		int distance = edge.getLeg().getLength() - edge.getLegIndex();
    		return lastLegRet + distance;
    	}
    	catch (IndexOutOfBoundsException e)
    	{
    		throw new IllegalStateException();
    	}
    }
    
    /**
     * returns the previous leg in the route and moves the iterator back to it
     * @return the previous leg
     */
    public RouteLeg previousLeg()
    {
    	try
    	{
        	int i = previousLegIndex();
        	RouteLeg previous = route.get(i).getLeg();
        	lastEdgeRet = lastLegRet = cursor = i;
        	return previous;
    	}
    	catch (IndexOutOfBoundsException e)
    	{
    		throw new NoSuchElementException();
    	}
    }
    
    /**
     * returns the index of the first edge of the previous leg in the route
     * @return index of the previous leg
     */
    public int previousLegIndex()
    {
    	try
    	{
    		RouteItem edge = route.get(lastLegRet);
    		int distance = edge.getLegIndex();
    		if (lastLegRet - distance == 0)
    		{
    		    return -1;
    		}
    		else
    		{
    		    edge = route.get(lastLegRet - distance - 1);
    		    distance += edge.getLeg().getLength();
    		    return lastLegRet - distance;
    		}
    	}
    	catch (IndexOutOfBoundsException e)
    	{
    		throw new IllegalStateException();
    	}
    }
    
    /**
     * returns the leg returned by the most recent call to nextLeg() or previousLeg()
     * @return the most recently returned leg
     */
    public RouteLeg getLeg()
    {
    	try
    	{
    		return route.get(lastLegRet).getLeg();
    	}
    	catch (IndexOutOfBoundsException e)
    	{
    		throw new NoSuchElementException();
    	}
    }

}