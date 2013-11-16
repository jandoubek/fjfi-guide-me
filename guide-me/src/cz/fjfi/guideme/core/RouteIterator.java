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
	private int lastStretchRet = -1;
    
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
    	iterator.lastStretchRet = lastStretchRet;
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
    		lastEdgeRet = lastStretchRet = cursor++;
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
    		lastEdgeRet = lastStretchRet = cursor = i;
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
     * checks if there is a next stretch in the route
     * @return boolean indicating if there is a next stretch
     */
    public boolean hasNextStretch()
    {
    	return nextStretchIndex() < route.size();
    }
    
    /**
     * checks if there is a previous stretch in the route
     * @return boolean indicating if there is a previous stretch
     */
    public boolean hasPreviousStretch()
    {
    	return previousStretchIndex() >= 0;
    }
    
    /**
     * returns the next stretch in the route and advances the iterator to it
     * @return the next stretch
     */
    public RouteStretch nextStretch()
    {
    	try
    	{
            cursor = nextStretchIndex();
    		RouteStretch next = route.get(cursor).getStretch();
    		lastEdgeRet = cursor - 1;
    		lastStretchRet = cursor;
    		return next;
    	}
    	catch (IndexOutOfBoundsException e)
    	{
    		throw new NoSuchElementException();
    	}
    }
    
    /**
     * returns the index of the first edge in the next stretch in the route
     * @return index of the next stretch
     */
    public int nextStretchIndex()
    {
    	try
    	{
    		RouteItem edge = route.get(lastStretchRet);
    		int distance = edge.getStretch().getLength() - edge.getStretchIndex();
    		return lastStretchRet + distance;
    	}
    	catch (IndexOutOfBoundsException e)
    	{
    		throw new IllegalStateException();
    	}
    }
    
    /**
     * returns the previous stretch in the route and moves the iterator back to it
     * @return the previous stretch
     */
    public RouteStretch previousStretch()
    {
    	try
    	{
        	int i = previousStretchIndex();
        	RouteStretch previous = route.get(i).getStretch();
        	lastEdgeRet = lastStretchRet = cursor = i;
        	return previous;
    	}
    	catch (IndexOutOfBoundsException e)
    	{
    		throw new NoSuchElementException();
    	}
    }
    
    /**
     * returns the index of the first edge of the previous stretch in the route
     * @return index of the previous stretch
     */
    public int previousStretchIndex()
    {
    	try
    	{
    		RouteItem edge = route.get(lastStretchRet);
    		int distance = edge.getStretchIndex();
    		if (lastStretchRet - distance == 0)
    		{
    		    return -1;
    		}
    		else
    		{
    		    edge = route.get(lastStretchRet - distance - 1);
    		    distance += edge.getStretch().getLength();
    		    return lastStretchRet - distance;
    		}
    	}
    	catch (IndexOutOfBoundsException e)
    	{
    		throw new IllegalStateException();
    	}
    }
    
    /**
     * returns the stretch returned by the most recent call to nextStretch() or previousStretch()
     * @return the most recently returned stretch
     */
    public RouteStretch getStretch()
    {
    	try
    	{
    		return route.get(lastStretchRet).getStretch();
    	}
    	catch (IndexOutOfBoundsException e)
    	{
    		throw new NoSuchElementException();
    	}
    }

}