/**
 * @author Sam Dale 
 * @version 1/23/14
 * AP Computer Science
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
     * speak()
     *********************************************************************************/
    public String speak()
    {
        return "\tSays: chirp, chirp";
    }
    
    /*********************************************************************************
     * toString()
     *********************************************************************************/
    public String toString()
    {
        return "Robin: "+name+"\n"+
               super.toString();
    }
}