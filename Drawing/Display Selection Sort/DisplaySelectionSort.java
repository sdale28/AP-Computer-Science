/**
 * @author Sam Dale 
 * @version 5/28/2014
 * AP Computer Science
 * 
 * p. 385: 6.13:
 * Design and implement an applet that displays a graph of the
 * processing of a selection sort. Use bars to represent the values
 * being sorted. Display the set of bars after each swap. Put a delay
 * in the processing of the sort to give the user a chance to see how
 * the order of the values changes.
 */
import java.applet.Applet;
import java.awt.*;
public class DisplaySelectionSort extends Applet
{
    public void paint(Graphics page)
    {
        int [] array={8,6,1,3,2}; //Maximum is 10.
        int width=array.length*120+220;
        setSize(width,880);
        
        drawGrid(page,width);
        drawBars(page,array);
        selectionSort(page,width,array);
    }

    public void drawGrid(Graphics page, int width)
    {
        Color grey=new Color(212,212,212);
        for (int i=1; i<=10; i++)
        {
            String num=""+i;
            int y=820-80*i;
            page.setColor(grey);
            page.drawLine(30,y,width,y);
            page.setColor(Color.black);
            page.drawString(num,10,y+10);
        }
        page.setColor(grey);
        page.drawLine(30,820,width,820);
        page.setColor(Color.black);
        page.drawString("0",20,835);
        page.drawLine(30,0,30,880);
        page.drawLine(0,820,width,820);
    }
    
    public void drawBars(Graphics page, int [] array)
    {
        page.setColor(new Color(35,23,205));
        for (int i=0; i<array.length; i++)
            page.fillRect(60+150*i,820-80*array[i],120,80*array[i]);
    }
    
    public void selectionSort(Graphics page, int width, int [] numbers)
    {
        for(int index=0;index<numbers.length-1; index++)
        {
            int min=index;
            for(int scan=index+1;scan<numbers.length; scan++)
                if (numbers[scan]<numbers[min])
                    min=scan;

            //Swap the values
            int temp=numbers[min];
            numbers[min]=numbers[index];
            numbers[index]=temp;
            
            try
            {
                Thread.sleep(2000);
            }
            catch (InterruptedException ex)
            {
                Thread.currentThread().interrupt();
                page.drawString("Error.",40,60);
            }
            page.setColor(Color.white);
            page.fillRect(0,0,getSize().width,getSize().height); //"Refresh" the screen
            drawGrid(page, width);
            drawBars(page, numbers);
        }
    }
}