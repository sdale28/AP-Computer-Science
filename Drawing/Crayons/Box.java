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
        Color [] colors={new Color(255,51,51),new Color(255,153,51),new Color(255,255,51),new Color(153,255,51),new Color(0,255,0),new Color(153,255,204),new Color(102,255,255),new Color(0,128,255),new Color(0,0,255),new Color(102,0,204),new Color(255,102,255),new Color(255,0,127),new Color(128,128,128),new Color(255,255,255)};
        String [] names={"Red","Orange","Yellow","Lime","Green","Foam","Sky","Soft Blue","Blue","Purple","Pink","Magenta","Gray","White"};
        
        for (int row=1;row<=2;row++)
            for (int i=1;i<=7;i++)
            {
                Crayon temp=new Crayon(colors[7*(row-1)+i-1],20+50*i,10+250*(row-1),200,names[7*(row-1)+i-1]);
                temp.draw(page);
            }
    }
}