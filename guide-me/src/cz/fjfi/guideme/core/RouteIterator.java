package cz.fjfi.guideme.core;

import java.util.ListIterator;
import java.util.NoSuchElementException;

/***
 * This class allows iteration over Route
 * @author Martin Sochor
 *
 */

public class RouteIterator implements ListIterator<GMEdge>
{
//== CLASS CONSTANTS ===========================================================
//== CLASS VARIABLES ===========================================================
//== INSTANCE VARIABLES ========================================================
	
    private ListIterator<GMEdge> edgeIterator;
    private ListIterator<RouteSegment> segmentIterator;
    
//==============================================================================
//== CONSTRUCTORS ==============================================================
    
    /***************************************************************************
     * TODO: comment
     */
    public RouteIterator(ListIterator<RouteSegment> iterator)
    {
        this.segmentIterator = iterator;
        this.edgeIterator = iterator.next().firstEdgeIterator();
    }

//== GETTERS AND SETTERS =======================================================
//== OTHER METHODS =============================================================
    
    @Override
    public boolean hasNext()
    {
        return edgeIterator.hasNext() || segmentIterator.hasNext();
    }

    @Override
    public boolean hasPrevious()
    {
        return edgeIterator.hasPrevious() || segmentIterator.hasPrevious();
    }

    @Override
    public GMEdge next()
    {
        if (edgeIterator.hasNext())
        {
            return edgeIterator.next();
        }
        else if (segmentIterator.hasNext())
        {
            RouteSegment nextSegment = segmentIterator.next();
            edgeIterator = nextSegment.firstEdgeIterator();
            return edgeIterator.next();
        }
        else
        {
            throw new NoSuchElementException("RouteIterator.next called when iterator was at end");
        }
    }

    @Override
    public int nextIndex()
    {
        throw new UnsupportedOperationException("RouteIterator.nextIndex not supported.");
    }

    @Override
    public GMEdge previous()
    {
        if (edgeIterator.hasPrevious())
        {
            return edgeIterator.previous();
        }
        else if (segmentIterator.hasPrevious())
        {
            RouteSegment prevSegment = segmentIterator.previous();
            edgeIterator = prevSegment.lastEdgeIterator();
            return edgeIterator.previous();
        }
        else
        {
            throw new NoSuchElementException("RouteIterator.previous called when iterator was at beginning");
        }
    }

    @Override
    public int previousIndex()
    {
        throw new UnsupportedOperationException("RouteIterator.previousIndex not supported.");
    }

    @Override
    public void add(GMEdge arg0)
    {
        throw new UnsupportedOperationException("RouteIterator.add not supported.");
    }

    @Override
    public void remove()
    {
        throw new UnsupportedOperationException("RouteIterator.remove not supported.");
    }

    @Override
    public void set(GMEdge arg0)
    {
        throw new UnsupportedOperationException("RouteIterator.set not supported.");
    }

    public boolean hasNextSegment()
    {
        return segmentIterator.hasNext();
    }
    
    public boolean hasPreviousSegment()
    {
        return segmentIterator.hasPrevious();
    }
    
    public RouteSegment nextSegment()
    {
        if (segmentIterator.hasNext())
        {
            RouteSegment nextSegment = segmentIterator.next();
            edgeIterator = nextSegment.firstEdgeIterator();
            return nextSegment;
        }
        else
        {
            throw new NoSuchElementException("RouteIterator.nextSegment called when iterator was at end");
        }
    }
    
    public RouteSegment previousSegment()
    {
        if (segmentIterator.hasPrevious())
        {
            RouteSegment prevSegment = segmentIterator.previous();
            edgeIterator = prevSegment.lastEdgeIterator();
            return prevSegment;
        }
        else
        {
            throw new NoSuchElementException("RouteIterator.previousSegment called when iterator was at beginning");
        }
    }
}
