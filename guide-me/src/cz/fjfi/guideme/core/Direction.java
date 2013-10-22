package cz.fjfi.guideme.core;

/**
 * This enumeration contains all allowed directions in GuideMe app and methods
 * to work with them.
 * Feel free to modify :-D
 * @author
 * @version
 */
public enum Direction
{
    North,
    Northeast,
    East,
    Southeast,
    South,
    Southwest,
    West,
    Northwest;
    
    /***************************************************************************
     * TODO: comment
     */
    //TODO: body
    public Direction turnRight()
    {
    	Direction[] directions = Direction.values();
    	int ordinal = this.ordinal();
    	ordinal = ++ordinal % directions.length;
    	return directions[ordinal];
    }
    
    /***************************************************************************
     * TODO: comment
     */
    //TODO: body
    public Direction turnLeft()
    {
    	Direction[] directions = Direction.values();
    	int ordinal = this.ordinal();
    	ordinal = --ordinal % directions.length;
    	return directions[ordinal];
    }

}
