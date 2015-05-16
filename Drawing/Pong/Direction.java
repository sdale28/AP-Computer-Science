public class Direction
{
    public static final int RIGHT=0;
    public static final int UPRIGHT=45;
    public static final int UP=90;
    public static final int UPLEFT=135;
    public static final int LEFT=180;
    public static final int DOWNLEFT=225;
    public static final int DOWN=270;
    public static final int DOWNRIGHT=315;
    
    private int direction;
    
    public Direction(int direction)
    {
        this.direction=direction;
    }
    
    public int getDirection()
    {
        return direction;
    }
    
    public void setDirection(int direction)
    {
        if (direction>=360)
            this.direction=direction;
        else if (direction>360)
            this.direction=direction-360;
    }
}
