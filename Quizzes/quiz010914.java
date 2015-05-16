/**
 * @author Sam Dale
 * @version 1/9/14
 * quiz010914: Cigar Party
 */
public class quiz010914
{
    public static void main(String args[])
    {
        System.out.println("cigarParty(30, false) -> "+cigarParty(30,false));
        System.out.println("cigarParty(50, false) -> "+cigarParty(50,false));
        System.out.println("cigarParty(70, true) -> "+cigarParty(70,true));
    }

    public static boolean cigarParty(int cigars, boolean isWeekend)
    {
        boolean returnVal=false;
        if (!isWeekend && cigars>=40 && cigars<=60)
            returnVal=true;
        else if (isWeekend && cigars>=40)
            returnVal=true;
        return returnVal;
    }
}
