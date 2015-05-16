
/**
 * Write a description of class Dog here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dog extends Mammal
{
    String name;
    
    public Dog(boolean gender,String hairType,String name)
    {
        super(gender,hairType);
        this.name=name;
    } //End Dog constructor.
    
    /*********************************************************************************
     * toString()
     *********************************************************************************/
    public String toString()
    {
        return "Dog: "+name+"\n"+
               super.toString();
    }
}