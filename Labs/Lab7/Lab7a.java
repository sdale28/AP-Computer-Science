/**
 * @author Sam Dale 
 * @version 10/21/13
 * AP Computer Science
 * 
 * Lab7a: Test Scores
 * Compute average test scores.
 * Prompt the user for the number of scores to be entered. Declare an array of that size.
 * Prompr the user for test scores.
 * Compute the average score. Print all scores and the average score.
 */
import java.util.*;
public class Lab7a
{
    public static void main()
    {
        System.out.println("Test Scores");
        System.out.println();
        Scanner scan=new Scanner(System.in);
        int numberOfTests=numberOfTests(scan);
        double[] tests=new double[numberOfTests];
        for (int i=0;i<tests.length;i++) //For loop for entering scores.
        {
            tests[i]=enterScore(scan,i);
        }
        System.out.println();
        
        System.out.println("Your scores:");
        for (int j=0;j<tests.length;j++) //For loop prints out all of the scores at the bottom.
        {
            System.out.println(tests[j]);
        }
        System.out.println("-------");
        double average=calculateAverage(tests);
        System.out.println("Average = "+average);
    }
    
    public static int numberOfTests(Scanner scan)
    {
        boolean run=true;
        int numberOfTests=0;
        String satisfy;
        while (run)
        {
            try
            {
                System.out.print("Number of test scores: ");
                numberOfTests=scan.nextInt();
                run=false;
            }
            catch(Exception ex) //Catch to make sure that the user inputs a integer for the number of test scores (not something else).
            {
                System.out.println("Please enter a number.");
                run=true;
                satisfy=scan.next(); //Satisfy the read.
            }
        }
        return numberOfTests;
    }
    
    public static double enterScore(Scanner scan,int i)
    {
        boolean run=true;
        double score=0;
        String satisfy;
        while (run)
        {
            try
            {
                System.out.print("Test score "+(i+1)+": ");
                score=scan.nextDouble();
                run=false;
            }
            catch(Exception ex) //Catch to make sure that the user inputs a number for each score (not something else).
            {
                System.out.println("Please enter a number.");
                run=true;
                satisfy=scan.next(); //Satisfy the read.
            }
        }
        return score;
    }
    
    public static double calculateAverage(double[] tests)
    {
        double sum=0;
        for (int i=0;i<tests.length;i++)
            sum+=tests[i];
        return sum/tests.length;
    }
}
