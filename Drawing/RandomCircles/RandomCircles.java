/**
 * @author Sam Dale 
 * @version 5/12/2014
 * AP Computer Science
 * 
 * p. 189: 3.17: 
 * Design and implement an applet that draws 100 circles of random
 * color and random diameter in random locations. Make
 * sure that in each case the whole cirlce appears in the visible area
 * of the applet.
 */
import java.applet.Applet;
import java.awt.*;
public class RandomCircles extends Applet
{
    public void paint(Graphics page)
    {
        for (int i=0;i<100;i++)
        {
            int colorOne=(int) (255*Math.random());
            int colorTwo=(int) (255*Math.random());
            int colorThree=(int) (255*Math.random());
            page.setColor(new Color(colorOne,colorTwo,colorThree));
            int coordOne=(int) (500*Math.random());
            int coordTwo=(int) (500*Math.random());
            
            int circleSize=(int) (100*Math.random());
            page.fillOval(coordOne,coordTwo,circleSize,circleSize);
        }
    }
}