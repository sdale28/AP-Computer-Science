/**
 * @author Sam Dale 
 * @version 9/30/13
 * AP Computer Science
 * 
 * Lab 3e: Create versions of the Stars program to print a diamond pattern.
 */
import java.util.*;
public class Lab3e
{
    public static void main(){
        System.out.println("Create a Diamond of Stars. Enter 0 to end program.");
        boolean run=true;
        while (run==true){ //End program at a sentinel set at 0.
            Scanner scan=new Scanner(System.in);
            System.out.print("Input an integer to make a diamond of stars: ");
            int input=scan.nextInt();
            if (input%2==0 && input!=0) //Subtract one of input if an even number, or else it can't print stars correctly.
                input--;
            else if (input==0){
                System.out.println("Program ended.");
                run=false;
            }
            int stars=input-1; //Maximum number of stars. Subtract 2 until greater than 0 (so input-1).
            int spaces=input/2; //Maximum number of spaces. Half of input is the spaces needed on left side.
            for (int i=input;i>0;i--) //For loop creates the number of lines.
            {
                for(int j=Math.abs(spaces);j>0;j--){ //For loop prints number of spaces.
                    System.out.print(" ");
                }
                spaces--;
                for(int k=input-Math.abs(stars);k>0;k--){ //For loop prints number of stars.
                    System.out.print("*");
                }
                stars-=2;
                System.out.println();
            }
        }
    }
}