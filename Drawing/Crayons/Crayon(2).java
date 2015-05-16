/**
 * @author Sam Dale 
 * @version 5/14/2014
 * AP Computer Science
 */
import java.awt.*;
import java.awt.geom.AffineTransform;
public class Crayon
{
    private Color color;
    private int x;
    private int y;
    private int height;
    private String name;
    
    public Crayon(Color color, int x, int y, int height, String name)
    {
        this.color=color;
        this.x=x;
        this.y=y;
        this.height=height;
        this.name=name;
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
        if (height>=20)
        {
            page.fillRect(x,y+40,40,10);
            page.fillOval(x+5,y+70,30,120);
            page.fillRect(x,y+210,40,10);
        }
        text(page);
    }
    
    public void text(Graphics page)
    {
        Graphics2D page2=(Graphics2D) page;
        Font font=new Font(null, Font.BOLD,15);
        AffineTransform affineTransform=new AffineTransform();
        affineTransform.rotate(Math.toRadians(90),0,0);
        Font rotatedFont=font.deriveFont(affineTransform);
        page2.setFont(rotatedFont);
        page2.setColor(color);
        page2.drawString("Crayola",x+15,y+100);
        
        page2.setFont(rotatedFont.deriveFont(Font.PLAIN));
        page2.setFont(rotatedFont.deriveFont(new Float(10)));
        page2.setColor(Color.black);
        rotatedFont.deriveFont(Font.PLAIN);
        page2.drawString(name,x+32,y+170);
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