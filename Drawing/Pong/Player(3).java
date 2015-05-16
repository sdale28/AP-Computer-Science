import java.awt.*;
public class Player
{
    private int x;
    private int y;
    
    public Player(int x, int y)
    {
        this.x=x;
        this.y=y;
    }
    
    public void draw(Graphics page)
    {
        page.setColor(Color.white);
        page.fillRect(x,y,10,80);
    }
    
    public void changeX(int x)
    {
        this.x=x;
    }
}
