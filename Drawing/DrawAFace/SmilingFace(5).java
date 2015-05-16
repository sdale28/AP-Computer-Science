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
        page.drawOval(150,150,200,300);
        page.drawOval(100,100,30,30); //Outer left eye.
        page.drawOval(200,100,30,30); //Outer right eye.
        page.setColor(new Color(102,51,0)); //Make brown eye color.
        page.fillOval(107,107,20,20); //Inner left eye.
        page.fillOval(207,107,20,20); //Inner right eye.
        page.setColor(Color.black);
        page.fillOval(213,112,10,10);
    }
}
