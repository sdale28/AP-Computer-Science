/**
 * @author Sam Dale
 * @version 12/2/13
 * AP Computer Science
 *
 * Asst1: Create some students (instantiate objects).
 * Create two classes: StudentDriver, which is the driver and contains the main().
 * The other is Student, which contains the constructors.
 * Asst2: Add functionality to modify a student (use getters and setters).
 */
import java.util.*;
public class StudentDriver
{
    public static void main(String args[])
    {
        System.out.println("\tStudent Database");
        System.out.println();
        Scanner scan=new Scanner(System.in).useDelimiter("\n");
        int numStudents=DriverUtil.inputNumber(scan); //Check to make sure the input is a number.
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
                        int modifyId=DriverUtil.modifyIdScan(scan,students);
                        System.out.println();
                        modifyStudent(scan,modifyId,students[modifyId]);
                        break;
                    case 'p':
                        printList(students);
                        int printId=DriverUtil.printIdScan(scan,students);
                        System.out.println();
                        printStudent(numStudents,students[printId]);
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
        String street;
        String city;
        int zip;
        String phone;
        double gpa;

        System.out.print("Student's last name: ");
        lastName=scan.next();
        System.out.print("Student's first name: ");
        firstName=scan.next();
        System.out.print("Student's street address: ");
        street=scan.next();
        System.out.print("Student's city: ");
        city=scan.next();
        zip=DriverUtil.zipScan(scan);
        System.out.print("Student's phone number: ");
        phone=scan.next();
        gpa=DriverUtil.gpaScan(scan);

        Student thisStudent=new Student(lastName, firstName, street, city, zip, phone, gpa);
        return thisStudent;
    } //End loadStudent.

    /***********************************************************************************************************
     * modifyStudent()
     * ********************************************************************************************************/
    public static void modifyStudent(Scanner scan,int modifyId,Student student)
    {

    } //End modifyStudent.

    /***********************************************************************************************************
     * printStudent()
     * ********************************************************************************************************/
    public static void printStudent(int numStudents,Student student)
    {

    } //End printStudent.
}