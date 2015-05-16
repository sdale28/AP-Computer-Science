/**
 * @author Sam Dale and Catherine Zhang 
 * @version 4/1/2014
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
        Flower wer=new Flower();
        Rock crush=new Rock();
        Rock agate=new Rock();
        Rock boulder=new Rock();
        world.add(new Location(4,4),jay);
        world.add(new Location(2,4),flow);
        world.add(new Location(2,9),wer);
        world.add(new Location(0,6),crush);
        world.add(new Location(9,1),agate);
        world.add(new Location(9,2),boulder);
        world.show();
    }
}