/**
 * @author Sam Dale
 * @version 2/18/2014
 * AP Computer Science
 */
public abstract class Athlete extends Student
{
    public static final byte CTEAM=00000001;
    public static final byte JV=00000010;
    public static final byte VARSITY=00000100;

    private boolean clearance;
    private boolean eligible;

    public Athlete (String lastName, String firstName, Address home1, Address home2, String phone, double gpa, boolean clearance)
    {
        super(lastName, firstName, home1, home2, phone, gpa);
        this.clearance=clearance;
        this.eligible=checkEligibility(gpa);
    }

    public static boolean checkEligibility(double gpa)
    {
        boolean eligible;
        if (gpa>=2.0)
            eligible=true;
        else
            eligible=false;
        return eligible;
    }

    /*********************************************************************************
     * The getters (accessors).
     *********************************************************************************/
    public boolean getClearance()
    {
        return this.clearance;
    }
    public boolean getEligible()
    {
        return this.eligible;
    }

    /*********************************************************************************
     * The setters (mutators).
     *********************************************************************************/
    public void setClearance(boolean clearance)
    {
        this.clearance=clearance;
    }
    public void setEligible(boolean eligible)
    {
        this.eligible=eligible;
    }

    /***************************************************************************************************************
     * toString()
     **************************************************************************************************************/
    public String toString()
    {
        String tmpClear="";
        if (clearance)
            tmpClear="Cleared.";
        else
            tmpClear="Not Cleared.";

        String tmpEligible="";
        if (eligible)
            tmpEligible="Eligible.";
        else
            tmpEligible="Not Eligible.";

        return super.toString()+"\n"+
               "Athlete: \n"+
               "\tClearance: "+tmpClear+"\n"+
               "\tEligibility: "+tmpEligible;
    }
}