/**
 * @author Sam Dale 
 * @version 1/23/14
 * AP Computer Science
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
     * speak()
     *********************************************************************************/
    public String speak()
    {
        return "\tSays: bark, bark";
    }
    
    /*********************************************************************************
     * toString()
     *********************************************************************************/
    public String toString()
    {
        return "Dog: "+name+"\n"+
               super.toString();
    }
}