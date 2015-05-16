import java.awt.*;
public class Ball
{
    private int x;
    private int y;
    private Direction dir=new Direction(Direction.LEFT);
    
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
    
    public void move()
    {
        if(dir.getDirection()>Direction.RIGHT)
            x+=10;
        else if ((dir.getDirection()>=0 && dir.getDirection()<90) || (dir.getDirection()>270 && dir.getDirection()<=360))
            x-=10;
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
