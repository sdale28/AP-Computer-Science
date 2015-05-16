import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;

import java.awt.Color;
public class BoxBugRunner
{
    public static void main()
    {
        ActorWorld world = new ActorWorld();
        BoxBug bob = new BoxBug(4);
        world.add(new Location(5, 5), bob);
        world.show();
    }
}