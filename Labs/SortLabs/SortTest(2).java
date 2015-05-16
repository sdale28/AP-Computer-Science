/**
 * @author Sam Dale 
 * @version 2/28/2014
 * AP Computer Science
 * 
 * Sort Labs: 
 * Create an array of 100 random integers (using Math.random()*100).
 * Create methods selectionSort, insertionSort, and mergeSort in the in a class called Sort.
 * Print the original each time before printing the newly sorted array.
 * Goal: to learn the sorting methods of selection sort, insertion sort, and merge sort.
 */
public class SortTest
{
    public static void main()
    {
        //Create original array: 
        int [] array1=new int [100];
        int [] array2=new int [100];
        int [] array3=new int [100];
        for (int i=0;i<array1.length;i++)
        {
            array1[i]=(int)(Math.random()*100);
            array2[i]=array1[i];
            array3[i]=array1[i];
            System.out.print(array1[i]+"\t");
            if ((i+1)%10==0)
                System.out.println();
        }
        System.out.println();
        
        //Selection Sort: 
        int [] selArray=array1;
        Sort.mergeSort(selArray);
        
        for (int i=0;i<selArray.length;i++) //Print out the new array.
        {
            System.out.print(selArray[i]+"\t");
            if ((i+1)%10==0)
                System.out.println();
        }
        System.out.println();
        
        //Insertion Sort: 
        for (int i=0;i<array2.length;i++)
        {
            System.out.print(array2[i]+"\t");
            if ((i+1)%10==0)
                System.out.println();
        }
        System.out.println();
        
        int [] insArray=array2;
        Sort.insertionSort(insArray);
        
        for (int i=0;i<insArray.length;i++) //Print out the new array.
        {
            System.out.print(insArray[i]+"\t");
            if ((i+1)%10==0)
                System.out.println();
        }
        System.out.println();
        
        //Merge Sort: 
        for (int i=0;i<array3.length;i++)
        {
            System.out.print(array3[i]+"\t");
            if ((i+1)%10==0)
                System.out.println();
        }
        System.out.println();
        
        int [] merArray=array3;
        Sort.mergeSort(merArray);
        
        for (int i=0;i<merArray.length;i++) //Print out the new array.
        {
            System.out.print(merArray[i]+"\t");
            if ((i+1)%10==0)
                System.out.println();
        }
    }
}