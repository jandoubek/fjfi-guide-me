package cz.fjfi.guideme.core;

import java.util.ListIterator;

/***
 * This class allows iteration over Route
 * @author Martin Sochor
 *
 */

public class RouteIterator implements ListIterator<Edge>
{
    private ListIterator<Edge> iterator;
    
    public RouteIterator(ListIterator<Edge> iterator)
    {
        this.iterator = iterator;
    }

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
    public Edge next()
    {
        return iterator.next();
    }

    @Override
    public int nextIndex()
    {
        return iterator.nextIndex();
    }

    @Override
    public Edge previous()
    {
        return iterator.previous();
    }

    @Override
    public int previousIndex()
    {
        return iterator.previousIndex();
    }

    @Override
    public void add(Edge arg0)
    {
        throw new UnsupportedOperationException("RouteIterator.add not supported.");
    }

    @Override
    public void remove()
    {
        throw new UnsupportedOperationException("RouteIterator.remove not supported.");
    }

    @Override
    public void set(Edge arg0)
    {
        throw new UnsupportedOperationException("RouteIterator.set not supported.");
    }

}
