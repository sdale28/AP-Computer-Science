/**
 * @author Sam Dale
 * @version 10/7/2013
 * AP Computer Science
 *
 * Lab4c: Write a program where the user has to enter a sequence of numbers, and the output will be to
 * print out the smallest and largest of the numbers.
 */
import java.util.*;
import java.lang.*;
public class Lab4c
{
    public static void main(String args[])
    {
        System.out.println("Enter a series of numbers to print out the smallest and largest of the numbers.");
        Scanner scan=new Scanner(System.in);
        System.out.print("Enter a number: ");
        String inputstring=scan.next(); //Take input in as a string.
        int input=java.lang.Integer.parseInt(inputstring); //Get an integer from the string.
        int lowest=input;
        int highest=input;
        boolean run=true;
        while (run)
        {
            System.out.print("Enter a number (enter q to quit): ");
            inputstring=scan.next();
            char charinput=inputstring.charAt(0);
            if (charinput=='q')
                run=false; //Quit the loop if q is entered.
            else
            {
                input=java.lang.Integer.parseInt(inputstring);
                if (input<lowest)
                    lowest=input;
                else if (input>highest)
                    highest=input;
            }
        }
        System.out.println("The lowest value is: "+lowest);
        System.out.println("The highest value is: "+highest);
    }
}