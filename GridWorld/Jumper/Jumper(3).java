import info.gridworld.actor.Actor;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import java.awt.Color;

public class Jumper extends Actor
{
    public Jumper()
    {
        setColor(Color.BLUE);
    }

    public Jumper (Color jumperColor)
    {
        setColor(jumperColor);
    }

    public void act()
    {
        if (canJump())
            jump();
        else if (canMove())
            move();
        else
            turn();
    }

    public void turn()
    {
        setDirection(getDirection()+Location.HALF_RIGHT);
    }

    public void jump()
    {
        Grid<Actor> gr=getGrid();
        if (gr==null)
            return;
        Location loc=getLocation();
        Location next=loc.getAdjacentLocation(getDirection());
        Location nextnext=next.getAdjacentLocation(getDirection());
        if (gr.isValid(nextnext))
            moveTo(nextnext);
        else
            removeSelfFromGrid();
    }

    public boolean canJump()
    {
        Grid <Actor> gr=getGrid();
        if (gr==null)
            return false;
        Location loc=getLocation();
        Location next=loc.getAdjacentLocation(getDirection());
        if (!gr.isValid(next))
            return false;

        Actor neighbor=gr.get(next);
        if (!((neighbor==null) || (neighbor instanceof Flower) || (neighbor instanceof Rock)))
            return false;

        Location nextNext=next.getAdjacentLocation(getDirection());
        if (!gr.isValid(nextNext))
            return false;
        Actor neighbor2=gr.get(nextNext);
        return (neighbor2==null) && !(neighbor2 instanceof Flower) && !(neighbor2 instanceof Rock);
    }

    public void move()
    {
        Grid <Actor> gr=getGrid();
        if (gr==null)
            return;
        Location loc=getLocation();
        Location next=loc.getAdjacentLocation(getDirection());
        if (gr.isValid(next))
            moveTo(next);
        else
            removeSelfFromGrid();
    }

    public boolean canMove()
    {
        Grid <Actor> gr=getGrid();
        if (gr==null)
            return false;
        Location loc=getLocation();
        Location next=loc.getAdjacentLocation(getDirection());
        if (!gr.isValid(next))
            return false;
        Actor neighbor=gr.get(next);
        return (neighbor==null) || (neighbor instanceof Flower);
    }
}