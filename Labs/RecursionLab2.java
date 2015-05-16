/**
 * @author Sam Dale 
 * @version 2/24/2014
 * AP Computer Science
 * 
 * RecursionLab2: Practice using recursion by calculating taking 2 to a desired integer (greater than or equal to 0).
 */
import java.util.*;
public class Driver
{
    public static void main()
    {
        Scanner scan=new Scanner(System.in);
        boolean run=true;
        while (run)
        {
            int desired=intScan(scan,"Integer power of 2 (enter negative to quit): ");
            if (desired>=0)
            {
                int pow=power(desired);
                System.out.println("2^"+desired+" = "+pow);
            }
            else
            {
                run=false;
                System.out.println("Program ended.");
            }
        }
    }

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
                run=false;
            }
            catch (Exception ex) //Catch to make sure that the user inputs an integer for the number.
            {
                System.out.println("Please enter an integer (or negative to quit).");
                run=true;
                satisfy=scan.next(); //Satisfy the read.
            }
        }
        return number;
    }

    public static int power (int n)
    {
        if (n==0)
            return 1;
        else
            return 2*(power(n-1));
    }
}