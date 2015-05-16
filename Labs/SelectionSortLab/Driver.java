/**
 * @author Sam Dale 
 * @version 2/28/2014
 * AP Computer Science
 * 
 * Selection sort: Create an array of 100 random numbers using Math.random*100. Create method selectionSort 
 * (and use the selection sort). Print the original array and the sorted array.
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
        
        selectionSort(array);
        
        for (int i=0;i<array.length;i++) //Print out the new array.
        {
            System.out.print(array[i]+"\t");
            if ((i+1)%10==0)
                System.out.println();
        }
    }
    
    public static void selectionSort(int[] numbers)
    {
        for(int index=0;index<numbers.length-1; index++)
        {
            int min=index;
            for(int scan=index+1;scan<numbers.length; scan++)
                if (numbers[scan]<numbers[min])
                    min=scan;
            
            //Swap the values
            int temp=numbers[min];
            numbers[min]=numbers[index];
            numbers[index]=temp;
        }
    }
}