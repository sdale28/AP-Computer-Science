
/**
 * Abstract class Bird - write a description of the class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class Bird extends Animal
{
    boolean canFly;
    
    public Bird(boolean gender,boolean canFly)
    {
        super(gender);
        this.canFly=canFly;
    } //End Bird constructor.
    
    /*********************************************************************************
     * toString()
     *********************************************************************************/
    public String toString()
    {
        if (canFly)
        {
            return super.toString()+"\n"+
                   "\tCan fly.";
        }
        else
        {
            return super.toString()+"\n"+
                   "\tCan't fly.";
        }
    }
}
