/**
 * @author Sam Dale
 * @version 2/18/2014
 * AP Computer Science
 */
public abstract class Artist extends Student
{
    private int yrsExp;

    public Artist(String lastName, String firstName, Address home1, Address home2, String phone, double gpa, int yrsExp)
    {
        super(lastName, firstName, home1, home2, phone, gpa);
        this.yrsExp=yrsExp;
    }
    
    /*********************************************************************************
     * The getter (accessor).
     *********************************************************************************/
    public int getYrsExp()
    {
        return this.yrsExp;
    }
    
    /*********************************************************************************
     * The setter (mutator).
     *********************************************************************************/
    public void setYrsExp(int yrsExp)
    {
        this.yrsExp=yrsExp;
    }

    /************************************************************************************************
     * toString()
     ***********************************************************************************************/
    public String toString()
    {
        return super.toString()+"\n"+
               "Artist: "+yrsExp+" years of experience.";
    }
}
