/**
 * @author Sam Dale 
 * @version 5/14/2014
 * AP Computer Science
 * 
 * p. 252: 4.10:
 * Create a class called Crayon that represents one crayon of a 
 * particular color and length (height). Design and implement an
 * applet that draws a box of crayons.
 */
import java.applet.Applet;
import java.awt.*;
public class BoxOfCrayons extends Applet
{
    public void paint(Graphics page)
    {
        setSize(700,700);
        setBackground(new Color(230,230,250));
        page.setColor(new Color(0,0,0));
        page.drawRect(90,180,380,220);
        int [] xPoints={60,60,90,90};
        int [] yPoints={275,435,400,180};
        page.drawPolygon(xPoints,yPoints,4);
        
        Color [] colors={new Color(255,51,51),new Color(255,153,51),new Color(255,255,51),new Color(153,255,51),new Color(0,255,0),new Color(153,255,204),new Color(102,255,255),new Color(0,128,255),new Color(0,0,255),new Color(102,0,204),new Color(255,102,255),new Color(255,0,127),new Color(128,128,128),new Color(255,255,255)};
        String [] names={"Red","Orange","Yellow","Lime","Green","Foam","Sky","Soft Blue","Blue","Purple","Pink","Magenta","Gray","White"};
        
        for (int row=1;row<=2;row++)
            for (int i=1;i<=7;i++)
            {
                Crayon temp=new Crayon(colors[7*(row-1)+i-1],40+50*i-10*(row-1),140+60*(row-1),200,names[7*(row-1)+i-1]);
                temp.draw(page);
            }
        
        page.drawRect(60,275,380,160);
    }
}