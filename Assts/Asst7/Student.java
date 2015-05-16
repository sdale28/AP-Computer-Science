/**
 * @author Sam Dale
 * @version 12/18/13
 * AP Computer Science
 * 
 * Asst4: This holds the students object, which holds the setters, getters, and toString for the student object.
 */
import java.io.*;
public class Student implements Serializable
{
    private String lastName;
    private String firstName;
    private Address home1;
    private Address home2;
    private String phone;
    private double gpa;
    private int id;
    private static int lastId=1;
    
    public Student()
    {
        id=0;
        home1=new Address();
        home2=new Address();
        phone=null;
        gpa=0;
    } //End default Student constructor.
    
    public Student(String lastName, String firstName, Address home1, Address home2, String phone, double gpa)
    {
        id=lastId++;
        this.lastName=lastName;
        this.firstName=firstName;
        this.home1=home1;
        this.home2=home2;
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
    public Address getHome1()
    {
        return this.home1;
    }
    public Address getHome2()
    {
        return this.home2;
    }
    public String getPhone()
    {
        return this.phone;
    }
    public double getGpa()
    {
        return this.gpa;
    }
    
    public String getStats()
    {
        return null;
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
    public void setHome1(Address home1)
    {
        this.home1=home1;
    }
    public void setHome2(Address home2)
    {
        this.home2=home2;
    }
    public void setPhone(String phone)
    {
        this.phone=phone;
    }
    public void setGpa(double gpa)
    {
        this.gpa=gpa;
    }
    public void setLastId(int lastIdMain)
    {
        lastId=lastIdMain;
    }
    
    /*********************************************************************************
     * toString()
     *********************************************************************************/
    public String toString()
    {
        return  "ID #: "+id+"\n"+
                "Last Name: "+lastName+"\n"+
                "First Name: "+firstName+"\n"+
                "Address 1: \n"+
                home1.toString()+"\n"+
                "Address 2: \n"+
                home2.toString()+"\n"+
                "Phone: "+phone+"\n"+
                "GPA: "+gpa;
    }
}