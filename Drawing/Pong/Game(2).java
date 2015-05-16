/**
 * @author Sam Dale
 * @version 6/2/2014
 * 
 * Pong
 */
import javax.swing.*;
public class Game extends JApplet
{
    public void init()
    {
        setSize(1300,800);
        getContentPane().add(new GamePanel());
    }
}