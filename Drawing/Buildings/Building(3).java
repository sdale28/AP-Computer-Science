/**
 * @author Sam Dale
 * @version 5/20/2014
 * AP Computer Science
 */
import java.awt.*;
import java.util.*;
public class Building
{
    private int x;
    private int y;
    private int width;
    private int height;

    public Building(int x, int y, int width, int height)
    {
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
    }

    public void draw(Graphics page, Random generator)
    {
        page.setColor(Color.black);
        page.fillRect(x,y,width,height);
        
        //Windows: 
        for(int i=x; i<x+width-9; i+=20)
        {
            if(i==x)
                if(!(width%10==0))
                    i+=10+(width%10)/2;
                else
                    i+=10;
            
            for (int j=y; j<y+height-9; j+=20)
            {
                if(j==y)
                    if(!(height%10==0))
                        j+=10+(height%10)/2;
                    else
                        j+=10;

                if (generator.nextBoolean())
                {
                    Window temp=new Window(i,j);
                    temp.draw(page);
                }
            }
        }
    }
}