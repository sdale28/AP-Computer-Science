import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;
import info.gridworld.grid.UnboundedGrid;

import java.awt.Color;

public class CircleBugRunner
{
    public static void main()
    {
        ActorWorld world = new ActorWorld();
        world.setGrid(new UnboundedGrid());
        CircleBug bob = new CircleBug(2);
        world.add(new Location(6, 4), bob);
        world.show();
    }
}