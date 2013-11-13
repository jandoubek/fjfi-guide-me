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
	private int lastRet = -1;
    
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
    	iterator.lastRet = lastRet;
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
    		lastRet = cursor++;
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
    		lastRet = cursor = i;
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
    		return route.get(lastRet).getEdge();
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
    		RouteLeg next = route.get(cursor).getLeg();
    		lastRet = cursor;
    		cursor = nextLegIndex();
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
    		RouteItem edge = route.get(lastRet);
    		int distance = edge.getLeg().getLength() - edge.getLegIndex();
    		return lastRet + distance;
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
        	lastRet = cursor = i;
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
    		RouteItem edge = route.get(cursor);
    		int distance = edge.getLegIndex();
    		return cursor - distance - 1;
    	}
    	catch (IndexOutOfBoundsException e)
    	{
    		throw new IllegalStateException();
    	}
    }
    
    /**
     * returns the leg returned by the most recent call to nextleg() or previousleg()
     * @return the most recently returned leg
     */
    public RouteLeg getLeg()
    {
    	try
    	{
    		return route.get(lastRet).getLeg();
    	}
    	catch (IndexOutOfBoundsException e)
    	{
    		throw new NoSuchElementException();
    	}
    }

}