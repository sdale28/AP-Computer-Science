/**
 * @author Sam Dale
 * @version 3/20/2014
 * AP Computer Science
 * 
 * Utilities for the student driver (especially to scan for correct items).
 */
import java.util.*;
public class DriverUtil
{
    public static int intScan(Scanner scan,String print)
    {
        int number=0;
        boolean run=true;
        String satisfy;
        while (run)
        {
            try
            {
                System.out.print(print);
                number=scan.nextInt();
                run=false;
            }
            catch(Exception ex) //Catch to make sure that the user inputs a integer for the number (not something else).
            {
                System.out.println("Please enter an integer.");
                run=true;
                satisfy=scan.next(); //Satisfy the read.
            }
        }
        return number;
    } //End intScan.
    
    public static double doubleScan(Scanner scan,String print)
    {
        double number=0;
        boolean run=true;
        String satisfy;
        while (run)
        {
            try
            {
                System.out.print(print);
                number=scan.nextDouble();
                run=false;
            }
            catch(Exception ex) //Catch if the user does not enter a floating point for the number.
            {
                System.out.print("Please enter a number.");
                satisfy=scan.next();
                run=true;
            }
        }
        return number;
    } //End doubleScan.
    
    public static int newIntScan(Scanner scan,String print) //Allows user to enter nothing (a blank value) as well as something.
    {
        int number=-1;
        boolean run=true;
        String scanVal=null;
        String satisfy;
        while (run)
        {
            System.out.print(print);
            scanVal=scan.next();
            if (scanVal.equals(""))
            {
                number=-1;
                run=false;
            }
            else
            {
                try
                {
                    number=Integer.parseInt(scanVal);
                    run=false;
                }
                catch(Exception ex)
                {
                    System.out.println("Please enter an integer (or nothing).");
                    satisfy=scan.next();
                    run=true;
                }
            }
        }
        return number;
    } //End newIntScan.
    
    public static double newDoubleScan(Scanner scan,String print) //Allows user to enter nothing (a blank value) as well as something.
    {
        double number=-1;
        boolean run=true;
        String scanVal=null;
        String satisfy;
        while (run)
        {
            System.out.print(print);
            scanVal=scan.next();
            if (scanVal.equals(""))
            {
                number=-1;
                run=false;
            }
            else
            {
                try
                {
                    number=Double.parseDouble(scanVal);
                    run=false;
                }
                catch(Exception ex)
                {
                    System.out.println("Please enter a number (or nothing).");
                    satisfy=scan.next();
                    run=true;
                }
            }
        }
        return number;
    } //End newDoubleScan.
    
    public static double newGpaScan(Scanner scan)
    {
        double newGpa=-1;
        boolean run=true;
        String scanVal=null;
        while (run)
        {
            System.out.print("New GPA: ");
            scanVal=scan.next();
            if (scanVal.equals(""))
            {
                newGpa=-1;
                run=false;
            }
            else
            {
                try
                {
                    newGpa=Double.parseDouble(scanVal);
                    if (newGpa<0)
                    {
                        System.out.println("Please enter a number greater than or equal to 0.");
                        run=true;
                    }
                    else
                        run=false;
                }
                catch(Exception ex)
                {
                    System.out.println("Please enter a number (or nothing) for the new GPA.");
                    run=true;
                }
            }
        }
        return newGpa;
    } //End newGpaScan.
    
    public static int binarySearch(ArrayList <Student> students, int target)
    {
        int low=0, high=students.size()-1, middle=(low+high)/2;
        while (students.get(middle).getId()!=target && low<=high)
        {
            if (target<students.get(middle).getId())
                high=middle-1;
            else
                low=middle+1;
            middle=(low+high)/2;
        }
        if (students.get(middle).getId()==target)
            return middle;
        else
            return -1;
    }
}