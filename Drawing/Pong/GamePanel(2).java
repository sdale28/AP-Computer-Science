import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class GamePanel extends JPanel
{
    private int leftScore=0;
    private int rightScore=0;
    private int leftY=360;
    private int rightY=360;
    private int ballX=80;
    private int ballY=395;
    
    public GamePanel()
    {
        GameListener listener=new GameListener();
        addKeyListener(listener);
        
        setBackground(Color.black);
    }
    
    public void paintComponent(Graphics page)
    {
        super.paintComponent(page);
        
        Player left=new Player(20,leftY);
        Player right=new Player(getSize().width-20,rightY);
        Ball ball=new Ball(ballX,ballY);
        drawBoard(page, left, right, ball);
    }
    
    public void drawBoard(Graphics page, Player left, Player right, Ball ball)
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
        
        left.draw(page);
        right.draw(page);
        ball.draw(page);
    }
    
    private class GameListener implements KeyListener
    {
        public void keyTyped(KeyEvent e)
        {
            if (e.getKeyCode()==KeyEvent.VK_W)
                leftY+=80;
            repaint();
        }
        public void keyPressed(KeyEvent e) {}
        public void keyReleased(KeyEvent e) {}
    }
}
