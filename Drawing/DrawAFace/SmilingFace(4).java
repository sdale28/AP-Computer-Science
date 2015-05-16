/**
 * @author Sam Dale 
 * @version 5/7/2014
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
        page.setColor(new Color(255,228,196));
        page.fillOval(75,25,275,300); //Draw face.
        eyes(page);
        mouth(page);
        nose(page);
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
        page.fillArc(150,210,120,40,-0,-180);
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
}