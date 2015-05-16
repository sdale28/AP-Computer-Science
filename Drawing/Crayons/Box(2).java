/**
 * @author Sam Dale 
 * @version 5/13/2014
 * AP Computer Science
 * 
 * p. 252: 4.10:
 * Create a class called Crayon that represents one crayon of a 
 * particular color and length (height). Design and impplement an
 * applet that draws a box of crayons.
 */
import java.applet.Applet;
import java.awt.*;
public class Box extends Applet
{
    public void paint(Graphics page)
    {
        Crayon one=new Crayon(Color.green,20,0,80);
        one.draw(page);
    }
}