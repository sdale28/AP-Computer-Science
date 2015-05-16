/**
 * @author Sam Dale
 * @version 10/10/13
 * AP Computer Science
 * 
 * Lab5a: Create a calculator.
 * Write a program to prompt the user for an integer, and a floating point (declare this as double). Then prompt the user to
 * compute the product, quotient, sum, or differenceof the two numbers, and printthe result in the main program.
 */
import java.util.*;
public class Lab5a
{
    public static void main()
    {
        System.out.println("Choose what to do: ");
        System.out.println("1. Enter P to compute the Product");
        System.out.println("2. Enter Q to compute the Quotient");
        System.out.println("3. Enter S to compute the Sum");
        System.out.println("4. Enter D to compute the Difference");
        System.out.println("5. Enter C to compare (greater than, less than, or equal)");
        System.out.println("6. Enter X to exit");
        System.out.println();
        Scanner scan=new Scanner(System.in);
        boolean run=true;
        while (run)
        {
            System.out.print("What do you want to do: ");
            String input1string=scan.next().toLowerCase(); //Allows lowercase character to be entered.
            char input1=input1string.charAt(0); //Takes in the first input (which should be a char from the menu given to the user).
            
            int input2; //Integer entered
            double input3; //Floating point entered.
            switch(input1)
            {
                case 'p':
                    input2=input2(scan); //Goes to input2 method and returns what value the user entered.
                    input3=input3(scan); //Goes to input3 method and returns what value the user entered.
                    double product=product(input2,input3);
                    System.out.println("Product = "+product);
                    break;
                case 'q':
                    input2=input2(scan);
                    input3=input3(scan);
                    double quotient=quotient(input2,input3);
                    System.out.println("Quotient = "+quotient);
                    break;
                case 's':
                    input2=input2(scan);
                    input3=input3(scan);
                    double sum=sum(input2,input3);
                    System.out.println("Sum = "+sum);
                    break;
                case 'd':
                    input2=input2(scan);
                    input3=input3(scan);
                    double difference=difference(input2,input3);
                    System.out.println("Difference = "+difference);
                    break;
                case 'c':
                    input2=input2(scan);
                    input3=input3(scan);
                    String compare=compare(input2,input3);
                    System.out.println(compare);
                    break;
                case 'x':
                    run=false; //Exit case terminates run of while loop.
                    System.out.println("Program ended.");
                    break;
                default:
                    System.out.println("Error in entry."); //If a character that was not expected was entered, the while loop will run again and reprompt the user.
            }
        }
    }
    
    public static int input2(Scanner scan)
    {
        boolean run=true;
        int input2=0;
        String satisfy;
        while(run)
        {
            try
            {
                System.out.print("Enter an integer: ");
                input2=scan.nextInt();
                run=false;
            }
            catch(Exception ex) //Catch if the user does not enter an integer for the second input.
            {
                run=true;
                satisfy=scan.next(); //Satisfy the read.
            }
        }
        return input2;
    }
    
    public static double input3(Scanner scan)
    {
        boolean run=true;
        double input3=0;
        String satisfy;
        while (run)
        {
            try
            {
                System.out.print("Enter a floating point: ");
                input3=scan.nextDouble();
                run=false;
            }
            catch(Exception ex) //Catch if the user does not enter a floating point for the third input.
            {
                run=true;
                satisfy=scan.next(); //Satisfy the read.
            }
        }
        return input3;
    }
    
    public static double product(int input2,double input3)
    {
        return input2*input3;
    }
    
    public static double quotient(int input2,double input3)
    {
        return input2/input3;
    }
    
    public static double sum(int input2,double input3)
    {
        return input2+input3;
    }
    
    public static double difference(int input2,double input3)
    {
        return input2-input3;
    }
    
    public static String compare(int input2,double input3) //Return a string that has the comparison statement already written out.
    {
        if (input2>input3)
            return (input3+" is less than "+input2+"\n"+input2+" is greater than "+input3);
        else if (input3>input2)
            return (input2+" is less than "+input3+"\n"+input3+" is greater than "+input2);
        else
            return (input2+" equals "+input3);
    }
}