/**
 * @author Sam Dale 
 * @version 3/12/2014
 * AP Computer Science
 * 
 * String Sort Lab: 
 */
public class StringTest
{
    public static void main()
    {
        String [] list={"fred","Ethel","?-?-?-?","{([])}","Lucy","ricky","book","*******","12345","     ","HEPHALUMP","bookkeeper","6789",";+<?","^^^^^^^^^^^","hephalump"};
        for (int i=0;i<list.length;i++)
            System.out.println(list[i]);
        System.out.println();
        
        String [] tmp=new String[16];
        
        tmp=StringSort.mergeSort(list);
        
        for (int i=0;i<tmp.length;i++)
            System.out.println(tmp[i]);
    }
}