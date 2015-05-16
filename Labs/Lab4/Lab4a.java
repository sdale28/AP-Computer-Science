/**
 * @author Sam Dale
 * @version 10/1/2013
 * AP Computer Science
 *
 * Lab 4a: Design and implement a program that prompts the user to enter an integer. Print whether the
 * number entered is even or odd, positive or negative.
 */
import java.util.*;
public class Lab4a
{
    public static void main(String args[])
    {
        System.out.println("Enter an integer to find out information about it. Enter 0 to end.");
        boolean run=true;
        while (run)
        {
            Scanner scan=new Scanner(System.in);
            System.out.print("Enter an integer: ");
            int input=scan.nextInt();
            if (input>=0 && input%2==0)
                System.out.println("You entered a positive even integer.");
            else if (input<0 && input%2==0)
                System.out.println("You entered a negative even integer.");
            else if (input>=0 && input%2==1)
                System.out.println("You entered a positive odd integer.");
            else if (input<0 && Math.abs(input)%2==1)
                System.out.println("You entered a negative odd integer.");
            if (input==0) //Enter a sentinel (0) to end program.
                run=false;
        }
    }
}