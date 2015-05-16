/**
 * @author Sam Dale 
 * @version 5/19/2014
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
        
        Color boxColor=new Color(255,211,2);
        Color boxInside=new Color(207,186,166);
        Color darkGreen=new Color(1,72,38);
        Color lightGreen=new Color(4,135,41);
        Color red=new Color(225,0,3);
        
        //Top:
        int [] xPoints11={90,125,495,460};
        int [] yPoints11={180,120,120,180};
        page.setColor(boxInside);
        page.fillPolygon(xPoints11,yPoints11,4);
        page.setColor(Color.black);
        page.drawPolygon(xPoints11,yPoints11,4);
        page.setColor(boxInside);
        page.fillArc(125,80,370,80,0,180);
        page.setColor(Color.black);
        page.drawArc(125,80,370,80,0,180);
        
        //Back:
        page.setColor(boxInside);
        page.fillRect(90,180,370,220);
        page.setColor(Color.black);
        page.drawRect(90,180,370,220);
        
        //Left Side:
        int [] xPoints={60,60,90,90};
        int [] yPoints={275,435,400,180};
        page.setColor(boxInside);
        page.fillPolygon(xPoints,yPoints,4);
        page.setColor(Color.black);
        page.drawPolygon(xPoints,yPoints,4);
        
        Color [] colors={new Color(255,51,51),new Color(255,153,51),new Color(255,255,51),new Color(153,255,51),new Color(0,255,0),new Color(153,255,204),new Color(102,255,255),new Color(0,128,255),new Color(0,0,255),new Color(102,0,204),new Color(255,102,255),new Color(255,0,127),new Color(128,128,128),new Color(255,255,255)};
        String [] names={"Red","Orange","Yellow","Lime","Green","Foam","Sky","Azure","Blue","Purple","Pink","Magenta","Gray","White"};
        
        for (int row=1;row<=2;row++)
            for (int i=1;i<=7;i++)
            {
                Crayon temp=new Crayon(colors[7*(row-1)+i-1],40+50*i-10*(row-1),140+60*(row-1),200,names[7*(row-1)+i-1]);
                temp.draw(page);
            }
        
        //Front: 
        page.setColor(boxColor);
        page.fillRect(60,275,370,160);
        int [] xPoints4={60,60,140};
        int [] yPoints4={435,300,435};
        page.setColor(lightGreen);
        page.fillPolygon(xPoints4,yPoints4,3);
        int [] xPoints3={60,60,127};
        int [] yPoints3={435,320,435};
        page.setColor(darkGreen);
        page.fillPolygon(xPoints3,yPoints3,3);
        page.setColor(lightGreen);
        for (int i=0;i<=4;i++)
            page.drawLine(60,293-i,144+i,435);
        for (int i=0;i<=4;i++)
            page.drawLine(60,282-i,154+i,435);
        
        int [] xPoints5={430,430,350};
        int [] yPoints5={435,300,435};
        page.setColor(lightGreen);
        page.fillPolygon(xPoints5,yPoints5,3);
        int [] xPoints6={430,430,363};
        int [] yPoints6={435,320,435};
        page.setColor(darkGreen);
        page.fillPolygon(xPoints6,yPoints6,3);
        page.setColor(lightGreen);
        for (int i=0;i<=4;i++)
            page.drawLine(430,293-i,346-i,435);
        for (int i=0;i<=4;i++)
            page.drawLine(430,282-i,336-i,435);
        
        page.setColor(Color.black);
        page.drawRect(60,275,370,160);
        
        Font font2=new Font(null,Font.BOLD,50); //Desired: Comic Sans MS
        page.setFont(font2);
        page.setColor(lightGreen);
        page.setFont(font2);
        page.drawString("Crayola",160,340);
        
        page.setColor(red);
        page.fillOval(210,360,70,70);
        page.setColor(Color.white);
        page.drawString("14",215,415);
        
        //Right Side:
        int [] xPoints2={430,430,460,460};
        int [] yPoints2={275,435,400,180};
        page.setColor(boxColor);
        page.fillPolygon(xPoints2,yPoints2,4);
        
        int [] xPoints7={430,430,460,460};
        int [] yPoints7={435,320,285,400};
        page.setColor(darkGreen);
        page.fillPolygon(xPoints7,yPoints7,4);
        int [] xPoints8={430,430,460,460};
        int [] yPoints8={320,300,265,285};
        page.setColor(lightGreen);
        page.fillPolygon(xPoints8,yPoints8,4);
        int [] xPoints9={430,430,460,460};
        int [] yPoints9={293,289,254,258};
        page.setColor(lightGreen);
        page.fillPolygon(xPoints9,yPoints9,4);
        int [] xPoints10={430,430,460,460};
        int [] yPoints10={282,278,243,247};
        page.setColor(lightGreen);
        page.fillPolygon(xPoints10,yPoints10,4);
        
        page.setColor(Color.black);
        page.drawPolygon(xPoints2,yPoints2,4);
        
        //Crayons:
        Crayon one=new Crayon(new Color(0,128,255),480,250,200,"Azure");
        Crayon two=new Crayon(new Color(255,102,255),530,250,200,"Pink");
        one.draw(page);
        two.draw(page);
    }
}