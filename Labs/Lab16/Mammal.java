/**
 * @author Sam Dale 
 * @version 1/23/14
 * AP Computer Science
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
     * speak()
     *********************************************************************************/
    public String speak()
    {
        return "\tSays: I'm hairy.";
    }
    
    /*********************************************************************************
     * toString()
     *********************************************************************************/
    public String toString()
    {
        return super.toString()+"\n"+
               "\tHair type: "+hairType;
    }
}
