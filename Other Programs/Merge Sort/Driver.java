/**
 * @author Sam Dale 
 * @version 3/10/2014
 * AP Computer Science
 * 
 * Merge sort: Create an array of 100 random numbers using Math.random*100. Create method mergeSort 
 * (and use the merge sort). Print the original array and the sorted array.
 */
public class Driver
{
    public static void main()
    {
        int [] array={5,9,2,1,2,4,3,7};
        for (int i=0;i<array.length;i++)
            System.out.print(array[i]);
        System.out.println();
        
        mergeSort(array);
        
        for (int i=0;i<array.length;i++)
            System.out.print(array[i]);
    }
    
    //---------------------------------------------------------------------------------------------------
    // Sorts the specified array of integers using merge sort.
    //---------------------------------------------------------------------------------------------------
    public static void mergeSort(int[] numbers)
    {
        doMergeSort(numbers, 0, numbers.length-1);
    }
    
    //---------------------------------------------------------------------------------------------------
    // Recursively sorts the portion of the given array beginning at start and ending at end.
    //---------------------------------------------------------------------------------------------------
    public static void doMergeSort(int[] numbers, int start, int end)
    {
        if (start<end)
        {
            int middle=(start+end)/2;
            doMergeSort(numbers, start, middle);
            doMergeSort(numbers, middle+1, end);
            merge(numbers, start, middle, end);
        }
    }
    
    //---------------------------------------------------------------------------------------------------
    // Merges in sorted order the two sorted subarrays [start, middle] and [middle+1, end].
    //---------------------------------------------------------------------------------------------------
    public static void merge(int[] numbers, int start, int middle, int end)
    {
        // This temporary array will be used to build the merged list.
        int [] tmp=new int[end-start+1];
        
        int index1=start;
        int index2=middle+1;
        int indexTmp=0;
        
        //Loop until one of the sublists is exhausted, adding the smaller of the first elements of each sublist to the merged list.
        while (index1<=middle && index2<=end)
        {
            if (numbers[index1]<numbers[index2])
            {
                tmp[indexTmp]=numbers[index1];
                index1++;
            }
            else
            {
                tmp[indexTmp]=numbers[index2];
                index2++;
            }
            indexTmp++;
        }
        
        //Add to the merged list the remaining elementsof whichever sublist is not yet exhausted.
        while (index1<=middle)
        {
            tmp[indexTmp]=numbers[index1];
            index1++;
            indexTmp++;
        }
        while (index2<=end)
        {
            tmp[indexTmp]=numbers[index2];
            index2++;
            indexTmp++;
        }
        
        //Copy the merged list from tmp into numbers.
        for (indexTmp=0;indexTmp<tmp.length;indexTmp++)
            numbers[start+indexTmp]=tmp[indexTmp];
    }
}