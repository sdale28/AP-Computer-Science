/**
 * @author Sam Dale 
 * @version 2/20/14
 * AP Computer Science
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
     * speak()
     *********************************************************************************/
    public String speak()
    {
        return "\tSays: meow";
    }
    
    /*********************************************************************************
     * toString()
     *********************************************************************************/
    public String toString()
    {
        return "Cat: "+name+"\n"+
               super.toString();
    }
}