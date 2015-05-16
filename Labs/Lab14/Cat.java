
/**
 * Write a description of class Cat here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cat extends Mammal
{
    String name;
    
    public Cat(boolean gender,String hairType,String name)
    {
        super(gender,hairType);
        this.name=name;
    } //End Cat constructor.
    
    /*********************************************************************************
     * toString()
     *********************************************************************************/
    public String toString()
    {
        return "Cat: "+name+"\n"+
               super.toString();
    }
}