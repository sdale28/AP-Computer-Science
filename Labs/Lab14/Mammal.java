
/**
 * Abstract class Mammal - write a description of the class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class Mammal extends Animal
{
    String hairType;
    
    public Mammal(boolean gender,String hairType)
    {
        super(gender);
        this.hairType=hairType;
    } //End Mammal constructor.
    
    /*********************************************************************************
     * toString()
     *********************************************************************************/
    public String toString()
    {
        return super.toString()+"\n"+
               "\tHair type: "+hairType;
    }
}
