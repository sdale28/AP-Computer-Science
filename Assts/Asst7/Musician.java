/**
 * @author Sam Dale 
 * @version 2/20/2014
 * AP Computer Science
 */
public class Musician extends Artist
{
    public static final byte ORCHESTRA=00000001;
    public static final byte BAND=00000010;
    public static final byte CHOIR=00000100;
    
    private byte group;
    private String instrument;

    public Musician (String lastName, String firstName, Address home1, Address home2, String phone, double gpa, int yrsExp, byte group, String instrument)
    {
        super(lastName, firstName, home1, home2, phone, gpa, yrsExp);
        this.group=group;
        this.instrument=instrument;
    }
    
    /************************************************************************************************
     * Getters
     ***********************************************************************************************/
    public byte getGroup()
    {
        return this.group;
    }
    public String getInstrument()
    {
        return this.instrument;
    }

    /************************************************************************************************
     * Setters
     ***********************************************************************************************/
    public void setGroup(byte group)
    {
        this.group=group;
    }
    public void setInstrument(String instrument)
    {
        this.instrument=instrument;
    }

    /************************************************************************************************
     * toString()
     ***********************************************************************************************/
    public String toString()
    {
        String tmpGroup="";
        if ((group & ORCHESTRA) == ORCHESTRA)
            tmpGroup=tmpGroup.concat(" Orchestra");
        if ((group & BAND) == BAND)
            tmpGroup=tmpGroup.concat(" Band");
        if ((group & CHOIR) == CHOIR)
            tmpGroup=tmpGroup.concat(" Choir");
        
        return super.toString()+"\n"+
               "Musician: "+"\n"+
               "\tGroup:"+tmpGroup+"\n"+
               "\tInstrument: "+instrument;
    }
}
