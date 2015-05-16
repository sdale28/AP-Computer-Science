/**
 * @author Sam Dale
 * @version 5/20/2014
 * AP Computer Science
 */
import java.awt.*;
public class Building
{
    private int x;
    private int y;
    private int width;
    private int height;
    private final int MAX_X=100, MAX_Y=100, MAX_WIDTH=100, MAX_HEIGHT=100;
    
    public Building(int x, int y, int width, int height)
    {
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
    }
    
    public void draw(Graphics page)
    {
        page.setColor(Color.black);
        page.fillRect(x,y,width,height);
    }
}