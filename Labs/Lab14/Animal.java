/**
 * @author Sam Dale
 * @version 1/22/14
 * AP Computer Science
 * 
 * Abstract class Animal - write a description of the class here
 */
public abstract class Animal
{
    public static final boolean FEMALE=true;
    public static final boolean MALE=false;
    boolean gender;
    
    public Animal(boolean gender)
    {
        this.gender=gender;
    } //End Animal constructor.
    
    /*********************************************************************************
     * toString()
     *********************************************************************************/
    public String toString()
    {
        if (gender==FEMALE)
            return "\tGender: Female";
        else
            return "\tGender: Male";
    }
}