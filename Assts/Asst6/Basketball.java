/**
 * @author Sam Dale 
 * @version 2/18/2014
 * AP Computer Science
 */
public class Basketball extends Athlete
{
    private byte level;
    private double ppg;
    private double rpg;

    public Basketball (String lastName, String firstName, Address home1, Address home2, String phone, double gpa, boolean clearance, byte level, double ppg, double rpg)
    {
        super(lastName, firstName, home1, home2, phone, gpa, clearance);
        this.level=level;
        this.ppg=ppg;
        this.rpg=rpg;
    }
    
    /************************************************************************************************
     * Getters
     * **********************************************************************************************/
    public byte getLevel()
    {
        return this.level;
    }
    public double getPpg()
    {
        return this.ppg;
    }
    public double getRpg()
    {
        return this.rpg;
    }

    /************************************************************************************************
     * Setters
    * **********************************************************************************************/
    public void setLevel(byte level)
    {
        this.level=level;
    }
    public void setPpg(double ppg)
    {
        this.ppg=ppg;
    }
    public void setRpg(double rpg)
    {
        this.rpg=rpg;
    }

    /************************************************************************************************
    * toString()
    * **********************************************************************************************/
    public String toString()
    {
        String tmpLevel="";
        switch(this.level)
        {
            case Athlete.CTEAM:
                tmpLevel="C-Team.";
                break;
            case Athlete.JV:
                tmpLevel="JV.";
                break;
            case Athlete.VARSITY:
                tmpLevel="Varsity.";
                break;
            default:
                tmpLevel="Error.";
        }
        
        return super.toString()+"\n"+
               "Basketball: \n"+
			   "\tLevel: "+tmpLevel+"\n"+
               "\tPPG: "+ppg+"\n"+
			   "\tRPG: "+rpg;
    }
}
