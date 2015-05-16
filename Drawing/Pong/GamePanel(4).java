import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class GamePanel extends JPanel
{
    private Player leftPlayer=new Player(20,360);
    private Player rightPlayer=new Player(1270,360);
    private Ball ball=new Ball(80,395);
    
    public GamePanel()
    {
        setFocusable(true);
        
        GameListener listener=new GameListener();
        addKeyListener(listener);
        
        setBackground(Color.black);
    }
    
    public void paintComponent(Graphics page)
    {
        super.paintComponent(page);
        
        drawBoard(page);
        ball.draw(page);
        leftPlayer.draw(page);
        rightPlayer.draw(page);
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
        String leftScoreString=""+leftPlayer.getScore();
        String rightScoreString=""+rightPlayer.getScore();
        page.drawString(leftScoreString,getSize().width/2-100,110);
        page.drawString(rightScoreString,getSize().width/2+50,110);
    }
    
    private class GameListener extends KeyAdapter
    {
        public void keyTyped(KeyEvent e) {}
        
        public void keyPressed(KeyEvent e) 
        {
            if (e.getKeyChar()=='w')
                leftPlayer.incrementY(-8);
            else if (e.getKeyChar()=='s')
                leftPlayer.incrementY(8);
            
            if (e.getKeyCode()==KeyEvent.VK_UP)
                rightPlayer.incrementY(-8);
            else if (e.getKeyCode()==KeyEvent.VK_DOWN)
                rightPlayer.incrementY(8);
            repaint();
        }
        
        public void keyReleased(KeyEvent e) {}
    }
}