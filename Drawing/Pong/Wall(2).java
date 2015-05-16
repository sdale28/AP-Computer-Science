import java.awt.*;
public class Wall
{
    private int x;
    private int y;
    private int length;
    
    public Wall(int x, int y, int length)
    {
        this.x=x;
        this.y=y;
        this.length=length;
    }
    
    public void draw(Graphics page)
    {
        page.setColor(Color.white);
        page.fillRect(x,y,length,10);
    }
}