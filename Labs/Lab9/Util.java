/**
 * @author Sam Dale 
 * @version 12/10/13
 * AP Computer Science
 */
import java.util.*;
public class Util
{
    public static int intScan(Scanner scan,String print)
    {
        int number=0;
        boolean run=true;
        String satisfy;
        while (run)
        {
            try
            {
                System.out.print(print);
                number=scan.nextInt();
                return number;
            }
            catch (Exception ex) //Catch to make sure that the user inputs an integer for the number.
            {
                System.out.println("Please enter an integer.");
                run=true;
                satisfy=scan.next(); //Satisfy the read.
            }
        }
        return 0;
    }
    
    public static double doubleScan(Scanner scan,String print)
    {
        double number=0;
        boolean run=true;
        String satisfy;
        while (run)
        {
            try
            {
                System.out.print(print);
                number=scan.nextDouble();
                return number;
            }
            catch (Exception ex) //Catch to make sure that the user inputs a double for the number.
            {
                System.out.println("Please enter a double.");
                run=true;
                satisfy=scan.next(); //Satisfy the read.
            }
        }
        return 0;
    }
}