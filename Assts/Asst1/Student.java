/**
 * @author Sam Dale
 * @version 12/1/13
 * AP Computer Science
 * 
 * Asst1: Create some students (instantiate objects).
 * Create two classes: StudentDriver, which is the driver and contains the main(). 
 * The other is Student, which contains the constructors.
 * Asst2: Add functionality to modify a student (use getters and setters).
 * Asst3: Add Print capability (display to screen, use a toString).
 */
public class Student
{
    private String lastName;
    private String firstName;
    private String street;
    private String city;
    private int zip;
    private String phone;
    private double gpa;
    private int id;
    private static int lastId=1;
    
    public Student()
    {
        id=0;
        lastName=null;
        firstName=null;
        street=null;
        city=null;
        zip=0;
        phone=null;
        gpa=0;
    } //End default Student constructor.
    
    public Student(String lastName, String firstName, String street, String city, int zip, String phone, double gpa)
    {
        id=lastId++;
        this.lastName=lastName;
        this.firstName=firstName;
        this.street=street;
        this.city=city;
        this.zip=zip;
        this.phone=phone;
        this.gpa=gpa;
    } //End Student constructor.
    
    /*********************************************************************************
     * The getters (accessors).
     *********************************************************************************/
    public int getId() //This has a getter, but not a setter.
    {
        return id;
    }
    public String getLastName()
    {
        return this.lastName;
    }
    public String getFirstName()
    {
        return this.firstName;
    }
    public String getStreet()
    {
        return this.street;
    }
    public String getCity()
    {
        return this.city;
    }
    public int getZip()
    {
        return this.zip;
    }
    public String getPhone()
    {
        return this.phone;
    }
    public double getGpa()
    {
        return this.gpa;
    }
    
    /*********************************************************************************
     * The setters (mutators).
     *********************************************************************************/
    public void setLastName(String lastName)
    {
        this.lastName=lastName;
    }
    public void setFirstName(String firstName)
    {
        this.firstName=firstName;
    }
    public void setStreet(String street)
    {
        this.street=street;
    }
    public void setCity(String city)
    {
        this.city=city;
    }
    public void setZip(int zip)
    {
        this.zip=zip;
    }
    public void setPhone(String phone)
    {
        this.phone=phone;
    }
    public void setGpa(double gpa)
    {
        this.gpa=gpa;
    }
    
    /*********************************************************************************
     * toString()
     *********************************************************************************/
    public String toString()
    {
        return  "";
    }
}