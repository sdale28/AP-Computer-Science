/**
 * @author Sam Dale
 * @version 2/24/14
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
 * Asst6: Give the students properties of Inheritance. Each Student is either "vanilla", an Athlete, or an Artist. An Athlete plays Baseball or Basketball. An Artist is either a Musician or Artist.
 *        There are different levels in the sports, different positions, and other traits to the Baseball, Basketball, Musician, and Actor classes. 
 *        This requires a large addition to both the loadStudent() and modifyStudent() methods as well as the addition of two abstract classes and four classes.
 * Asst7: Modify Asst6 to use Polymorphism instad of casting for each type and having to use instanceof so often. Create a getStats() method for both the Baseball and Basketball classes. This method will return batting
 *        average for the Baseball player and points per game (PPG) and rebounds per game (RPG) for the Basketball player. 
 *        This creates a new menu item which calls the getStats() method in the StudentDriver.
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
        ArrayList <Student> students=new ArrayList <Student> ();
        System.out.println("\tStudent Info Menu");
        System.out.println();
        boolean run=true;
        while (run)
        {
            System.out.println("\tEnter L to (L)oad Student info");
            System.out.println("\tEnter M to (M)odify Student info");
            System.out.println("\tEnter P to (P)rint Student info");
            System.out.println("\tEnter G to (G)et Stats");
            System.out.println("\tEnter R to (R)ead data from a file");
            System.out.println("\tEnter W to (W)rite data to a file");
            System.out.println("\tEnter D to (D)elete a student");
            System.out.println("\tEnter Q to (Q)uit");
            System.out.println();

            System.out.print("\tPlease enter your choice: ");
            String inputActionString=scan.next().toLowerCase();
            System.out.println();
            if (inputActionString.length()==1) //Makes sure user only entered in one character.
            {
                char inputAction=inputActionString.charAt(0);
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
                    case 'g':
                        int getIndex=findStudent(students,scan,"get stats for");
                        if (getIndex!=-1) // -1 returned if a valid ID is not entered.
                            getStats(students.get(getIndex));
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
        zip1=DriverUtil.newIntScan(scan,"\tZip: ");
        Address home1=new Address(street1,city1,zip1);
        
        System.out.println("Address 2 (Fill with blanks if none):");
        System.out.print("\tStudent's street address: ");
        street2=scan.next();
        System.out.print("\tStudent's city: ");
        city2=scan.next();
        zip2=DriverUtil.newIntScan(scan,"\tZip: ");
        Address home2=new Address(street2,city2,zip2);
        
        System.out.print("Student's phone number: ");
        phone=scan.next();
        gpa=DriverUtil.doubleScan(scan,"Student's GPA: ");
        System.out.println();

        Student thisStudent=new Student();
        boolean typeRun=true;
        while (typeRun)
        {
            System.out.println("What kind of student is "+firstName+"?");
            System.out.println();
            System.out.println("\tEnter T for an A(t)hlete");
            System.out.println("\tEnter R for an A(r)tist");
            System.out.println("\tEnter N for (N)either");
            System.out.println();

            System.out.print("\tPlease enter your choice: ");
            String inputActionString=scan.next().toLowerCase();
            System.out.println();

            if (inputActionString.length()==1) //Makes sure user only entered in one character.
            {
                char inputAction=inputActionString.charAt(0);
                switch (inputAction)
                {
                    case 't':
                        boolean athleteRun=true;
                        while (athleteRun)
                        {
                            System.out.println("What sport does "+firstName+" play?");
                            System.out.println();
                            System.out.println("\tEnter E for Bas(e)ball");
                            System.out.println("\tEnter K for Bas(k)etball");
                            System.out.println();

                            System.out.print("\tPlease enter your choice: ");
                            String sportInputActionString=scan.next().toLowerCase();
                            System.out.println();
                            
                            byte level=00000000;
                            boolean clearance=false;
                            if (sportInputActionString.length()==1) //Makes sure user only entered in one character.
                            {
                                char sportInputAction=sportInputActionString.charAt(0);
                                boolean clearanceRun=true;
                                while(clearanceRun)
                                {
                                    System.out.println("Is "+firstName+" cleared?");
                                    System.out.println();
                                    System.out.println("\tEnter Y for (Y)es");
                                    System.out.println("\tEnter N for (N)o");
                                    System.out.println();

                                    System.out.print("\tPlease enter your choice: ");
                                    String clearInputActionString=scan.next().toLowerCase();
                                    System.out.println();

                                    if (clearInputActionString.length()==1) //Makes sure user only entered in one character.
                                    {
                                        char clearInputAction=clearInputActionString.charAt(0);
                                        switch (clearInputAction)
                                        {
                                            case 'y':
                                                clearance=true;
                                                clearanceRun=false;
                                                break;
                                            case 'n':
                                                clearance=false;
                                                clearanceRun=false;
                                                break;
                                            default:
                                                System.out.println("Not a valid entry.");
                                        }
                                    }
                                    else
                                        System.out.println("Invalid entry.");
                                }
                                
                                boolean levelRun=true;
                                while(levelRun)
                                {
                                    System.out.println("What is "+firstName+"'s level?");
                                    System.out.println();
                                    System.out.println("\tEnter C for (C)-team");
                                    System.out.println("\tEnter J for (J)V");
                                    System.out.println("\tEnter V for (V)arsity");
                                    System.out.println();

                                    System.out.print("\tPlease enter your choice: ");
                                    String levelInputActionString=scan.next().toLowerCase();
                                    System.out.println();

                                    if (levelInputActionString.length()==1) //Makes sure the user enters only one character.
                                    {
                                        char levelInputAction=levelInputActionString.charAt(0);
                                        switch (levelInputAction)
                                        {
                                            case 'c':
                                                level=Athlete.CTEAM;
                                                levelRun=false;
                                                break;
                                            case 'j':
                                                level=Athlete.JV;
                                                levelRun=false;
                                                break;
                                            case 'v':
                                                level=Athlete.VARSITY;
                                                levelRun=false;
                                                break;
                                            default:
                                                System.out.println("Not a valid entry.");
                                        }
                                    }
                                    else
                                        System.out.println("Invalid entry.");
                                }

                                switch (sportInputAction)
                                {
                                    case 'e':
                                        double batAvg=DriverUtil.doubleScan(scan,firstName+"'s batting average: ");
                                
                                        short position=00000000;
                                        boolean positionRun=true;
                                        while (positionRun)
                                        {
                                            System.out.println(firstName+"'s position: ");
                                            System.out.println();
                                            System.out.println("\tEnter P for (P)itcher");
                                            System.out.println("\tEnter A for C(a)tcher");
                                            System.out.println("\tEnter F for (F)irst Base");
                                            System.out.println("\tEnter S for (S)econd Base");
                                            System.out.println("\tEnter T for (T)hird Base");
                                            System.out.println("\tEnter H for S(h)ort Stop");
                                            System.out.println("\tEnter L for (L)eft Field");
                                            System.out.println("\tEnter C for (C)enter Field");
                                            System.out.println("\tEnter R for (R)ight Field");
                                            System.out.println();

                                            System.out.print("\tPlease enter your choice: ");
                                            String positionInputActionString=scan.next().toLowerCase();
                                            System.out.println();

                                            if (positionInputActionString.length()==1) //Makes sure the user enters only one character.
                                            {
                                                char positionInputAction=positionInputActionString.charAt(0);
                                                switch (positionInputAction)
                                                {
                                                    case 'p':
                                                        position|=Baseball.PITCHER;
                                                        break;
                                                    case 'a':
                                                        position|=Baseball.CATCHER;
                                                        break;
                                                    case 'f':
                                                        position|=Baseball.FIRST_BASE;
                                                        break;
                                                    case 's':
                                                        position|=Baseball.SECOND_BASE;
                                                        break;
                                                    case 't':
                                                        position|=Baseball.THIRD_BASE;
                                                        break;
                                                    case 'h':
                                                        position|=Baseball.SHORT_STOP;
                                                        break;
                                                    case 'l':
                                                        position|=Baseball.LEFT_FIELD;
                                                        break;
                                                    case 'c':
                                                        position|=Baseball.CENTER_FIELD;
                                                        break;
                                                    case 'r':
                                                        position|=Baseball.RIGHT_FIELD;
                                                        break;
                                                    default:
                                                        System.out.println("Not a valid entry.");
                                                }
                                            }
                                            else
                                                System.out.println("Invalid entry.");
                                            
                                            System.out.println("Do they play another position?");
                                            System.out.println();
                                            System.out.println("\tEnter Y for (Y)es");
                                            System.out.println("\tEnter N for (N)o");
                                            System.out.println();
                                            
                                            System.out.print("\tPlease enter your choice: ");
                                            String morePositionsInputActionString=scan.next().toLowerCase();
                                            System.out.println();
                                            if (morePositionsInputActionString.length()==1) //Makes sure user only entered one character.
                                            {
                                                char morePositionsInputAction=morePositionsInputActionString.charAt(0);
                                                switch(morePositionsInputAction)
                                                {
                                                    case 'y':
                                                        positionRun=true;
                                                        break;
                                                    case 'n':
                                                        positionRun=false;
                                                        break;
                                                    default:
                                                        System.out.println("Please enter a valid character.");
                                                }
                                            }
                                            else
                                                System.out.println("Invalid entry.");
                                        }
                                        athleteRun=false;
                                        thisStudent=new Baseball(lastName, firstName, home1, home2, phone, gpa, clearance, level, batAvg, position);
                                        break;
                                    case 'k':
                                        double ppg=DriverUtil.doubleScan(scan,"Points per game (PPG): ");
                                        double rpg=DriverUtil.doubleScan(scan,"Rebounds per game (RPG): ");
                                        thisStudent=new Basketball(lastName, firstName, home1, home2, phone, gpa, clearance, level, ppg, rpg);
                                        athleteRun=false;
                                        break;
                                    default:
                                        System.out.println("Please enter a valid character.");
                                }
                            }
                            else
                                System.out.println("Invalid entry.");
                        }
                        typeRun=false;
                        break;
                    case 'r':
                        int yrsExp=DriverUtil.intScan(scan, "Years of experience: ");
                        System.out.println();
                        boolean artistRun=true;
                        while (artistRun)
                        {
                            System.out.println("What type of artist is "+firstName+"?");
                            System.out.println();
                            System.out.println("\tEnter M for (M)usician");
                            System.out.println("\tEnter A for (A)ctor");
                            System.out.println();

                            System.out.print("\tPlease enter your choice: ");
                            String artInputActionString=scan.next().toLowerCase();
                            System.out.println();
                            if (artInputActionString.length()==1) //Makes sure user only entered in one character.
                            {
                                char artInputAction=artInputActionString.charAt(0);
                                switch (artInputAction)
                                {
                                    case 'm':
                                        byte group=00000000;
                                        boolean groupRun=true;
                                        while (groupRun)
                                        {
                                            System.out.println("What is "+firstName+" in?");
                                            System.out.println();
                                            System.out.println("\tEnter O for (O)rchestra");
                                            System.out.println("\tEnter B for (B)and");
                                            System.out.println("\tEnter C for (C)hoir");
                                            System.out.println();

                                            System.out.print("\tPlease enter your choice: ");
                                            String groupInputActionString=scan.next().toLowerCase();
                                            System.out.println();
                                            if (groupInputActionString.length()==1) //Makes sure user only entered one character.
                                            {
                                                char groupInputAction=groupInputActionString.charAt(0);
                                                switch(groupInputAction)
                                                {
                                                    case 'o':
                                                        group|=Musician.ORCHESTRA;
                                                        break;
                                                    case 'b':
                                                        group|=Musician.BAND;
                                                        break;
                                                    case 'c':
                                                        group|=Musician.CHOIR;
                                                        break;
                                                    default:
                                                        System.out.println("Please enter a valid character.");
                                                }
                                            }
                                            else
                                                System.out.println("Invalid entry.");
                                            
                                            System.out.println("Do they play in another group?");
                                            System.out.println();
                                            System.out.println("\tEnter Y for (Y)es");
                                            System.out.println("\tEnter N for (N)o");
                                            System.out.println();
                                            
                                            System.out.print("\tPlease enter your choice: ");
                                            String moreGroupsInputActionString=scan.next().toLowerCase();
                                            System.out.println();
                                            if (moreGroupsInputActionString.length()==1) //Makes sure user only entered one character.
                                            {
                                                char moreGroupsInputAction=moreGroupsInputActionString.charAt(0);
                                                switch(moreGroupsInputAction)
                                                {
                                                    case 'y':
                                                        groupRun=true;
                                                        break;
                                                    case 'n':
                                                        groupRun=false;
                                                        break;
                                                    default:
                                                        System.out.println("Please enter a valid character.");
                                                }
                                            }
                                            else
                                                System.out.println("Invalid entry.");
                                        }
                                        System.out.print("Instrument played: ");
                                        String instrument=scan.next();
                                        System.out.println();
                                        thisStudent=new Musician(lastName, firstName, home1, home2, phone, gpa, yrsExp, group, instrument);
                                        artistRun=false;
                                        break;
                                    case 'a':
                                        boolean thespian=true;
                                        boolean thespianRun=true;
                                        while (thespianRun)
                                        {
                                            System.out.println("Is "+firstName+" a thespian?");
                                            System.out.println();
                                            System.out.println("\tEnter Y for (Y)es");
                                            System.out.println("\tEnter N for (N)o");
                                            System.out.println();
                                            
                                            System.out.print("\tPlease enter your choice: ");
                                            String thespianInputActionString=scan.next().toLowerCase();
                                            System.out.println();
                                            if (thespianInputActionString.length()==1) //Makes sure user only entered one character.
                                            {
                                                char thespianInputAction=thespianInputActionString.charAt(0);
                                                switch(thespianInputAction)
                                                {
                                                    case 'y':
                                                        thespian=true;
                                                        thespianRun=false;
                                                        break;
                                                    case 'n':
                                                        thespian=false;
                                                        thespianRun=false;
                                                        break;
                                                    default:
                                                        System.out.println("Please enter a valid character.");
                                                }
                                            }
                                            else
                                                System.out.println("Invalid entry.");
                                        }
                                        int numPlays=DriverUtil.intScan(scan, "Number of plays: ");
                                        thisStudent=new Actor(lastName, firstName, home1, home2, phone, gpa, yrsExp, thespian, numPlays);
                                        artistRun=false;
                                        break;
                                    default:
                                        System.out.println("Please enter a valid character.");
                                }
                            }
                            else
                                System.out.println("Invalid entry.");
                        }
                        typeRun=false;
                        break;
                    case 'n':
                        thisStudent=new Student(lastName, firstName, home1, home2, phone, gpa);
                        typeRun=false;
                        break;
                    default:
                        thisStudent=new Student();
                        System.out.println("Invalid choice.");
                }
            }
            else
                System.out.println("Please enter one character.");
        }
        System.out.println();
        System.out.println("Student loaded.");
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
        
        if (student instanceof Athlete)
        {
            System.out.println("Athlete: ");
            String tmpClear="";
            if (((Athlete)student).getClearance())
                tmpClear="Cleared.";
            else
                tmpClear="Not Cleared.";
            System.out.println("\tClearance: "+tmpClear);
            
            String tmpEligible="";
            if (((Athlete)student).getEligible())
                tmpEligible="Eligible.";
            else
                tmpEligible="Not Eligible.";
            System.out.println("\tEligibility: "+tmpEligible);
            
            if (student instanceof Baseball)
            {
                System.out.println("Baseball: ");
                
                byte level=((Baseball)student).getLevel();
                String tmpLevel="";
                switch(level)
                {
                    case Athlete.CTEAM:
                        tmpLevel="C-Team.";
                        break;
                    case Athlete.JV:
                        tmpLevel="JV.";
                        break;
                    case Athlete.VARSITY:
                        tmpLevel="Varsity.";
                        break;
                    default:
                        tmpLevel="Error.";
                }
                
                short position=((Baseball)student).getPosition();
                String tmpPosition="";
                if ((position & Baseball.PITCHER) == Baseball.PITCHER)
                    tmpPosition=tmpPosition.concat(" Pitcher");
                if ((position & Baseball.CATCHER) == Baseball.CATCHER)
                    tmpPosition=tmpPosition.concat(" Catcher");
                if ((position & Baseball.FIRST_BASE) == Baseball.FIRST_BASE)
                    tmpPosition=tmpPosition.concat(" First Base");
                if ((position & Baseball.SECOND_BASE) == Baseball.SECOND_BASE)
                    tmpPosition=tmpPosition.concat(" Second Base");
                if ((position & Baseball.THIRD_BASE) == Baseball.THIRD_BASE)
                    tmpPosition=tmpPosition.concat(" Third Base");
                if ((position & Baseball.SHORT_STOP) == Baseball.SHORT_STOP)
                    tmpPosition=tmpPosition.concat(" Short Stop");
                if ((position & Baseball.LEFT_FIELD) == Baseball.LEFT_FIELD)
                    tmpPosition=tmpPosition.concat(" Left Field");
                if ((position & Baseball.CENTER_FIELD) == Baseball.CENTER_FIELD)
                    tmpPosition=tmpPosition.concat(" Center Field");
                if ((position & Baseball.RIGHT_FIELD) == Baseball.RIGHT_FIELD)
                    tmpPosition=tmpPosition.concat(" Right Field");
                    
                System.out.println("\tLevel: "+tmpLevel);
                System.out.println("\tBatting Average: "+((Baseball)student).getBatAvg());
                System.out.println("\tPosition:"+tmpPosition);
            }
            else if (student instanceof Basketball)
            {
                System.out.println("Basketball: ");
                
                byte level=((Basketball)student).getLevel();
                String tmpLevel="";
                switch(level)
                {
                    case Athlete.CTEAM:
                        tmpLevel="C-Team.";
                        break;
                    case Athlete.JV:
                        tmpLevel="JV.";
                        break;
                    case Athlete.VARSITY:
                        tmpLevel="Varsity.";
                        break;
                    default:
                        tmpLevel="Error.";
                }
                
                System.out.println("\tLevel: "+tmpLevel);
                System.out.println("\tPPG: "+((Basketball)student).getPpg());
                System.out.println("\tRPG: "+((Basketball)student).getRpg());
            }
        }
        else if (student instanceof Artist)
        {
            System.out.println("Artist: "+((Artist)student).getYrsExp()+" years of experience.");
            
            if (student instanceof Musician)
            {
                System.out.println("Musician: ");
                
                byte group=((Musician)student).getGroup();
                String tmpGroup="";
                if ((group & Musician.ORCHESTRA) == Musician.ORCHESTRA)
                    tmpGroup=tmpGroup.concat(" Orchestra");
                if ((group & Musician.BAND) == Musician.BAND)
                    tmpGroup=tmpGroup.concat(" Band");
                if ((group & Musician.CHOIR) == Musician.CHOIR)
                    tmpGroup=tmpGroup.concat(" Choir");
                    
                System.out.println("\tGroup: "+tmpGroup);
                System.out.println("\tInstrument: "+((Musician)student).getInstrument());
            }
            else if (student instanceof Actor)
            {
                System.out.println("Actor: ");
                
                boolean thespian=((Actor)student).getThespian();
                String tmpThespian="";
                if (thespian)
                    tmpThespian="Thespian.";
                else
                    tmpThespian="Not a Thespian.";
                
                System.out.println("\t"+tmpThespian);
                System.out.println("\tNumber of Plays: "+((Actor)student).getNumPlays());
            }
        }
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

        newZip1=DriverUtil.newIntScan(scan,"\tNew Zip: ");
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

        newZip2=DriverUtil.newIntScan(scan,"\tNew Zip: ");
        if (newZip2!=-1)
            student.getHome2().setZip(newZip2);

        System.out.print("New Phone: ");
        newPhone=scan.next();
        if (!newPhone.equals(""))
            student.setPhone(newPhone);

        newGpa=DriverUtil.newGpaScan(scan);
        if (newGpa!=-1)
            student.setGpa(newGpa);
        
        String firstName=student.getFirstName();
        
        if ((student instanceof Athlete) || (student instanceof Artist))
            System.out.println();
        
        if (student instanceof Athlete)
        {
            System.out.println("Athlete: ");
            
            boolean clearance=false;
            boolean clearanceRun=true;
            while(clearanceRun)
            {
                System.out.println("Is "+firstName+" cleared?");
                System.out.println();
                System.out.println("\tEnter Y for (Y)es");
                System.out.println("\tEnter N for (N)o");
                System.out.println();

                System.out.print("\tPlease enter your choice: ");
                String clearInputActionString=scan.next().toLowerCase();
                System.out.println();

                if (clearInputActionString.length()==1) //Makes sure user only entered in one character.
                {
                    char clearInputAction=clearInputActionString.charAt(0);
                    switch (clearInputAction)
                    {
                        case 'y':
                            clearance=true;
                            clearanceRun=false;
                            break;
                        case 'n':
                            clearance=false;
                            clearanceRun=false;
                            break;
                        default:
                            System.out.println("Not a valid entry.");
                    }
                }
                else
                    System.out.println("Invalid entry.");
            }
            ((Athlete)student).setClearance(clearance);
            
            if (newGpa!=-1)
                ((Athlete)student).setEligible(Athlete.checkEligibility(newGpa)); //Change eligibility based on the new GPA if a new GPA was entered.
            
            byte level=00000000;
            boolean levelRun=true;
            while(levelRun)
            {
                System.out.println("What is "+firstName+"'s level?");
                System.out.println();
                System.out.println("\tEnter C for (C)-team");
                System.out.println("\tEnter J for (J)V");
                System.out.println("\tEnter V for (V)arsity");
                System.out.println();

                System.out.print("\tPlease enter your choice: ");
                String levelInputActionString=scan.next().toLowerCase();
                System.out.println();

                if (levelInputActionString.length()==1) //Makes sure the user enters only one character.
                {
                    char levelInputAction=levelInputActionString.charAt(0);
                    switch (levelInputAction)
                    {
                        case 'c':
                            level=Athlete.CTEAM;
                            levelRun=false;
                            break;
                        case 'j':
                            level=Athlete.JV;
                            levelRun=false;
                            break;
                        case 'v':
                            level=Athlete.VARSITY;
                            levelRun=false;
                            break;
                        default:
                            System.out.println("Not a valid entry.");
                    }
                }
                else
                    System.out.println("Invalid entry.");
            }
            
            if (student instanceof Baseball)
            {                
                System.out.println("Baseball: ");
                ((Baseball)student).setLevel(level);
                
                double newBatAvg=DriverUtil.newDoubleScan(scan,"New Batting Average: ");
                if (newBatAvg!=-1)
                    ((Baseball)student).setBatAvg(newBatAvg);
                
                short position=00000000;
                boolean positionRun=true;
                while (positionRun)
                {
                    System.out.println(firstName+"'s position: ");
                    System.out.println();
                    System.out.println("\tEnter P for (P)itcher");
                    System.out.println("\tEnter A for C(a)tcher");
                    System.out.println("\tEnter F for (F)irst Base");
                    System.out.println("\tEnter S for (S)econd Base");
                    System.out.println("\tEnter T for (T)hird Base");
                    System.out.println("\tEnter H for S(h)ort Stop");
                    System.out.println("\tEnter L for (L)eft Field");
                    System.out.println("\tEnter C for (C)enter Field");
                    System.out.println("\tEnter R for (R)ight Field");
                    System.out.println();

                    System.out.print("\tPlease enter your choice: ");
                    String positionInputActionString=scan.next().toLowerCase();
                    System.out.println();

                    if (positionInputActionString.length()==1) //Makes sure the user enters only one character.
                    {
                        char positionInputAction=positionInputActionString.charAt(0);
                        switch (positionInputAction)
                        {
                            case 'p':
                                position|=Baseball.PITCHER;
                                break;
                            case 'a':
                                position|=Baseball.CATCHER;
                                break;
                            case 'f':
                                position|=Baseball.FIRST_BASE;
                                break;
                            case 's':
                                position|=Baseball.SECOND_BASE;
                                break;
                            case 't':
                                position|=Baseball.THIRD_BASE;
                                break;
                            case 'h':
                                position|=Baseball.SHORT_STOP;
                                break;
                            case 'l':
                                position|=Baseball.LEFT_FIELD;
                                break;
                            case 'c':
                                position|=Baseball.CENTER_FIELD;
                                break;
                            case 'r':
                                position|=Baseball.RIGHT_FIELD;
                                break;
                            default:
                                System.out.println("Not a valid entry.");
                        }
                    }
                    else
                        System.out.println("Invalid entry.");
                                            
                    System.out.println("Do they play another position?");
                    System.out.println();
                    System.out.println("\tEnter Y for (Y)es");
                    System.out.println("\tEnter N for (N)o");
                    System.out.println();
                                            
                    System.out.print("\tPlease enter your choice: ");
                    String morePositionsInputActionString=scan.next().toLowerCase();
                    System.out.println();
                    if (morePositionsInputActionString.length()==1) //Makes sure user only entered one character.
                    {
                        char morePositionsInputAction=morePositionsInputActionString.charAt(0);
                        switch(morePositionsInputAction)
                        {
                            case 'y':
                                positionRun=true;
                                break;
                            case 'n':
                                positionRun=false;
                                break;
                            default:
                                System.out.println("Please enter a valid character.");
                        }
                    }
                    else
                        System.out.println("Invalid entry.");
                }
                ((Baseball)student).setPosition(position);
            }
            else if (student instanceof Basketball)
            {
                System.out.println("Basketball: ");
                ((Basketball)student).setLevel(level);
                
                double newPpg=DriverUtil.newDoubleScan(scan,"New PPG: ");
                if (newPpg!=-1)
                    ((Basketball)student).setPpg(newPpg);
                
                double newRpg=DriverUtil.newDoubleScan(scan,"New RPG: ");
                if (newRpg!=-1)
                    ((Basketball)student).setRpg(newRpg);
            }
        }
        else if (student instanceof Artist)
        {
            System.out.println("Artist: ");
            
            int newYrsExp=DriverUtil.newIntScan(scan,"New Years of Experience: ");
            if (newYrsExp!=-1)
                ((Artist)student).setYrsExp(newYrsExp);
            
            if (student instanceof Musician)
            {
                System.out.println("Musician: ");
                byte group=00000000;
                boolean groupRun=true;
                while (groupRun)
                {
                    System.out.println("What is "+firstName+" in?");
                    System.out.println();
                    System.out.println("\tEnter O for (O)rchestra");
                    System.out.println("\tEnter B for (B)and");
                    System.out.println("\tEnter C for (C)hoir");
                    System.out.println();

                    System.out.print("\tPlease enter your choice: ");
                    String groupInputActionString=scan.next().toLowerCase();
                    System.out.println();
                    if (groupInputActionString.length()==1) //Makes sure user only entered one character.
                    {
                        char groupInputAction=groupInputActionString.charAt(0);
                        switch(groupInputAction)
                        {
                            case 'o':
                                group|=Musician.ORCHESTRA;
                                break;
                            case 'b':
                                group|=Musician.BAND;
                                break;
                            case 'c':
                                group|=Musician.CHOIR;
                                break;
                            default:
                                System.out.println("Please enter a valid character.");
                        }
                    }
                    else
                        System.out.println("Invalid entry.");
                                            
                    System.out.println("Do they play in another group?");
                    System.out.println();
                    System.out.println("\tEnter Y for (Y)es");
                    System.out.println("\tEnter N for (N)o");
                    System.out.println();
                    
                    System.out.print("\tPlease enter your choice: ");
                    String moreGroupsInputActionString=scan.next().toLowerCase();
                    System.out.println();
                    if (moreGroupsInputActionString.length()==1) //Makes sure user only entered one character.
                    {
                        char moreGroupsInputAction=moreGroupsInputActionString.charAt(0);
                        switch(moreGroupsInputAction)
                        {
                            case 'y':
                                groupRun=true;
                                break;
                            case 'n':
                                groupRun=false;
                                break;
                            default:
                                System.out.println("Please enter a valid character.");
                        }
                    }
                    else
                        System.out.println("Invalid entry.");
                }
                ((Musician)student).setGroup(group);
                
                System.out.print("New Instrument: ");
                String newInstrument=scan.next();
                if (!newInstrument.equals(""))
                    ((Musician)student).setInstrument(newInstrument);
            }
            
            if (student instanceof Actor)
            {
                System.out.println("Actor: ");
                boolean thespian=true;
                boolean thespianRun=true;
                while (thespianRun)
                {
                    System.out.println("Is "+firstName+" a thespian?");
                    System.out.println();
                    System.out.println("\tEnter Y for (Y)es");
                    System.out.println("\tEnter N for (N)o");
                    System.out.println();
                    System.out.print("\tPlease enter your choice: ");
                    String thespianInputActionString=scan.next().toLowerCase();
                    System.out.println();
                    if (thespianInputActionString.length()==1) //Makes sure user only entered one character.
                    {
                        char thespianInputAction=thespianInputActionString.charAt(0);
                        switch(thespianInputAction)
                        {
                            case 'y':
                                thespian=true;
                                thespianRun=false;
                                break;
                            case 'n':
                                thespian=false;
                                thespianRun=false;
                                break;
                            default:
                                System.out.println("Please enter a valid character.");
                        }
                    }
                    else
                        System.out.println("Invalid entry.");
                }
                ((Actor)student).setThespian(thespian);
                
                int newNumPlays=DriverUtil.newIntScan(scan,"New Number of Plays: ");
                if (newNumPlays!=-1)
                    ((Actor)student).setNumPlays(newNumPlays);
            }
        }
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
     * getStats()
     * ********************************************************************************************************/
    public static void getStats(Student student)
    {
        if (student instanceof Athlete)
            System.out.println(student.getStats());
        else
            System.out.println("Not an Athlete, so no statistics are available.");
        System.out.println();
    } //End getStats.
    
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
        catch (InvalidClassException ex)
        {
            System.out.println("Error: Saved Students are of the wrong type (not compatible with latest database version).");
        }
        catch (Exception ex)
        {
            System.out.println(ex);
        }
        System.out.println();

        if (!students.isEmpty())
            students.get(students.size()-1).setLastId(students.get(students.size()-1).getId()+1); //This sets the lastId in the student to the last ID number of the read database.
        else
        {
            System.out.println("Empty array read.");
            System.out.println();
        }
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
