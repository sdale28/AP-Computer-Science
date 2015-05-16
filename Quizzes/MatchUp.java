/**
 * @author Sam Dale 
 * @version 2/13/2014
 * AP Computer Science
 * 
 * MatchUp: Quiz on Strings and Arrays.
 */
public class MatchUp
{
    public static void main()
    {
        String [] a = {"aa","bb","cc"};
        String [] b = {"aaa","xx","bb"};
        System.out.println("matchUp({\"aa\",\"bb\",\"cc\"}, {\"aaa\",\"xx\",\"bb\"}) -> "+matchUp(a, b));
        
        a = new String [] {"aa","bb","cc"};
        b = new String [] {"aaa","b","bb"};
        System.out.println("matchUp({\"aa\",\"bb\",\"cc\"}, {\"aaa\",\"b\",\"bb\"}) -> "+matchUp(a, b));
        
        a = new String [] {"aa","bb","cc"};
        b = new String [] {"","","ccc"};
        System.out.println("matchUp({\"aa\",\"bb\",\"cc\"}, {\"\",\"\",\"ccc\"}) -> "+matchUp(a, b));
        
        a = new String [] {"gg","fd","3333","Efads"};
        b = new String [] {"ggg","wd","34","Ess"};
        System.out.println("matchUp({\"gg\",\"fd\",\"3333\",\"Efads\"}, {\"ggg\",\"wd\",\"34\",\"Ess\"}) -> "+matchUp(a, b));
        
        a = new String [] {"ababa","bababa",""};
        b = new String [] {"boll","22",""};
        System.out.println("matchUp({\"ababa\",\"bababa\",\"\"}, {\"boll\",\"22\",\"\"}) -> "+matchUp(a, b));
    }

    public static int matchUp (String [] a, String [] b)
    {
        int match=0;
        for (int i=0; i<a.length; i++)
            if (a[i].length()>=1 && b[i].length()>=1 && a[i].charAt(0)==b[i].charAt(0))
                match++;
        return match;
    }
}