import info.gridworld.actor.Bug;
import info.gridworld.grid.Location;
public class ZBug extends Bug
{
    private int steps;
    private int sideLength;
    int turn=0;

    public ZBug(int length)
    {
        steps = 0;
        sideLength = length;
        setDirection(Location.EAST);
    }

    public void act()
    {
        if (steps < sideLength && canMove() && turn<3)
        {
            move();
            steps++;
        }
        else
        {
            if(turn==0)
            {
                setDirection(Location.SOUTHWEST);
                steps=0;
            }
            else if (turn==1)
            {
                setDirection(Location.EAST);
                steps=0;
            }
            turn++;
        }
    }
}