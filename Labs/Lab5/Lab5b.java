/** 
 * @author Sam Dale
 * @version 10/11/13
 * AP Computer Science
 * 
 * Lab 5b: Carpet Cost Calculator
 * Prompt the user to enter the room dimentsions in feet.
 * Prompt the user to enter the cost of the carpet, per square yard.
 * Calculate the cost of the carpet.
 */
import java.util.*;
public class Lab5b
{
    public static void main()
    {
        System.out.println("Calculate the cost of carpet.");
        System.out.println("1. Enter D to enter the (D)imensions of the room");
        System.out.println("2. Enter C to enter the (C)ost of the carpet, per square yard");
        System.out.println("3. Enter X to exit");
        System.out.println();
        Scanner scan=new Scanner(System.in);
        boolean runCaseD=true; //To check if the user has already entered the dimensions.
        boolean runCaseC=true; //To check if the user has already entered the cost.
        double area=0;
        double cost=0;
        boolean run=true; //To keep reprompting the user for what they want to do.
        while (run)
        {
            System.out.print("What do you want to do: ");
            String input1string=scan.next().toLowerCase();
            char input1=input1string.charAt(0);
            
            switch(input1)
            {
                case 'd':
                    if (runCaseD) //Check to see if the dimensions have already been entered.
                    {
                        double length=length(scan);
                        double width=width(scan);
                        area=area(width,length);
                        System.out.println("Area of room is: "+area);
                        runCaseD=false;
                    }
                    else
                        System.out.println("You have already entered the dimensions of the room.");
                    break;
                case 'c':
                    if (runCaseC) //Check to see if the cost has already been entered.
                    {
                        cost=entercost(scan);
                        runCaseC=false;
                    }
                    else
                        System.out.println("You have already entered the cost of the carpet.");
                    break;
                case 'x':
                    run=false; //Exit case terminates run of while loop.
                    System.out.println("Program ended");
                    break;
                default:
                    System.out.println("Error in entry."); //If a character that was not expected was entered, the while loop will run again and reprompt the user. 
            }
            
            if (runCaseD==false && runCaseC==false) //Once both the dimensions and cost have been entered, calculate the total cost.
            {
                double totalcost=totalcost(area,cost);
                System.out.println("Your selection: $"+Math.floor(totalcost*100)/100);
                System.out.println();
                runCaseD=true; //Reset runCaseD to make the user enter new dimensions.
                runCaseC=true; //Reset runCaseC to make the user enter a new cost.
            }
        }
    }
    
    public static double length(Scanner scan)
    {
        boolean run=true;
        double length=0;
        String satisfy;
        while (run)
        {
           try
           {
               System.out.print("Enter the length (in feet): ");
               length=scan.nextDouble();
               run=false;
           }
           catch(Exception ex) //Catch to make sure that the user inputs a number for the length (not something else).
           {
               System.out.println("Please enter a number for the length.");
               run=true;
               satisfy=scan.next(); //Satisfy the read.
           }
        }
        return length;
    }
    
    public static double width(Scanner scan)
    {
        boolean run=true;
        double width=0;
        String satisfy;
        while (run)
        {
            try
            {
                System.out.print("Enter the width (in feet): ");
                width=scan.nextDouble();
                run=false;
            }
            catch(Exception ex) //Catch to make sure that the user inputs a number for the width (not something else).
            {
                System.out.println("Please enter a number for the width.");
                run=true;
                satisfy=scan.next(); //Satisfy the read.
            }
        }
        return width;
    }
    
    public static double area(double width,double length)
    {
        return width*length;
    }
    
    public static double entercost(Scanner scan)
    {
        boolean run=true;
        double entercost=0;
        String satisfy;
        while (run)
        {
            try
            {
                System.out.print("Enter the cost (in dollars per square yard): $");
                entercost=scan.nextDouble();
                run=false;
            }
            catch(Exception ex) //Catch to make sure that the user inputs a number for the cost (not something else).
            {
                System.out.println("Please enter a number for the cost.");
                run=true;
                satisfy=scan.next(); //Satisfy the read.
            }
        }
        return entercost;
    }
    
    public static double totalcost(double area,double cost)
    {
        return area*(cost/9); //Cost divided by nine converts square yards to square feet.
    }
}