
/**
 * Write a description of class Crow here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Crow extends Bird
{
    String name;
    
    public Crow(boolean gender,boolean canFly,String name)
    {
        super(gender,canFly);
        this.name=name;
    } //End Crow constructor.
    
    /*********************************************************************************
     * toString()
     *********************************************************************************/
    public String toString()
    {
        return "Crow: "+name+"\n"+
               super.toString();
    }
}