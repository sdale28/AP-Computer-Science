import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;

import java.awt.Color;
public class ZBugRunner
{
    public static void main()
    {
        ActorWorld world = new ActorWorld();
        ZBug bob = new ZBug(4);
        world.add(new Location(1, 1), bob);
        world.show();
    }
}