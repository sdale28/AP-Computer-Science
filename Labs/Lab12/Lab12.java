/**
 * @author Sam Dale
 * @version 12/16/13
 * AP Computer Science
 *
 * Lab12: Exception Handling
 * 1. Create an array array with 100 randomly chosen integers.
 * 2. Prompt the user for and array index and display the contents of the array at that index.
 * 3. Trap the error if the user specifies an index that is out of bounds, and print a Java-generated error
 *    message. Re-prompt after the error.
 */
import java.util.*;
import java.lang.Math;
public class Lab12
{
    public static void main(String args[])
    {
        int [] list=new int [100];
        for (int i=0;i<100;i++)
        {
            list[i]=(int)(100*Math.random());
            System.out.println(list[i]);
        }

        Scanner scan=new Scanner(System.in);
        boolean run=true;
        while (run)
        {
            String satisfy;
            try
            {
                System.out.print("Array to index: ");
                int index=scan.nextInt();
                System.out.println("Value = "+list[index]);
                run=false;
            }
            catch (ArrayIndexOutOfBoundsException e)
            {
                System.out.println(e.getMessage());
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
                satisfy=scan.next();
            }
        }
    }
}