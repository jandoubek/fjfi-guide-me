package cz.fjfi.guideme.core;

/**
 * This enumeration contains all allowed directions in GuideMe app and methods
 * to work with them.
 * Feel free to modify :-D
 * @author
 * @version
 */
public class Direction
{
    private Compass compassDirection;
    private Vertical verticalDirection;
    private final static int NUM_DIRECTIONS = 8;
    
    /**
     * constructs a level direction
     * @param compass direction
     */
    public Direction(Compass direction)
    {
        this(direction, Vertical.Level);
    }
    
    /**
     * constructs a vertical direction
     * @param compass direction
     * @param vertical direction
     */
    public Direction(Compass compassDirection, Vertical verticalDirection)
    {
        this.compassDirection = compassDirection;
        this.verticalDirection = verticalDirection;
    }
    
    public enum Compass
    {
        North,
        Northeast,
        East,
        Southeast,
        South,
        Southwest,
        West,
        Northwest;
    }
    
    public enum Vertical
    {
        Downwards,
        Level,
        Upwards;
    }
    
    public enum Relative
    {
        Straight,
        SlightRight,
        Right,
        SharpRight,
        Back,
        SharpLeft,
        Left,
        SlightLeft,
        Up,
        Down;
        
        /**
         * Returns direction made by turning by 'turn'
         * @param change in direction
         * @return direction after turning
         */
        public Relative turn(Relative turn)
        {
            switch (turn)
            {
            case Up: case Down:
                return turn;

            default:
                Relative[] directions = Relative.values();
                int ordinal;
                if (this == Up || this == Down)
                {
                    ordinal = 0;
                }
                else
                {
                    ordinal = this.ordinal();
                }
                ordinal = (NUM_DIRECTIONS + ordinal - turn.ordinal()) % NUM_DIRECTIONS;
                return directions[ordinal];
            }
        }
    }

    /**
     * Returns direction made by turning by 'turn'
     * @param change in direction
     * @return direction after turning
     */
    public Direction turn(Relative turn)
    {
        switch (turn)
        {
        case Up:
            return new Direction(compassDirection,Vertical.Upwards);
            
        case Down:
            return new Direction(compassDirection,Vertical.Downwards);

        default:
            Compass[] directions = Compass.values();
            int ordinal = this.compassDirection.ordinal();
            ordinal = (NUM_DIRECTIONS + ordinal - turn.ordinal()) % NUM_DIRECTIONS;
            return new Direction(directions[ordinal]);
        }
    }
    
    /**
     * Returns the turn needed to change direction from this to 'other'
     * @param desired target direction
     * @return relative direction
     */
    public Relative subtract(Direction other)
    {
        switch (other.verticalDirection)
        {
        case Upwards:
            return Relative.Up;
            
        case Downwards:
            return Relative.Down;
            
        default:
            Relative[] directions = Relative.values();
            int ordinal = this.compassDirection.ordinal();
            ordinal = (NUM_DIRECTIONS + other.compassDirection.ordinal() - ordinal) % NUM_DIRECTIONS;
            return directions[ordinal];
        }
    }
    
    /**
     * Exports given Direction to its XML.
     */
    public StringBuilder exportXML()
    {
    	StringBuilder sb = new StringBuilder();
    	sb.append("            <direction compass=\"" + compassDirection.name() + "\" vertical=\"" + verticalDirection.name() + "\" />\n");
    	return sb;
    }

}
