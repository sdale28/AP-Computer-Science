/**
 * @author Sam Dale 
 * @version 9/20/13
 * AP Computer Science
 * 
 * Lab 3b: Use nested loops to produce a matrix (of related numbers) output.
 */
public class Lab3b
{
    public static void main(){
        for (int rows=2;rows<6;rows++){ //Print five lines.
            for (int collumns=1;collumns<6;collumns++) //Print out the collumns. 
                System.out.print(collumns*rows+"\t");
            System.out.print("\n");
        }
    }
}