/**
 * @author Sam Dale
 * @version 11/14/13
 * AP Computer Science
 *
 * Quiz111413: Write a program that computes the average value of
 * numbers in the elements of an array.
 */
public class Quiz111413
{
    public static void main(String args[])
    {
        int [] list={2,4,6,8,10,12,14,16,18,20};
        double average=computeAvg(list);
        System.out.println("Average = "+average);
    }

    public static double computeAvg(int [] list)
    {
        double average=0;
        double total=0;
        for (int i=0;i<list.length;i++) //Using the .length property of an array allows this program to be easily modified to accomodate more or less data entries.
            total+=list[i];
        average=total/(list.length);
        return average;
    }
}
