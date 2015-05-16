/**
 * @author Sam Dale
 * @version 1/13/14
 * AP Computer Science
 *
 * Asst1: Create some students (instantiate objects).
 * Create two classes: StudentDriver, which is the driver and contains the main().
 * The other is Student, which contains the constructors.
 * Asst2: Add functionality to modify a student (use getters and setters).
 * Asst3: Add Print capability (display to screen, use a toString).
 * Asst4: Write a Java aggregate class named Address, which has the street, city, and zip of the student so that each student has two addresses.
 * Asst4a: Modify assignment #4 to write the contents of the student array to a file, "student.dat". We will assume that the student.dat file is in the current working directory. Just hardcode this in this filename.
 *        Add the Read and Write functions to the menu.
 * Asst5: Make the student array into an ArrayList.
 *        Add functionality to delete a student (change menu and create a deleteStudent which prompts for which student to elete and decrement totStudents, the class variable).
 */
import java.util.*;
import java.io.*;
public class StudentDriver
{
    public static void main(String args[])
    {
        System.out.println("\tStudent Database");
        System.out.println();
        Scanner scan=new Scanner(System.in).useDelimiter("\n");
        ArrayList <Student> students=new ArrayList <Student> ();
        System.out.println("\tStudent Info Menu");
        System.out.println();
        boolean run=true;
        while (run)
        {
            System.out.println("\tEnter L to (L)oad Student info");
            System.out.println("\tEnter M to (M)odify Student info");
            System.out.println("\tEnter P to (P)rint Student info");
            System.out.println("\tEnter R to (R)ead data from a file");
            System.out.println("\tEnter W to (W)rite data to a file");
            System.out.println("\tEnter D to (D)elete a student");
            System.out.println("\tEnter Q to (Q)uit");
            System.out.println();

            System.out.print("\tPlease enter your choice: ");
            String inputActionString=scan.next().toLowerCase();
            char inputAction=inputActionString.charAt(0);
            System.out.println();
            if (inputActionString.length()==1) //Makes sure user only entered in one character.
            {
                switch (inputAction)
                {
                    case 'l':
                        students.add(loadStudent(scan));
                        break;
                    case 'm':
                        int modifyIndex=findStudent(students,scan,"modify");
                        if (modifyIndex!=-1) // -1 returned if a valid ID is not entered.
                            modifyStudent(scan,students.get(modifyIndex));
                        break;
                    case 'p':
                        int printIndex=findStudent(students,scan,"print");
                        if (printIndex!=-1) // -1 returned if a valid ID is not entered.
                            printStudent(students.get(printIndex));
                        break;
                    case 'r':
                        students=readFile();
                        break;
                    case 'w':
                        writeFile(students);
                        break;
                    case 'd':
                        int deleteIndex=findStudent(students,scan,"delete");
                        if (deleteIndex!=-1) // -1 returned if a valid ID is not entered.
                            deleteStudent(students,deleteIndex);
                        break;
                    case 'q':
                        run=false; //Exit case terminates run of while loop.
                        System.out.println("Program ended.");
                        break;
                    default:
                    System.out.println("Error in entry."); //If a character that was not expected was entered, the while loop will run again and reprompt the user.
                    System.out.println();
                }
            }
            else
            {
                System.out.println("Error in entry.");
                System.out.println();
            }
        }
    } //End main.

    public static int findStudent(ArrayList <Student> students, Scanner scan,String print)
    {
        if (students.isEmpty())
            System.out.println("No students have been loaded or read into the database.");
        else
        {
            System.out.println("ID\tName");
            for (Student tmpStudent : students)
                System.out.println(tmpStudent.getId()+"\t"+tmpStudent.getLastName()+", "+tmpStudent.getFirstName());
            System.out.println();

            int modifyId=DriverUtil.intScan(scan,"ID of Student to "+print+": ");
            for (Student tmpStudent: students)
            {
                if (tmpStudent.getId()==modifyId)
                {
                    System.out.println();
                    return students.indexOf(tmpStudent);
                }
            }
            System.out.println("Not a valid ID.");
        }
        System.out.println();
        return -1; // Returns -1 if the user did not input a valid ID.
    }

    /***********************************************************************************************************
     * loadStudent()
     * ********************************************************************************************************/
    public static Student loadStudent(Scanner scan)
    {
        String lastName;
        String firstName;
        String street1;
        String street2;
        String city1;
        String city2;
        int zip1;
        int zip2;
        String phone;
        double gpa;

        System.out.print("Student's last name: ");
        lastName=scan.next();
        System.out.print("Student's first name: ");
        firstName=scan.next();
        System.out.println("Address 1:");
        System.out.print("\tStudent's street address: ");
        street1=scan.next();
        System.out.print("\tStudent's city: ");
        city1=scan.next();
        zip1=DriverUtil.zipScan(scan,"");
        System.out.println("Address 2 (Fill with blanks if none):");
        System.out.print("\tStudent's street address: ");
        street2=scan.next();
        System.out.print("\tStudent's city: ");
        city2=scan.next();
        zip2=DriverUtil.zipScan(scan,"");
        System.out.print("Student's phone number: ");
        phone=scan.next();
        gpa=DriverUtil.doubleScan(scan,"Student's GPA: ");

        Address home1=new Address(street1,city1,zip1);
        Address home2=new Address(street2,city2,zip2);
        Student thisStudent=new Student(lastName, firstName, home1, home2, phone, gpa);

        System.out.println();
        return thisStudent;
    } //End loadStudent.

