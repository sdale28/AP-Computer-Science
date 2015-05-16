/**
 * @author Sam Dale
 * @version 10/15/13
 * AP Computer Science
 *
 * Lab5c: Mortgage calculator.
 * Prompt the user for the principal amount (the amount of money that they want to borrow). Prompt for the interest rate.
 * Calculate the monthly payment.
 */
import java.util.*;
public class Lab5c
{
    public static void main(String args[])
    {
        System.out.println("Mortgage calculator.");
        System.out.println();
        Scanner scan=new Scanner(System.in);
        double principal; //Desired amount of money for the loan.
        double interest; //In percent.
        double months;
        double monthlypayment; //How much the person will pay for the mortgage each month.
        double totalmonthly; //How much the person will pay each month including the property taxes and insurance cost of the property.
        boolean run=true;
        while (run)
        {
            System.out.print("Enter the principal amount (enter 0 to exit): $");
            principal=input(scan);
            if (principal==0) //Entering the senitnel (0) ends the program.
            {
                run=false;
                System.out.println("Program ended.");
            }
            else
            {
                System.out.print("Enter the annual interest rate (percent): ");
                interest=input(scan)/100; //Dividing by one hundred converts the percent entered into the number equivalent.
                System.out.print("Enter the number of years of loan: ");
                months=input(scan)*12; //12 months in a year, and user inputs in years.
                monthlypayment=monthlypayment(principal,interest,months);
                System.out.println("Monthly payment is: $"+Math.floor(monthlypayment*100)/100); //Gives calculation to cents (hundredths place).
                totalmonthly=totalmonthly(monthlypayment, principal);
                System.out.println("Total monthly payment (including property taxes and insurance) is: $"+Math.floor(totalmonthly*100)/100); //Gives calculation to cents (hundredths place).
                System.out.println();
            }
        }
    }

    public static double input(Scanner scan)
    {
        boolean run=true;
        double input=0;
        String satisfy;
        while (run)
        {
            try
            {
                input=scan.nextDouble();
                run=false;
            }
            catch(Exception ex) //Catch if the user does not enter a number for the input.
            {
                System.out.println("Please enter a number.");
                run=true;
                satisfy=scan.next(); //Satisfy the read.
            }
        }
        return input;
    }

    public static double monthlypayment(double P,double r,double n) //P=principal amount, r=annual interest rate, and n=number of months (as given in equation).
    {
        return P*((r/12)*Math.pow(1+r/12,n))/(Math.pow(1+r/12,n)-1); //Given equation for calculating the monthly payment.
    }

    public static double totalmonthly(double monthlypayment,double principal)
    {
        double housevalue=principal/.8;
        return monthlypayment+=(.015*housevalue)/12+.001*housevalue; //Add the property taxes and insurance to the cost of the property. Divide property taxes by 12, because taxes are yearly.
    }
}