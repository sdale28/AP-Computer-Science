import info.gridworld.actor.Bug;
public class BoxBug extends Bug
{
    private int steps;
    private int sideLength;
    
    public BoxBug(int length)
    {
        steps = 0;
        sideLength = length;
    }

    public void act()
    {
        if (steps < sideLength && canMove())
        {
            move();
            steps++;
        }
        else
        {
            turn();
            turn();
            steps = 0;
        }
    }
}
