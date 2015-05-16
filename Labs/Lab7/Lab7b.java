/**
 * @author Sam Dale
 * @version 10/22/13
 * AP Computer Science
 *
 * Lab7b: holiday Shopping
 * 1. Welcome the user to your shopping budget program.
 * 2. Ask the user how many people he is shopping for this Holiday season.
 * 3. Create 2 arrays.
 *      a. One to store the names of all the people they are shopping for.
 *      b. One to store the amount of money to be spent on each person.
 * 4. Prompt the user for the name of each person they will be shopping for.
 * 5. Prompt the user for the amount of money they will be spending on each person. When asking
 *    for the money, include the name of the person they are shopping for in the prompt.
 * 6. Print a table of people shopped for, budget amount for that person, and the total amount of
 *    money that will be spent this holiday season by the user.
 */
import java.util.*;
public class Lab7b
{
    public static void main(String args[])
    {
        System.out.println("Holiday Shopping");
        System.out.println();
        System.out.println("Welcome to Sam's snazzy, stellar, spectacular shopping program.");
        System.out.println("How many people are you shopping for this holiday season?");
        Scanner scan=new Scanner(System.in);
        double totalcost=0;
        int numberOfPeople=numberOfPeople(scan);
        System.out.println("Please enter each person's name and how much you want to spend on them.");
        String[] names=new String[numberOfPeople];
        double[] budgetPerPerson=new double[numberOfPeople];
        for(int i=0;i<names.length;i++) //For loop for entering name and budget.
        {
            System.out.print("Name of person "+(i+1)+": ");
            names[i]=scan.next();
            budgetPerPerson[i]=input(scan,names,i);
            System.out.println();
            totalcost+=budgetPerPerson[i];
        }

        System.out.println("You're shopping table:");
        System.out.println("Name \t\t\t Budget for Person");
        System.out.println ();
        for (int j=0;j<names.length;j++) //For loop for printing final table.
        {
            System.out.println(names[j]+"\t\t\t $"+budgetPerPerson[j]);
        }
        System.out.println("_______________________________");
        System.out.println("Total\t\t\t $"+totalcost);
    }

    public static int numberOfPeople(Scanner scan)
    {
        boolean run=true;
        int numberOfPeople=0;
        String satisfy;
        while (run)
        {
            try
            {
                System.out.print("Number of people: ");
                numberOfPeople=scan.nextInt();
                run=false;
            }
            catch(Exception ex) //Catch to make sure that the user inputs a integer for the number of people.
            {
                System.out.println("Please enter a number.");
                run=true;
                satisfy=scan.next(); //Satisfy the read.
            }
        }
        return numberOfPeople;
    }

    public static double input(Scanner scan,String[] names,int i)
    {
        boolean run=true;
        double input=0;
        String satisfy;
        while (run)
        {
            try
            {
                System.out.print("Amount to spend on "+names[i]+": $");
                input=scan.nextDouble();
                run=false;
            }
            catch(Exception ex) //Catch to make sure that the user inputs a number for the budget (not something else).
            {
                System.out.println("Please enter a number.");
                run=true;
                satisfy=scan.next(); //Satisfy the read.
            }
        }
        return input;
    }
}