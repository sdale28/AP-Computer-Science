/**
 * @author Sam Dale 
 * @version 10/1/2013
 * AP Computer Science
 * 
 * Lab 4b: Design and implement a program that prompts the user to enter an integer. Determine and print
 * the number of odd, even, and zero digits.
 */
import java.util.*;
public class Lab4b
{
    public static void main()
    {
        System.out.println("Enter an integer to find out about the digits. Enter 0 to exit.");
        boolean run=true;
        while (run)
        {
            Scanner scan=new Scanner(System.in);
            System.out.print("Input an integer: ");
            int input=Math.abs(scan.nextInt()); //Take the absolute value to account for negative numbers.
            int even=0;
            int odd=0;
            int zero=0;
            if (input==0)
            {
                zero++;
                run=false;
            }
            while (input!=0)
            {
                int digit = input % 10;
                if (digit%2==0 && digit!=0)
                    even++;
                else if (digit%2==1)
                    odd++;
                else
                    zero++;
                input/=10;
            }
            System.out.println("Even digits: "+even);
            System.out.println("Odd digits: "+odd);
            System.out.println("Zeros: "+zero);
        }
        System.out.println("Program ended.");
    }
}