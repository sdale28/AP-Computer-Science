
/**
 * Write a description of class Robin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Robin extends Bird
{
    String name;
    
    public Robin(boolean gender,boolean canFly,String name)
    {
        super(gender,canFly);
        this.name=name;
    } //End Robin constructor.
    
    /*********************************************************************************
     * toString()
     *********************************************************************************/
    public String toString()
    {
        return "Robin: "+name+"\n"+
               super.toString();
    }
}