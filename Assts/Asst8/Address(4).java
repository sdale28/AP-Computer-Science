/**
 * @author Sam Dale 
 * @version 12/18/13
 * AP Computer Science
 * 
 * Asst4: Write a Java class named Address, which has the street, city, and zip of the student so that each student has two addresses.
 * Has a has-a relationship with the student class.
 */
import java.io.*;
public class Address implements Serializable
{
    private String street;
    private String city;
    private int zip;
    
    public Address()
    {
        street=null;
        city=null;
        zip=0;
    }
    
    public Address(String street, String city, int zip)
    {
        this.street=street;
        this.city=city;
        this.zip=zip;
    }
    
    /*********************************************************************************
     * The getters (accessors).
     *********************************************************************************/
    public String getStreet()
    {
        if (this.street.equals(""))
            return "N/A";
        return this.street;
    }
    public String getCity()
    {
        if (this.city.equals(""))
            return "N/A";
        return this.city;
    }
    public int getZip()
    {
        return this.zip;
    }
    
    /*********************************************************************************
     * The setters (mutators).
     *********************************************************************************/
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
    
    /*********************************************************************************
     * toString()
     *********************************************************************************/
    public String toString()
    {
        if (street.equals("") && city.equals("") && zip==-1)
            return "\tNone";
        else if (zip==-1)
        {
            return "\tStreet: "+street+"\n"+
                   "\tCity: "+city+"\n"+
                   "\tZip: None.";
        }
        
        return "\tStreet: "+street+"\n"+
               "\tCity: "+city+"\n"+
               "\tZip: "+zip;
    }
}