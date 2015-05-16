/**
 * @author Sam Dale
 * @version 12/12/13
 * AP Computer Science
 * 
 * Lab10: Summing integers
 * Command line arguments and string parsing.
 * Write a program that passes an unspecified number of integers as one command-line argument and
 * display their total.
 * Tokenize the entered string, delimiting on spaces. Add the numbers into the total.
 * 
 * Lab11: Include a try-catch block to trap the error that occurs if the string contains non-integers.
 * Print a Java-generated message if an error occurs.
 * Find the sum of the other integers in the input string.
 */
import java.util.*;
public class Lab11
{
    public static void main(String [] args)
    {
        System.out.println("Summing Integers");
        System.out.println();
        System.out.println("Entered: "+args[0]);
        int total=0;
        StringTokenizer tokens=new StringTokenizer(args[0]," ");
        while(tokens.hasMoreTokens())
        {
            try
            {
                String tempStr=tokens.nextToken();
                total+=Integer.parseInt(tempStr);
            }
            catch (Exception ex)
            {
                System.out.println(ex.getMessage());
            }
        }
        System.out.println("Total = "+total);
    }
}