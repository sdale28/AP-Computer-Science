/**
 * @author Sam Dale
 * @version 9/20/13
 * AP Computer Science
 *
 * LLC 3.12: Write a while loop that makes sure the user enters a positive integer.
 */
import java.util.*;
public class WhileLoop
{
    public static void main(String args[]){
        int n=-1;
        while (n<=0){
            Scanner scan=new Scanner(System.in);
            System.out.print("Enter a positive integer: ");
            n=scan.nextInt();
        }
        System.out.println("You entered a positive integer.");
    }
}
