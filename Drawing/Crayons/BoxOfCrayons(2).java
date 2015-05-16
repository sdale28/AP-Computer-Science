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
        Graphics2D page2D=(Graphics2D) page;
        setSize(700,700);
        setBackground(new Color(230,230,250));
        Color boxColor=new Color(255,211,2);
        Color darkGreen=new Color(1,72,38);
        Color lightGreen=new Color(4,135,41);
        
        //Back:
        page.setColor(boxColor);
        page.fillRect(90,180,370,220);
        page.setColor(Color.black);
        page.drawRect(90,180,370,220);
        
        //Left Side:
        int [] xPoints={60,60,90,90};
        int [] yPoints={275,435,400,180};
        page.setColor(boxColor);
        page.fillPolygon(xPoints,yPoints,4);
        page.setColor(Color.black);
        page.drawPolygon(xPoints,yPoints,4);
        
        Color [] colors={new Color(255,51,51),new Color(255,153,51),new Color(255,255,51),new Color(153,255,51),new Color(0,255,0),new Color(153,255,204),new Color(102,255,255),new Color(0,128,255),new Color(0,0,255),new Color(102,0,204),new Color(255,102,255),new Color(255,0,127),new Color(128,128,128),new Color(255,255,255)};
        String [] names={"Red","Orange","Yellow","Lime","Green","Foam","Sky","Soft Blue","Blue","Purple","Pink","Magenta","Gray","White"};
        
        for (int row=1;row<=2;row++)
            for (int i=1;i<=7;i++)
            {
                Crayon temp=new Crayon(colors[7*(row-1)+i-1],40+50*i-10*(row-1),140+60*(row-1),200,names[7*(row-1)+i-1]);
                temp.draw(page);
            }
        
        //Front: 
        page.setColor(boxColor);
        page.fillRect(60,275,370,160);
        int [] xPoints4={60,60,145};
        int [] yPoints4={435,295,435};
        page.setColor(lightGreen);
        page.fillPolygon(xPoints4,yPoints4,3);
        int [] xPoints3={60,60,132};
        int [] yPoints3={435,315,435};
        page.setColor(darkGreen);
        page.fillPolygon(xPoints3,yPoints3,3);
        page2D.setStroke(new BasicStroke(2));
        page2D.drawLine(60,285,151,435);
        page2D.setStroke(new BasicStroke(1));
        page.setColor(Color.black);
        page.drawRect(60,275,370,160);
        
        //Right Side:
        int [] xPoints2={430,430,460,460};
        int [] yPoints2={275,435,400,180};
        page.setColor(boxColor);
        page.fillPolygon(xPoints2,yPoints2,4);
        page.setColor(Color.black);
        page.drawPolygon(xPoints2,yPoints2,4);
    }
}