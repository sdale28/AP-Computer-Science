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
    public static int inputNumber(Scanner scan)
    {
        int numberOfStudents=0;
        boolean run=true;
        String satisfy;
        while (run)
        {
            try
            {
                System.out.print("Number of students to process: ");
                numberOfStudents=scan.nextInt();
                run=false;
            }
            catch(Exception ex) //Catch to make sure that the user inputs a integer for the number of students (not something else).
            {
                System.out.println("Please enter a number.");
                run=true;
                satisfy=scan.next(); //Satisfy the read.
            }
        }
        return numberOfStudents;
    } //End inputNumber.
    
    public static int zipScan(Scanner scan)
    {
        int zip=0;
        boolean run=true;
        String satisfy;
        while (run)
        {
            try
            {
                System.out.print("Student's zip code: ");
                zip=scan.nextInt();
                run=false;
            }
            catch(Exception ex) //Catch if the user does not enter an integer for the zip code.
            {
                System.out.println("Please enter an integer for the zip code.");
                run=true;
                satisfy=scan.next(); //Satisfy the read.
            }
        }
        return zip;
    } //End zipScan.
    
    public static double gpaScan(Scanner scan)
    {
        double gpa=0;
        boolean run=true;
        String satisfy;
        while (run)
        {
            try
            {
                System.out.print("Student's GPA: ");
                gpa=scan.nextDouble();
                run=false;
            }
            catch(Exception ex) //Catch if the user does not enter a floating point for the GPA.
            {
                System.out.print("Please enter a number for the GPA.");
                satisfy=scan.next();
                run=true;
            }
        }
        return gpa;
    } //End gpaScan.
    
    public static int modifyIdScan(Scanner scan,Student [] students)
    {
        int modifyId=0;
        boolean run=true;
        String satisfy;
        while (run)
        {
            try
            {
                System.out.print("ID of student to modify: ");
                modifyId=scan.nextInt();
                for (int i=0;i<students.length;i++)
                {
                    if (students[i].getId()==modifyId)
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
        return modifyId;
    } //End modifyIdScan.
    
    public static int printIdScan(Scanner scan,Student [] students)
    {
        int printId=0;
        boolean run=true;
        String satisfy;
        while (run)
        {
            try
            {
                System.out.print("ID of student to print: ");
                printId=scan.nextInt();
                for (int i=0;i<students.length;i++)
                {
                    if (students[i].getId()==printId)
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
        return printId;
    } //End printIdScan.
    
    public static int newZipScan(Scanner scan)
    {
        int newZip=-1;
        boolean run=true;
        String scanVal=null;
        while (run)
        {
            System.out.print("New Zip: ");
            scanVal=scan.next();
            if (scanVal.equals(""))
            {
                newZip=-1;
                run=false;
            }
            else
            {
                try
                {
                    newZip=Integer.parseInt(scanVal);
                    if (newZip<0)
                    {
                        System.out.println("Please enter a number greater than or equal to 0.");
                        run=true;
                    }
                    else
                        run=false;
                }
                catch(Exception ex)
                {
                    System.out.println("Please enter a number (or nothing) for the new Zip.");
                    run=true;
                }
            }
        }
        return newZip;
    } //End newZipScan.
    
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