import java.awt.*;
public class Ball
{
    private int x;
    private int y;
    
    public Ball(int x, int y)
    {
        this.x=x;
        this.y=y;
    }
    
    public void draw(Graphics page)
    {
        page.setColor(Color.white);
        page.fillRect(x,y,10,10);
    }
    
    public int getX()
    {
        return x;
    }
    
    public int getY()
    {
        return y;
    }
}
