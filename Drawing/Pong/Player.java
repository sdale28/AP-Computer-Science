import java.awt.*;
public class Player
{
    private int x;
    private int y;
    private int score=0;
    
    public Player(int x, int y)
    {
        this.x=x;
        this.y=y;
    }
    
    public void draw(Graphics page)
    {
        page.setColor(Color.white);
        if(y<20)
            y=20;
        else if(y>700)
            y=700;
        page.fillRect(x,y,10,80);
    }
    
    public void incrementY(int increment)
    {
        y+=increment;
    }
    
    public int getScore()
    {
        return score;
    }
}
