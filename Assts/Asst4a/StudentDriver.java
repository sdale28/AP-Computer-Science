/**
 * @author Sam Dale
 * @version 1/4/14
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
 */
import java.util.*;
import java.io.*;
public class StudentDriver
{
    public static void main()
    {
        System.out.println("\tStudent Database");
        System.out.println();
        Scanner scan=new Scanner(System.in).useDelimiter("\n");
        int numStudents=DriverUtil.intScan(scan,"Number of students to process: "); //Check to make sure the input is a number.
        System.out.println();
        Student [] students=new Student[numStudents];

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
            System.out.println("\tEnter Q to quit");
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
                        for (int i=0;i<numStudents;i++)
                        {
                            students[i]=loadStudent(scan);
                            System.out.println();
                        }
                        break;
                    case 'm':
                        printList(students);
                        int modifyId=DriverUtil.idScan(scan,students,"modify");
                        System.out.println();
                        modifyStudent(scan,students[modifyId]);
                        break;
                    case 'p':
                        printList(students);
                        int printId=DriverUtil.idScan(scan,students,"print");
                        System.out.println();
                        printStudent(numStudents,students[printId]);
                        break;
                    case 'r':
                        students=readFile(numStudents);
                        break;
                    case 'w':
                        writeFile(students);
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

    public static void printList(Student [] students)
    {
        System.out.println("ID\tName");
        for (int i=0;i<students.length;i++)
            System.out.println(students[i].getId()+"\t"+students[i].getLastName()+", "+students[i].getFirstName());
        System.out.println();
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
    public static void printStudent(int numStudents,Student student)
    {
        if (numStudents==1)
            System.out.println("There is 1 student in the database");
        else
            System.out.println("There are "+numStudents+" students in the database.");
        System.out.println();

        System.out.println(student.toString());
        System.out.println();
    } //End printStudent.

    /***********************************************************************************************************
     * readFile()
     * ********************************************************************************************************/
    public static Student [] readFile(int numStudents)
    {
        Student [] students=new Student[numStudents];
        try
        {
            File file=new File("student.dat");
            FileInputStream fileInStream=new FileInputStream(file);
            ObjectInputStream objInStream=new ObjectInputStream(fileInStream);
            students=(Student[])objInStream.readObject();
            
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
        return students;
    } //End readFile().
    
    /***********************************************************************************************************
     * writeFile()
     * ********************************************************************************************************/
    public static void writeFile(Student [] students)
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
}