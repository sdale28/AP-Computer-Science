/**
 * @author Sam Dale
 * @version 5/20/2014
 * AP Computer Science
 * 
 * p. 252: 4.9:
 * Design and implement a class called Building that represents a 
 * drawing of a building. The parameters to the constructor should 
 * be the building's width and height. Each building should be col-
 * ored black and have a few random windows colored yellow.
 * Create an applet that draws a random skyline of buildings.
 */
import java.applet.Applet;
import java.awt.*;
import java.util.*;
public class City extends Applet
{
    public void paint(Graphics page)
    {
        setSize(1200,800);
        setBackground(new Color(17,21,119));
        Random generator=new Random();
        
        //Ground:
        page.setColor(Color.black);
        page.fillRect(0,600,1200,200);
        
        for (int building=0; building<=10; building++)
        {
            int y=generator.nextInt(500)+100;
            Building temp=new Building(generator.nextInt(1200),600-y,generator.nextInt(120)+60,y);
            temp.draw(page,generator);
        }
    }
}