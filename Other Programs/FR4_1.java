/**
 * @author Sam Dale
 * @version 12/3/13
 * AP Computer Science
 *
 * AP Free Response 4.1:
 * Create a class called code. A string will be stored as type Code.
 * Portions of the code may e hidden by changing the corresponding letter or digit to an X. Hidden portions may later be recovered.
 */
import java.util.*;
public class FR4_1
{
    public static void main(String args[])
    {
        System.out.println("AP Free Response 4.1");
        System.out.println();

        Scanner scan=new Scanner(System.in).useDelimiter("\n");

        System.out.print("Your code: ");
        Code code=new Code(scan.next());
        System.out.println();

        int p1;
        int p2;

        System.out.println("\tMenu: ");
        boolean run=true;
        while (run)
        {
            System.out.println("\tPress H to Hide.");
            System.out.println("\tPress R to Recover.");
            System.out.println("\tPress Q to Quit");
            System.out.println();

            System.out.print("Please enter your choice: ");
            char action=scan.next().toLowerCase().charAt(0);

            switch (action)
            {
                case 'h':
                    System.out.print("Index from: ");
                    p1=scanInt(scan);
                    System.out.print("Index to: ");
                    p2=scanInt(scan);
                    code.hide(p1,p2);
                    System.out.println(code.toString());
                    break;
                case 'r':
                    System.out.print("Index from: ");
                    p1=scanInt(scan);
                    System.out.print("Index to: ");
                    p2=scanInt(scan);
                    code.recover(p1,p2);
                    System.out.println(code.toString());
                    break;
                case 'q':
                    run=false;
                    System.out.println("Program ended.");
                    break;
                default:
                    System.out.println("Input error.");
            }
            System.out.println();
        }
    }

    public static int scanInt(Scanner scan)
    {
        int p=0;
        boolean run=true;
        String satisfy;
        while(run)
        {
            try
            {
                p=scan.nextInt();
                run=false;
            }
            catch(Exception ex)
            {
                System.out.println("Please enter a number.");
                run=true;
                satisfy=scan.next(); //Satisfy the read.
            }
        }
        return p;
    }
}