    /***********************************************************************************************************
     * modifyStudent()
     * ********************************************************************************************************/
    public static void modifyStudent(Scanner scan,Student student)
    {
        System.out.println("Current Info:");
        System.out.println("Last Name: "+student.getLastName());
        System.out.println("First Name: "+student.getFirstName());
        System.out.println("Address 1:");
        System.out.println("\tStreet: "+student.getHome1().getStreet());
        System.out.println("\tCity: "+student.getHome1().getCity());
        if (student.getHome1().getZip()!=-1)
            System.out.println("\tZip: "+student.getHome1().getZip());
        else
            System.out.println("\tZip: None.");
        System.out.println("Address 2:");
        System.out.println("\tStreet: "+student.getHome2().getStreet());
        System.out.println("\tCity: "+student.getHome2().getCity());
        if (student.getHome2().getZip()!=-1)
            System.out.println("\tZip: "+student.getHome2().getZip());
        else
            System.out.println("\tZip: None.");
        System.out.println("Phone: "+student.getPhone());
        System.out.println("GPA: "+student.getGpa());
        System.out.println();

        String newLastName=null;
        String newFirstName=null;
        String newStreet1=null;
        String newCity1=null;
        int newZip1=-1;
        String newStreet2=null;
        String newCity2=null;
        int newZip2=-1;
        String newPhone=null;
        double newGpa=-1;

        System.out.println("New Info (press ENTER to keep same information):");
        System.out.print("New Last Name: ");
        newLastName=scan.next();
        if (!newLastName.equals(""))
            student.setLastName(newLastName);

        System.out.print("New First Name: ");
        newFirstName=scan.next();
        if (!newFirstName.equals(""))
            student.setFirstName(newFirstName);

        System.out.println("Address 1: ");
        System.out.print("\tNew Street: ");
        newStreet1=scan.next();
        if (!newStreet1.equals(""))
            student.getHome1().setStreet(newStreet1);

        System.out.print("\tNew City: ");
        newCity1=scan.next();
        if (!newCity1.equals(""))
            student.getHome1().setCity(newCity1);

        newZip1=DriverUtil.zipScan(scan,"New ");
        if (newZip1!=-1)
            student.getHome1().setZip(newZip1);

        System.out.println("Address 2: ");
        System.out.print("\tNew Street: ");
        newStreet2=scan.next();
        if (!newStreet2.equals(""))
            student.getHome2().setStreet(newStreet2);

        System.out.print("\tNew City: ");
        newCity2=scan.next();
        if (!newCity2.equals(""))
            student.getHome2().setCity(newCity2);

        newZip2=DriverUtil.zipScan(scan,"New ");
        if (newZip2!=-1)
            student.getHome2().setZip(newZip2);

        System.out.print("New Phone: ");
        newPhone=scan.next();
        if (!newPhone.equals(""))
            student.setPhone(newPhone);

        newGpa=DriverUtil.newGpaScan(scan);
        if (newGpa!=-1)
            student.setGpa(newGpa);

        System.out.println();
    } //End modifyStudent.

    /***********************************************************************************************************
     * printStudent()
     * ********************************************************************************************************/
    public static void printStudent(Student student)
    {
        System.out.println(student.toString());
        System.out.println();
    } //End printStudent.

    /***********************************************************************************************************
     * readFile()
     * ********************************************************************************************************/
    public static ArrayList <Student> readFile()
    {
        ArrayList <Student> students=new ArrayList<>();
        try
        {
            File file=new File("student.dat");
            FileInputStream fileInStream=new FileInputStream(file);
            ObjectInputStream objInStream=new ObjectInputStream(fileInStream);
            students=(ArrayList <Student>)objInStream.readObject();
            System.out.println("File read.");
        }
        catch (FileNotFoundException ex)
        {
            System.out.println("File not found.");
        }
        catch (Exception ex)
        {
            System.out.println(ex);
        }
        System.out.println();

        if (!students.isEmpty())
        {
            students.get(students.size()-1).setLastId(students.get(students.size()-1).getId()+1); //This sets the lastId in the student to the last ID number of the read database.
        }
        else
            System.out.println("Empty array read.");

        return students;
    } //End readFile().

    /***********************************************************************************************************
     * writeFile()
     * ********************************************************************************************************/
    public static void writeFile(ArrayList <Student> students)
    {
        try{
            File file=new File("student.dat");
            FileOutputStream fileOutStream=new FileOutputStream(file);
            ObjectOutputStream objOutStream=new ObjectOutputStream(fileOutStream);
            objOutStream.writeObject(students);
            objOutStream.close();
            fileOutStream.close();

            System.out.println("File written.");
        }
        catch (FileNotFoundException ex)
        {
            System.out.println("File not found.");
        }
        catch (Exception ex)
        {
            System.out.println(ex);
        }
        System.out.println();
    } //End writeFile().

    /***********************************************************************************************************
     * deleteStudent()
     * ********************************************************************************************************/
    public static void deleteStudent(ArrayList <Student> students,int deleteIndex)
    {
        students.remove(deleteIndex);
        System.out.println("Student deleted.");
        System.out.println();
    } //End deleteStudent().
}