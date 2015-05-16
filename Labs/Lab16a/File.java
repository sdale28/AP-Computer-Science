/**
 * @author Sam Dale
 * @version 1/30/2014
 * AP Computer Science
 */
import java.util.*;
public class File
{
    public static final byte READ=00000001;
    public static final byte WRITE=00000010;
    public static final byte EXECUTE=00000100;
    
    private String name;
    private Date dateCreated;
    private Date dateModified;
    private byte protectionMask;
    
    public File (String name, Date dateCreated, byte protectionMask)
    {
        this.name=name;
        this.dateCreated=dateCreated;
        this.dateModified=this.dateCreated;
        this.protectionMask=protectionMask;
    }
    
    /***************************************************************************************************************
     * getProtectionMask()
     **************************************************************************************************************/
    public byte getProtectionMask()
    {
        return this.protectionMask;
    }
    
    /***************************************************************************************************************
     * setProtectionMask()
     *************************************************************************************************************/
    public void setProtectionMask(byte protectionMask, Date dateModified)
    {
        this.protectionMask|=protectionMask;
        this.dateModified=dateModified;
    }
    
    /***************************************************************************************************************
     * toString()
     **************************************************************************************************************/
    public String toString()
    {
        String tmpProtection="";
        if ((protectionMask & READ)==READ)
            tmpProtection=tmpProtection.concat("r");
        if ((protectionMask & WRITE)==WRITE)
            tmpProtection=tmpProtection.concat("w");
        if ((protectionMask & EXECUTE)==EXECUTE)
            tmpProtection=tmpProtection.concat("x");
        
        return name+": "+"\n"+
               "\tCreated: "+dateCreated+"\n"+
               "\tLast Modified: "+dateModified+"\n"+
               "\tProtection: "+tmpProtection;
    }
}