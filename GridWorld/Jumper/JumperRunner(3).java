/**
 * @author Sam Dale 
 * @version 3/28/2014
 * AP Computer Science
 */
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;
import java.awt.Color;
public class JumperRunner
{
    public static void main()
    {
        ActorWorld world=new ActorWorld();
        Jumper jay=new Jumper();
        Flower flow=new Flower();
        Rock crush=new Rock();
        world.add(new Location(4,4),jay);
        world.add(new Location(2,4),flow);
        world.add(new Location(0,6),crush);
        world.show();
    }
}