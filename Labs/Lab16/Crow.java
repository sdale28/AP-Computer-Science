/**
 * @author Sam Dale 
 * @version 1/23/14
 * AP Computer Science
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
     * speak()
     *********************************************************************************/
    public String speak()
    {
        return "\tSays: caw, caw";
    }
    
    /*********************************************************************************
     * toString()
     *********************************************************************************/
    public String toString()
    {
        return "Crow: "+name+"\n"+
               super.toString();
    }
}