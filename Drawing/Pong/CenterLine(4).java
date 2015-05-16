import java.awt.*;
public class CenterLine
{
    private int x;
    
    public CenterLine(int x)
    {
        this.x=x;
    }
    
    public void draw(Graphics page)
    {
        page.setColor(Color.white);
        for (int height=20;height<780;height+=30)
        {
            page.fillRect(x,height,10,15);
        }
    }
}