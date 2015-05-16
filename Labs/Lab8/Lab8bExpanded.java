/**
 * @author Sam Dale
 * @version 11/1/13
 * AP Computer Science
 *
 * Lab8b: Put the following list of strings in lexicographic order as if determined by the compareTo
 * method of the String class. Consult a Unicode chart (google it) for the proper order.
 */
import java.util.*;
public class Lab8bExpanded
{
    public static void main(String args[])
    {
        System.out.println("Lexicographic Order");
        String temporary="";
        System.out.print("Number of strings you want to order: ");
        Scanner scan=new Scanner(System.in);
        int numberOfStrings=Integer.parseInt(scan.nextLine());
        String[] list=new String[numberOfStrings];
        for (int i=0;i<list.length;i++)
        {
            System.out.print("Input: ");
            list[i]=scan.nextLine();
        }
        System.out.println();
        for (int i=0;i<list.length;i++)
        {
            for (int j=i+1;j<list.length;j++)
            {
                if(list[j].compareTo(list[i])<0)
                {
                    temporary=list[i];
                    list[i]=list[j];
                    list[j]=temporary;
                }
             }
        }

        for (int k=0;k<list.length;k++)
            System.out.println(list[k]);
    }
}