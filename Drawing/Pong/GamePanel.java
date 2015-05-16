import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class GamePanel extends JPanel
{
    private int leftScore=0;
    private int rightScore=0;
    
    public GamePanel()
    {
        setBackground(Color.black);
    }
    
    public void paintComponent(Graphics page)
    {
        super.paintComponent(page);
        
        drawBoard(page);
    }
    
    public void drawBoard(Graphics page)
    {
        Wall top=new Wall(10,10,getSize().width-20);
        Wall bottom=new Wall(10,getSize().height-20,getSize().width-20);
        CenterLine middle=new CenterLine(getSize().width/2-5);
        top.draw(page);
        bottom.draw(page);
        middle.draw(page);
        
        Font font=new Font(null,Font.PLAIN,80);
        page.setFont(font);
        String leftScoreString=""+leftScore;
        String rightScoreString=""+rightScore;
        page.drawString(leftScoreString,getSize().width/2-100,110);
        page.drawString(rightScoreString,getSize().width/2+50,110);
    }
    
    private class GameListener implements KeyListener
    {
        public void keyTyped(KeyEvent e){}
        public void keyPressed(KeyEvent e) {}
        public void keyReleased(KeyEvent e) {}
    }
}
