import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;
import info.gridworld.grid.UnboundedGrid;

import java.awt.Color;
public class SpiralBugRunner
{
    public static void main()
    {
        ActorWorld world = new ActorWorld();
        world.setGrid(new UnboundedGrid());
        SpiralBug bob = new SpiralBug(4);
        world.add(new Location(5, 5), bob);
        world.show();
    }
}