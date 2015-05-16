/**
 * @author Sam Dale
 * @version 11/1/13
 * AP Computer Science
 *
 * Lab8a: StringTokenizer
 * Write a program that receives user input for a monetary value, and extracts the dollars and cents
 * using the StringTokenizer class.
 */
import java.util.*;
public class Lab8a
{
    public static void main(String args[])
    {
        System.out.println("Monetary Values");
        System.out.println("Enter a monetary value (in the format of \"$x.xx\") to find out the dollars and cents.");
        boolean run=true;
        while (run)
        {
            System.out.println();
            System.out.print("Enter the monetary value (enter X to exit): ");
            Scanner scan=new Scanner(System.in);
            String input=scan.nextLine();
            if (input.toLowerCase().charAt(0)=='x')
            {
                run=false;
                System.out.println("Program ended.");
            }
            else
            {
                StringTokenizer tokens=new StringTokenizer(input,"$.");
                int count=0;
                while(tokens.hasMoreTokens() && count<=1)
                {
                    if(count==0)
                        System.out.print(tokens.nextToken()+" dollars and ");
                    else if (count==1)
                        System.out.print(tokens.nextToken()+" cents.");
                     count++;
                }
            }
        }
    }
}
