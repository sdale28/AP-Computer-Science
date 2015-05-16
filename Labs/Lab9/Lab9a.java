/**
 * @author Sam Dale
 * @version 12/10/13
 * AP Computer Science
 *
 * Lab9a: Grad Calculator
 * Create four arrays, called names, avgScores, categories, and grade.
 * Have the user enter the name; average scores for daily assignments, quizzes, and tests.
 * Use matrix multiplication to fill in the grade array.
 * Print out all of the grade information.
 * Goal: Practice using 2-dimensional arrays.
 */
import java.util.*;
public class Lab9a
{
    public static void main(String args[])
    {
        System.out.println("Grade Calculator");
        System.out.println();

        Scanner scan=new Scanner(System.in).useDelimiter("\n");
        int numStudents=Util.intScan(scan,"Number of students to enter: ");
        System.out.println();

        String [] names=new String[numStudents];
        double [][] avgScores=new double [numStudents][3];
        double [] categories={10,40,50};
        double [] grade=new double [numStudents];

        for (int i=0;i<numStudents;i++)
        {
            System.out.print("Name of student "+(i+1)+": ");
            names[i]=scan.next();
            avgScores[i][0]=Util.doubleScan(scan,names[i]+"'s daily assignment grade: ");
            avgScores[i][1]=Util.doubleScan(scan,names[i]+"'s average quiz grade: ");
            avgScores[i][2]=Util.doubleScan(scan,names[i]+"'s average test grade: ");

            for(int j=0;j<categories.length;j++)
                grade[i]+=(categories[j]*avgScores[i][j])/100;

            System.out.println();
        }

        System.out.println("Name\t\t\tDaily\tQuiz\tTest");
        for (int i=0;i<numStudents;i++)
            System.out.println(names[i]+"\tAvg scores: \t"+avgScores[i][0]+"\t"+avgScores[i][1]+"\t"+avgScores[i][2]+"\tFinal grade: "+grade[i]+"%");
    }
}