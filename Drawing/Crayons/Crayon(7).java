/**
 * @author Sam Dale 
 * @version 5/13/2014
 * AP Computer Science
 */
import java.awt.*;
public class Crayon
{
    private Color color;
    private int x;
    private int y;
    private int height;
    
    public Crayon(Color color, int x, int y, int height)
    {
        this.color=color;
        this.x=x;
        this.y=y;
        this.height=height;
    }
    
    public void draw(Graphics page)
    {
        int [] xPoints={x,x+20,x+40};
        int [] yPoints={y+30,y,y+30};
        page.setColor(color);
        page.fillPolygon(xPoints,yPoints,3);
        page.fillRect(x,y+30,40,height);
        page.setColor(Color.black);
        page.drawPolygon(xPoints,yPoints,3);
        page.drawRect(x,y+30,40,height);
        
        //Label: 
        if (height>10)
        {
            page.fillRect(x,y+40,30,height-10);
        }
    }
    
    public Color getColor()
    {
        return color;
    }
    
    public void setColor(Color color)
    {
        this.color=color;
    }
}