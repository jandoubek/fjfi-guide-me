package cz.fjfi.guideme.core;

/**
 * Thic enumeration contains all allowed directions in GuideMe app and methods
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
    
    public Direction turnRight()
    {
    	Direction[] directions = Direction.values();
    	int ordinal = this.ordinal();
    	ordinal = ++ordinal % directions.length;
    	return directions[ordinal];
    }
    
    public Direction turnLeft()
    {
    	Direction[] directions = Direction.values();
    	int ordinal = this.ordinal();
    	ordinal = --ordinal % directions.length;
    	return directions[ordinal];
    }

}
