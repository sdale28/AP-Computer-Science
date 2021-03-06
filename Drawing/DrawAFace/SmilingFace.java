/**
 * @author Sam Dale 
 * @version 5/8/2014
 * AP Computer Science
 * 
 * P. 121: 2.15: Write an applet that draws a smiling face. Give the face a nose, ears, a mouth, and eyes with pupils.
 */
import java.applet.Applet;
import java.awt.*;
public class SmilingFace extends Applet
{
    public void paint (Graphics page)
    {
        Color hairColor=new Color(119,56,0);
        Color skinColor=new Color(255,228,196);
        
        hair1(page, hairColor);
        page.setColor(skinColor);
        page.fillOval(75,25,275,300); //Draw face.
        eyes(page);
        mouth(page);
        nose(page);
        ear(page, skinColor);
        eyeBrow(page, hairColor);
        hair2(page, hairColor);
        glasses(page);
        ear(page, skinColor); //Putting ear after glasses tucks frame behind ears.
    }
    
    public void eyes(Graphics page)
    {
        page.setColor(Color.white);
        page.fillOval(150,100,30,30); //Outer left eye.
        page.fillOval(250,100,30,30); //Outer right eye.
        page.setColor(Color.black);
        page.drawOval(150,100,30,30); //Left eye circle.
        page.drawOval(250,100,30,30); //Right eye circle.
        page.setColor(new Color(102,51,0)); //Make brown eye color.
        page.fillOval(155,105,20,20); //Inner left eye.
        page.fillOval(255,105,20,20); //Inner right eye.
        page.setColor(Color.black);
        page.fillOval(160,110,10,10); //Left pupil.
        page.fillOval(260,110,10,10); //Right pupil.
    }
    
    public void mouth(Graphics page)
    {
        page.setColor(new Color(178,34,34));
        page.fillArc(150,220,120,40,0,-180);
        page.setColor(Color.black);
        page.drawArc(170,240,80,10,-10,-160);
    }
    
    public void nose(Graphics page)
    {
        page.setColor(Color.black);
        page.drawArc(185,175,20,30,110,200);
        page.drawArc(225,175,20,30,-110,200);
        page.drawArc(195,100,40,100,90,125);
        page.drawArc(195,100,40,100,-35,125);
        page.drawArc(200,200,30,10,180,180);
    }
    
    public void eyeBrow(Graphics page, Color hairColor)
    {
        Graphics2D page2=(Graphics2D) page;
        page2.setColor(hairColor);
        page2.setStroke(new BasicStroke(4));
        page2.drawArc(145,90,40,20,10,160);
        page2.drawArc(245,90,40,20,10,160);
    }
    
    public void hair1(Graphics page, Color hairColor)
    {
        page.setColor(hairColor);
        page.fillOval(75,10,275,300);
    }
    
    public void hair2(Graphics page, Color hairColor)
    {
        Graphics2D page2=(Graphics2D) page;
        page2.setColor(hairColor);
        page2.setStroke(new BasicStroke(4));
        for (int i=0; i<20; i++)
            page.drawArc(110,20+i,200,50,0,180);
    }
    
    public void glasses(Graphics page)
    {
        Graphics2D page2=(Graphics2D) page;
        page2.setColor(Color.black);
        page2.setStroke(new BasicStroke(4));
        page2.drawRoundRect(135,95,60,40,10,10);
        page2.drawRoundRect(235,95,60,40,10,10);
        page2.drawArc(195,110,40,15,0,180);
        page2.drawLine(90,100,135,105);
        page2.drawLine(295,105,335,100);
        page2.setStroke(new BasicStroke(1)); //Returns to normal for the ears.
    }
    
    public void ear(Graphics page, Color skinColor)
    {
        page.setColor(skinColor);
        page.fillArc(55,100,60,90,60,230);
        page.fillArc(305,100,60,90,-70,230);
        page.setColor(Color.black);
        page.drawArc(55,100,60,90,60,230);
        page.drawArc(305,100,60,90,-110,230);
        page.drawArc(70,125,15,35,90,240); //Left spiral.
        page.drawArc(330,125,15,35,-150,240); //Right spiral.
    }
}