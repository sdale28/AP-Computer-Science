/**
 * @author Sam Dale 
 * @version 2/28/2014
 * AP Computer Science
 * 
 * Insertion sort: Create an array of 100 random numbers using Math.random*100. Create method insertionSort 
 * (and use the insertion sort). Print the original array and the sorted array.
 */
public class Driver
{
    public static void main()
    {
        int [] array=new int [100];
        for (int i=0;i<array.length;i++)
        {
            array[i]=(int)(Math.random()*100);
            System.out.print(array[i]+"\t");
            if ((i+1)%10==0)
                System.out.println();
        }
        System.out.println();
        
        insertionSort(array);
        
        for (int i=0;i<array.length;i++) //Print out the new array.
        {
            System.out.print(array[i]+"\t");
            if ((i+1)%10==0)
                System.out.println();
        }
    }
    
    public static void insertionSort(int[] numbers)
    {
        for (int index=1; index<numbers.length; index++)
        {
            int key=numbers[index];
            int position=index;
            
            // shift larger values to the right
            while (position>0 && numbers[position-1]>key)
            {
                numbers[position]=numbers[position-1];
                position--;
            }
            
            numbers[position]=key;
        }
    }
}