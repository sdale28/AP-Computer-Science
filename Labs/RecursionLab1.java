/**
 * @author Sam Dale
 * @version 2/24/2014
 * AP Computer Science
 *
 * RecursionLab1: Practice using recursion by creating a program that can calculate the factorial value of a desired integer.
 */
import java.util.*;
public class Driver
{
    public static void main(String args[])
    {
        Scanner scan=new Scanner(System.in);
        boolean run=true;
        while(run)
        {
            int desired=intScan(scan,"Integer for factorial (enter negative to quit): ");
            if (desired>=0)
            {
                int fact=factorial(desired);
                System.out.println(desired+"! = "+fact);
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

    public static int factorial(int n)
    {
        if (n==0)
            return 1;
        else
            return n*factorial(n-1);
    }
}