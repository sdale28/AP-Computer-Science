/**
 * @author Sam Dale 
 * @version 5/31/2014
 * AP Computer Science
 * 
 * p. 458: 7.8:
 * Design and implement an application that acts like a mouse
 * odometer, displaying how far, in pixels, the mouse has moved
 * (while it is over the program window). Display the current 
 * odometer value using a label. Hint: Use the mouse movement  
 * event to determine the current position, and compare it to the 
 * last position of the mouse. Use the distance formula to see how 
 * far the mouse has traveled, and add that to a running total 
 * distance.
 */
import javax.swing.*;
public class Tracker extends JApplet
{
    public void init()
    {
        setSize(900,900);
        getContentPane().add(new TrackerPanel());
    }
}