/**
 * @author Sam Dale 
 * @version 1/23/14
 * AP Computer Science
 */
public abstract class Bird extends Animal
{
    public static final boolean CANFLY=true;
    boolean canFly;
    
    public Bird(boolean gender,boolean canFly)
    {
        super(gender);
        this.canFly=canFly;
    } //End Bird constructor.
    
    /*********************************************************************************
     * speak()
     *********************************************************************************/
    public String speak()
    {
        return "\tSays: Feathers for me!";
    }
    
    /*********************************************************************************
     * toString()
     *********************************************************************************/
    public String toString()
    {
        String str="";
        if (canFly==CANFLY)
            str=super.toString()+"\n"+"\tCan fly.";
        else if (canFly==!CANFLY)
            str=super.toString()+"\n"+"\tCan't fly.";
        return str;
    }
}
