/**
 * @author Sam Dale 
 * @version 2/20/2014
 * AP Computer Science
 */
public class Baseball extends Athlete
{
    public static final short PITCHER=0b0000000000000001;
    public static final short CATCHER=0b0000000000000010;
    public static final short FIRST_BASE=0b0000000000000100;
    public static final short SECOND_BASE=0b0000000000001000;
    public static final short THIRD_BASE=0b0000000000010000;
    public static final short SHORT_STOP=0b0000000000100000;
    public static final short LEFT_FIELD=0b0000000001000000;
    public static final short CENTER_FIELD=0b0000000010000000;
    public static final short RIGHT_FIELD=0b0000000100000000;

    private byte level;
    private double batAvg;
    private short position;

    public Baseball (String lastName, String firstName, Address home1, Address home2, String phone, double gpa, boolean clearance, byte level, double batAvg, short position)
    {
        super(lastName, firstName, home1, home2, phone, gpa, clearance);
        this.level=level;
        this.batAvg=batAvg;
        this.position=position;
    }

    /************************************************************************************************
     * Getters
     * *********************************************************************************************/
    public byte getLevel()
    {
        return this.level;
    }
    public double getBatAvg()
    {
        return this.batAvg;
    }
    public short getPosition()
    {
        return this.position;
    }
    
    public String getStats()
    {
        return "Statistics: \n"+ 
               "\tBatting Average: "+batAvg;
    }

    /************************************************************************************************
     * Setters
     ***********************************************************************************************/
    public void setLevel(byte level)
    {
        this.level|=level;
    }
    public void setBatAvg(double batAvg)
    {
        this.batAvg=batAvg;
    }
    public void setPosition(short position)
    {
        this.position|=position;
    }

    /************************************************************************************************
     * toString()
     * *********************************************************************************************/
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
        
        String tmpPosition="";
        if ((position & PITCHER) == PITCHER)
            tmpPosition=tmpPosition.concat(" Pitcher");
        if ((position & CATCHER) == CATCHER)
            tmpPosition=tmpPosition.concat(" Catcher");
        if ((position & FIRST_BASE) == FIRST_BASE)
            tmpPosition=tmpPosition.concat(" First Base");
        if ((position & SECOND_BASE) == SECOND_BASE)
            tmpPosition=tmpPosition.concat(" Second Base");
        if ((position & THIRD_BASE) == THIRD_BASE)
            tmpPosition=tmpPosition.concat(" Third Base");
        if ((position & SHORT_STOP) == SHORT_STOP)
            tmpPosition=tmpPosition.concat(" Short Stop");
        if ((position & LEFT_FIELD) == LEFT_FIELD)
            tmpPosition=tmpPosition.concat(" Left Field");
        if ((position & CENTER_FIELD) == CENTER_FIELD)
            tmpPosition=tmpPosition.concat(" Center Field");
        if ((position & RIGHT_FIELD) == RIGHT_FIELD)
            tmpPosition=tmpPosition.concat(" Right Field");

        return super.toString()+"\n"+
               "Baseball: \n"+
               "\tLevel: "+tmpLevel+"\n"+
               "\tBatting Average: "+batAvg+"\n"+
               "\tPosition:"+tmpPosition;
    }
}
