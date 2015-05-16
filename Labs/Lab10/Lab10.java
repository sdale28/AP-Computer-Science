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
 */
import java.util.*;
public class Lab10
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
            String tempStr=tokens.nextToken();
            total+=Integer.parseInt(tempStr);
        }
        System.out.println("Total = "+total);
    }
}