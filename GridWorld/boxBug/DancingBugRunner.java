import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;
import java.awt.Color;
public class DancingBugRunner
{
    public static void main()
    {
        ActorWorld world = new ActorWorld();
        int [] turns={3,4,5,2};
        DancingBug bob = new DancingBug(turns);
        world.add(new Location(5, 5), bob);
        world.show();
    }
}