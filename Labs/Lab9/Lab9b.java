/**
 * @author Sam Dale 
 * @version 12/10/13
 * AP Computer Science
 * 
 * Lab9b: Sums
 * Create a 4x5 matrix of random numbers.
 * Print out the sum of each row, column, and the total.
 */
import java.util.*;
public class Lab9b
{
    public static void main()
    {
        System.out.println("Sums");
        System.out.println();
        
        Random rand=new Random();
        Scanner scan=new Scanner(System.in);
        int rowNum=Util.intScan(scan,"Number of Rows: ");
        int columnNum=Util.intScan(scan,"Number of columns: ");
        System.out.println();
        
        int [][] intMatrix=new int [rowNum][columnNum];
        int [] rows=new int [intMatrix.length]; //Allows to easily make the matrix longer. Uses the number of arrays in in the 2-dimensional array.
        int [] columns=new int [intMatrix[0].length]; //Allows to easily make the matrix larger. Uses number of elements in the first row to know how many columns there are.
        int total=0;
        
        for (int i=0;i<intMatrix.length;i++) //Generate the matrix.
        {
            for (int j=0;j<intMatrix[i].length;j++)
            {
                intMatrix[i][j]=rand.nextInt(20)+1;
                rows[i]+=intMatrix[i][j]; //Add to each specific row.
                total+=intMatrix[i][j]; //Add to the total.
                System.out.print(intMatrix[i][j]+"\t");
            }
            System.out.println();
        }
        System.out.println();
        
        for (int i=0;i<rows.length;i++) //Print out the sum of each row.
            System.out.println("Row "+(i+1)+" = "+rows[i]);
        System.out.println();
        
        for (int j=0;j<columns.length;j++) //Add to and print out the columns columns.
        {
            for (int i=0;i<rows.length;i++)
                columns[j]+=intMatrix[i][j];
            System.out.println("column "+(j+1)+" = "+columns[j]);
        }
        System.out.println();
        
        System.out.println("Total = "+total);
    }
}