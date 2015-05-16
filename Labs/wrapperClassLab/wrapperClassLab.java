/**
 * @author Sam Dale 
 * @version 1/20/14
 * AP Computer Science
 * 
 * Wrapper Class Lab: Practice using the wrapper class to put int's into an ArrayList, 
 * which requires objects (so must add Integers not just int's).
 */
import java.util.*;
public class wrapperClassLab
{
    public static void main()
    {
        ArrayList <Integer> nums=new ArrayList<Integer>();
        for (int i=1;i<=100;i++) //Create array of 1-100.
            nums.add(i);
        
        int count=0;
        for (int row=0;count<nums.size();row++) //Print initial array.
        {
            for (int column=0;column<10;column++)
                System.out.print(nums.get(count++)+"\t");
            System.out.println();
        }
        System.out.println();
        
        for (int i=0;i<nums.size();i++) //Print the addition.
        {
            if (nums.get(i)!=5 && nums.get(i)%5==0)
                System.out.print(" + "+nums.get(i));
            else if (nums.get(i)%5==0) //I want a preceding "+" on everything except the five.
                System.out.print(nums.get(i));
        }
        
        int sum=0;
        for (int i=nums.size()-1;i>=0;i--) //Remove numbers not evenly divisible by 5 in the array.
        {
            if (nums.get(i)%5==0)
                sum+=nums.get(i);
            else
                nums.remove(i);
        }
        System.out.println(" = "+sum);
        System.out.println();
        
        int count2=0;
        for (int row=0;count2<nums.size();row++) //Print out the final array.
        {
            for (int column=0;column<5;column++)
                System.out.print(nums.get(count2++)+"\t");
            System.out.println();
        }
    }
}