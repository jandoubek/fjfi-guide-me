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
	
	private List<RouteEdge> route;
	private int cursor = 0;
	private int lastRet = -1;
    
//==============================================================================
//== CONSTRUCTORS ==============================================================
    
    RouteIterator(List<RouteEdge> route)
    {
    	this.route = route;
    }
    
    RouteIterator(List<RouteEdge> route, int index)
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
     * checks if there is a next segment in the route
     * @return boolean indicating if there is a next segment
     */
    public boolean hasNextSegment()
    {
    	return nextSegmentIndex() < route.size();
    }
    
    /**
     * checks if there is a previous segment in the route
     * @return boolean indicating if there is a previous segment
     */
    public boolean hasPreviousSegment()
    {
    	return previousSegmentIndex() >= 0;
    }
    
    /**
     * returns the next segment in the route and advances the iterator to it
     * @return the next segment
     */
    public RouteSegment nextSegment()
    {
    	try
    	{
    		RouteSegment next = route.get(cursor).getSegment();
    		lastRet = cursor;
    		cursor = nextSegmentIndex();
    		return next;
    	}
    	catch (IndexOutOfBoundsException e)
    	{
    		throw new NoSuchElementException();
    	}
    }
    
    /**
     * returns the index of the first edge in the next segment in the route
     * @return index of the next segment
     */
    public int nextSegmentIndex()
    {
    	try
    	{
    		RouteEdge edge = route.get(lastRet);
    		int distance = edge.getSegment().getLength() - edge.getSegmentIndex();
    		return lastRet + distance;
    	}
    	catch (IndexOutOfBoundsException e)
    	{
    		throw new IllegalStateException();
    	}
    }
    
    /**
     * returns the previous segment in the route and moves the iterator back to it
     * @return the previous segment
     */
    public RouteSegment previousSegment()
    {
    	try
    	{
        	int i = previousSegmentIndex();
        	RouteSegment previous = route.get(i).getSegment();
        	lastRet = cursor = i;
        	return previous;
    	}
    	catch (IndexOutOfBoundsException e)
    	{
    		throw new NoSuchElementException();
    	}
    }
    
    /**
     * returns the index of the first edge of the previous segment in the route
     * @return index of the previous segment
     */
    public int previousSegmentIndex()
    {
    	try
    	{
    		RouteEdge edge = route.get(cursor);
    		int distance = edge.getSegmentIndex();
    		return cursor - distance - 1;
    	}
    	catch (IndexOutOfBoundsException e)
    	{
    		throw new IllegalStateException();
    	}
    }
    
    /**
     * returns the segment returned by the most recent call to nextSegment() or previousSegment()
     * @return the most recently returned segment
     */
    public RouteSegment getSegment()
    {
    	try
    	{
    		return route.get(lastRet).getSegment();
    	}
    	catch (IndexOutOfBoundsException e)
    	{
    		throw new NoSuchElementException();
    	}
    }

}