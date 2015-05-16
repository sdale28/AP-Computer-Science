/**
 * @author Sam Dale
 * @version 3/4/2014
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
    public static void main(String args[])
    {
        int [] array1=new int [100];
        int [] array2=new int [100]; //Create three original arrays, because otherwise selection sort would sort the array and insertion and merge would sort a sorted array.
        int [] array3=new int [100];
        System.out.println("Original Array: ");
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

        /***************************************************************************************************************************************************
         * Selection Sort (ints)
         **************************************************************************************************************************************************/
        int [] selArray=array1;
        Sort.mergeSort(selArray);

        System.out.println("Selection Sort: ");
        for (int i=0;i<selArray.length;i++) //Print out the new array.
        {
            System.out.print(selArray[i]+"\t");
            if ((i+1)%10==0)
                System.out.println();
        }
        System.out.println();

        /***************************************************************************************************************************************************
         * Insertion Sort (ints)
         **************************************************************************************************************************************************/
        System.out.println("Original Array: ");
        for (int i=0;i<array2.length;i++)
        {
            System.out.print(array2[i]+"\t");
            if ((i+1)%10==0)
                System.out.println();
        }
        System.out.println();

        int [] insArray=array2;
        Sort.insertionSort(insArray);

        System.out.println("Insertion Sort: ");
        for (int i=0;i<insArray.length;i++) //Print out the new array.
        {
            System.out.print(insArray[i]+"\t");
            if ((i+1)%10==0)
                System.out.println();
        }
        System.out.println();

        /***************************************************************************************************************************************************
         * Merge Sort (ints)
         **************************************************************************************************************************************************/
        System.out.println("Original Array: ");
        for (int i=0;i<array3.length;i++)
        {
            System.out.print(array3[i]+"\t");
            if ((i+1)%10==0)
                System.out.println();
        }
        System.out.println();

        int [] merArray=array3;
        Sort.mergeSort(merArray);

        System.out.println("Merge Sort: ");
        for (int i=0;i<merArray.length;i++) //Print out the new array.
        {
            System.out.print(merArray[i]+"\t");
            if ((i+1)%10==0)
                System.out.println();
        }

        /***************************************************************************************************************************************************
         * *************************************************************************************************************************************************
         * Selection Sort (Strings)
         * *************************************************************************************************************************************************
         **************************************************************************************************************************************************/

        String [] list={"fred","Ethel","?-?-?-?","{([])}","Lucy","ricky","book","*******","12345","     ","HEPHALUMP","bookkeeper","6789",";+<?","^^^^^^^^^^^","hephalump"};
        String [] tmp=new String[list.length];

        /***************************************************************************************************************************************************
         * Selection Sort (Strings)
         **************************************************************************************************************************************************/
        System.out.println("Original Array: ");
        for (int i=0;i<list.length;i++)
            System.out.println(list[i]);
        System.out.println();

        tmp=Sort.selectionSort(list);
        System.out.println("Selection Sort: ");
        for (int i=0;i<tmp.length;i++)
            System.out.println(tmp[i]);
        System.out.println();

        /***************************************************************************************************************************************************
         * Insertion Sort (Strings)
         **************************************************************************************************************************************************/
        System.out.println("Original Array: ");
        for (int i=0;i<list.length;i++)
            System.out.println(list[i]);
        System.out.println();

        tmp=Sort.insertionSort(list);
        System.out.println("Insertion Sort: ");
        for (int i=0;i<tmp.length;i++)
            System.out.println(tmp[i]);
        System.out.println();

        /***************************************************************************************************************************************************
         * Merge Sort (Strings)
         **************************************************************************************************************************************************/
        System.out.println("Original Array: ");
        for (int i=0;i<list.length;i++)
            System.out.println(list[i]);
        System.out.println();

        tmp=Sort.mergeSort(list);
        System.out.println("Merge Sort: ");
        for (int i=0;i<tmp.length;i++)
            System.out.println(tmp[i]);
    }
}