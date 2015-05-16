/**
 * @author Sam Dale 
 * @version 1/23/14
 * AP Computer Science
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
        String str="";
        if (gender==FEMALE)
            str="\tGender: Female";
        else if(gender==MALE)
            str="\tGender: Male";
        return str;
    }
}