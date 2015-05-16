import info.gridworld.actor.Bug;
import info.gridworld.grid.Location;
public class DancingBug extends Bug
{
    private int [] turns;
    private int count=0;

    public DancingBug(int [] turns)
    {
        this.turns=turns;
    }

    public void act()
    {
        if (canMove() && count<turns.length)
        {
            for (int i=0;i<turns[count];i++)
                turn();
            move();
            count++;
            if (count==turns.length)
                count=0;
        }
    }
}