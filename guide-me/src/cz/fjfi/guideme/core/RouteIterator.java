package cz.fjfi.guideme.core;

import java.util.ListIterator;

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
	
    private ListIterator<GMEdge> iterator;
    
//==============================================================================
//== CONSTRUCTORS ==============================================================
    
    /***************************************************************************
     * TODO: comment
     */
    public RouteIterator(ListIterator<GMEdge> iterator)
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
    public GMEdge next()
    {
        return iterator.next();
    }

    @Override
    public int nextIndex()
    {
        return iterator.nextIndex();
    }

    @Override
    public GMEdge previous()
    {
        return iterator.previous();
    }

    @Override
    public int previousIndex()
    {
        return iterator.previousIndex();
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

}
