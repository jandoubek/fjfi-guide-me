package cz.fjfi.guideme.core;

import java.util.ListIterator;

/***
 * This class allows iteration over Route
 * @author Martin Sochor
 *
 */

public class RouteIterator implements ListIterator<RouteEdge>
{
//== CLASS CONSTANTS ===========================================================
//== CLASS VARIABLES ===========================================================
//== INSTANCE VARIABLES ========================================================
	
    private ListIterator<RouteEdge> iterator;
    
//==============================================================================
//== CONSTRUCTORS ==============================================================
    
    /***************************************************************************
     * TODO: comment
     */
    public RouteIterator(ListIterator<RouteEdge> iterator)
    {
        this.iterator = iterator;
    }

//== GETTERS AND SETTERS =======================================================
//== OTHER METHODS =============================================================
    
    @Override
    public boolean hasNext()
    {
        return iterator.hasNext();
    }

    @Override
    public boolean hasPrevious()
    {
        return iterator.hasPrevious();
    }

    @Override
    public RouteEdge next()
    {
        return iterator.next();
    }

    @Override
    public int nextIndex()
    {
        return iterator.nextIndex();
    }

    @Override
    public RouteEdge previous()
    {
        return iterator.previous();
    }

    @Override
    public int previousIndex()
    {
        return iterator.previousIndex();
    }

    @Override
    public void add(RouteEdge arg0)
    {
        throw new UnsupportedOperationException("RouteIterator.add not supported.");
    }

    @Override
    public void remove()
    {
        throw new UnsupportedOperationException("RouteIterator.remove not supported.");
    }

    @Override
    public void set(RouteEdge arg0)
    {
        throw new UnsupportedOperationException("RouteIterator.set not supported.");
    }
}
