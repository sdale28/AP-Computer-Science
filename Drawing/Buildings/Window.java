/**
 * @author Sam Dale 
 * @version 5/20/2014
 * AP Computer Science
 */
import java.awt.*;
public class Window
{
    private int x;
    private int y;
    
    public Window(int x,int y)
    {
        this.x=x;
        this.y=y;
    }
    
    public void draw(Graphics page)
    {
        page.setColor(Color.yellow);
        page.fillRect(x,y,20,20);
    }
}
