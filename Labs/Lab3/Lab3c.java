/**
 * @author Sam Dale
 * @version 9/20/13
 *
 * Lab 3c: Create versions of the Stars program to print an upside down triangle pattern.
 */
public class Lab3c
{
    public static void main(String args[]){
        for (int rows=9;rows>=0;rows--){ //For loop prints 10 lines.
            for (int stars=rows;stars>=0;stars--){ //For loop prints stars on each line.
                System.out.print("*");
            }
            System.out.println();
        }
    }
}