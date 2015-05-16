/**
 * @author Sam Dale 
 * @version 3/13/2014
 * AP Computer Science
 */
public class StringSort
{
    /*****************************************************************
     * Selection Sort
     ****************************************************************/
    public static String [] selectionSort(String[] list)
    {
        for(int index=0;index<list.length-1; index++)
        {
            int min=index;
            for(int scan=index+1;scan<list.length; scan++)
                if (list[scan].compareTo(list[min])<0)
                    min=scan;
            
            //Swap the values
            String temp=list[min];
            list[min]=list[index];
            list[index]=temp;
        }
        return list;
    }
    
    /*****************************************************************
     * Insertion Sort
     ****************************************************************/
    public static String [] insertionSort(String[] list)
    {
        for (int index=1; index<list.length; index++)
        {
            String key=list[index];
            int position=index;
            
            // shift larger values to the right
            while (position>0 && list[position-1].compareTo(key)<0)
            {
                list[position]=list[position-1];
                position--;
            }
            
            list[position]=key;
        }
        return list;
    }
    
    /*****************************************************************
     * Merge Sort
     ****************************************************************/
    //---------------------------------------------------------------------------------------------------
    // Sorts the specified array of Strings using merge sort.
    //---------------------------------------------------------------------------------------------------
    public static String [] mergeSort(String[] list)
    {
        doMergeSort(list, 0, list.length-1);
        return list;
    }
    
    //---------------------------------------------------------------------------------------------------
    // Recursively sorts the portion of the given array beginning at start and ending at end.
    //---------------------------------------------------------------------------------------------------
    public static String [] doMergeSort(String[] list, int start, int end)
    {
        if (start<end)
        {
            int middle=(start+end)/2;
            doMergeSort(list, start, middle);
            doMergeSort(list, middle+1, end);
            merge(list, start, middle, end);
        }
        return list;
    }
    
    //---------------------------------------------------------------------------------------------------
    // Merges in sorted order the two sorted subarrays [start, middle] and [middle+1, end].
    //---------------------------------------------------------------------------------------------------
    public static String [] merge(String[] list, int start, int middle, int end)
    {
        // This temporary array will be used to build the merged list.
        String [] tmp=new String[end-start+1];
        
        int index1=start;
        int index2=middle+1;
        int indexTmp=0;
        
        //Loop until one of the sublists is exhausted, adding the smaller of the first elements of each sublist to the merged list.
        while (index1<=middle && index2<=end)
        {
            if (list[index1].compareTo(list[index2])<0)
            {
                tmp[indexTmp]=list[index1];
                index1++;
            }
            else
            {
                tmp[indexTmp]=list[index2];
                index2++;
            }
            indexTmp++;
        }
        
        //Add to the merged list the remaining elementsof whichever sublist is not yet exhausted.
        while (index1<=middle)
        {
            tmp[indexTmp]=list[index1];
            index1++;
            indexTmp++;
        }
        while (index2<=end)
        {
            tmp[indexTmp]=list[index2];
            index2++;
            indexTmp++;
        }
        
        //Copy the merged list from tmp into numbers.
        for (indexTmp=0;indexTmp<tmp.length;indexTmp++)
            list[start+indexTmp]=tmp[indexTmp];
        
        return list;
    }
}