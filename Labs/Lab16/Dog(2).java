/**
 * @author Sam Dale 
 * @version 1/23/14
 * AP Computer Science
 */
public class Dog extends Mammal
{
    String name;
    int intBones;
    
    public Dog(boolean gender,String hairType,String name,int intBones)
    {
        super(gender,hairType);
        this.name=name;
        this.intBones=intBones;
    } //End Dog constructor.
    
    /*********************************************************************************
     * speak()
     *********************************************************************************/
    public String speak()
    {
        return "\tSays: bark, bark";
    }
    
    /*********************************************************************************
     * digBones()
     *********************************************************************************/
    public int digBones()
    {
        return intBones;
    }
    
    /*********************************************************************************
     * getName()
     *********************************************************************************/
    public String getName()
    {
        return name;
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