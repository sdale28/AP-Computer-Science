/**
 * @author Sam Dale
 * @version 12/1/13
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
                System.out.print("Please enter a number for the GPA.");
                satisfy=scan.next();
                run=true;
            }
        }
        return number;
    } //End doubleScan.
    
    public static int idScan(Scanner scan,Student [] students,String print)
    {
        int id=0;
        boolean run=true;
        String satisfy;
        while (run)
        {
            try
            {
                System.out.print("ID of student to "+print+": ");
                id=scan.nextInt();
                for (int i=0;i<students.length;i++)
                {
                    if (students[i].getId()==id)
                        return i;
                }
                System.out.println("Please input valid ID."); //Should have returned a value in the for loop if there was a correct ID entered.
            }
            catch(Exception ex) //Catch if the user does not enter an integer for the ID number.
            {
                System.out.println("Please enter an integer for the ID.");
                run=true;
                satisfy=scan.next(); //Satisfy the read.
            }
        }
        return id;
    } //End idScan.
    
    public static int zipScan(Scanner scan,String print)
    {
        int zip=-1;
        boolean run=true;
        String scanVal=null;
        while (run)
        {
            System.out.print("\t"+print+"Zip: ");
            scanVal=scan.next();
            if (scanVal.equals(""))
            {
                zip=-1;
                run=false;
            }
            else
            {
                try
                {
                    zip=Integer.parseInt(scanVal);
                    run=false;
                }
                catch(Exception ex)
                {
                    System.out.println("Please enter a number (or nothing) for the Zip.");
                    run=true;
                }
            }
        }
        return zip;
    } //End zipScan.
    
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
}