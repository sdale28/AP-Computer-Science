/**
 * @author Sam Dale
 * @version 11/1/13
 * AP Computer Science
 *
 * Lab8b: Put the following list of strings in lexicographic order as if determined by the compareTo
 * method of the String class. Consult a Unicode chart (google it) for the proper order.
 */
import java.util.*;
public class Lab8b
{
    public static void main(String args[])
    {
        System.out.println("Lexicographic Order");
        String temporary="";
        String[] list={"fred","Ethel","?-?-?-?","{([])}","Lucy","ricky","book","*****","     ","HEPHALUMP","bookkeeper","6789",",+<?","hemhalump"};
        for (int i=0;i<=13;i++)
        {
            for (int j=i+1;j<=13;j++)
            {
                if(list[j].compareTo(list[i])<0)
                {
                    temporary=list[i];
                    list[i]=list[j];
                    list[j]=temporary;
                }
             }
        }

        for (int k=0;k<=13;k++)
            System.out.println(list[k]);
    }
}