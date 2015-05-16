/**
 * @author Sam Dale
 * @version 11/26/13
 * AP Computer Science
 */
public class Code
{
    private String myCode;
    private static String origCode;
    
    public Code(String code)
    {
        myCode=code;
        origCode=code;
    }
    
    public String getCode()
    {
        return myCode;
    }
    
    public void hide(int p1, int p2)
    {
        String currentString=myCode.substring(0,p1);
        for(int i=0;i<=p2-p1;i++)
            currentString=currentString.concat("X");
        myCode=currentString.concat(myCode.substring(p2+1,myCode.length()));
    }
    
    public void recover(int p1, int p2)
    {
        String currentString=myCode.substring(0,p1);
        for(int i=p1;i<=p2;i++)
            currentString=currentString.concat(""+origCode.charAt(i)); // The "" + the character concatenates a String, because a character cannot be concatenated to a String.
        myCode=currentString.concat(myCode.substring(p2+1,myCode.length()));
    }
    
    public String toString()
    {
        return myCode;
    }
}
