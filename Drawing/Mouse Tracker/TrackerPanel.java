import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class TrackerPanel extends JPanel
{
    private Point point1=null, point2=null;
    private int distance=0;
    private Graphics page;

    public TrackerPanel()
    {
        TrackerListener listener=new TrackerListener();
        addMouseListener(listener);
        addMouseMotionListener(listener);
        
        setBackground(Color.black);
    }

    public void paintComponent(Graphics page)
    {
        super.paintComponent(page);

        page.setColor(Color.green);
        if (point1!=null && point2!=null)
        {
            page.drawLine(point2.x, point2.y, point2.x, point2.y);
            distance+=Math.sqrt(Math.pow((point1.x-point2.x),2)+Math.pow(point1.y-point2.y,2));
            page.drawString("Distance: "+distance,20,20);
        }
    }

    private class TrackerListener implements MouseListener, MouseMotionListener
    {
        public void mousePressed(MouseEvent event) {}
        public void mouseDragged(MouseEvent event) {}
        public void mouseClicked(MouseEvent event) {}
        public void mouseReleased(MouseEvent event) {}
        
        public void mouseEntered(MouseEvent event) 
        {
            point1=event.getPoint();
            point2=event.getPoint();
        }
        
        public void mouseExited(MouseEvent event) {}
        
        public void mouseMoved(MouseEvent event) 
        {
            Point temp=point2;
            point2=event.getPoint();
            point1=temp;
            
            repaint();
        }
    }
}