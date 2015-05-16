/**
 * @author Sam Dale 
 * @version 11/24/13
 * AP Computer Science
 * 
 * Lab 3d: Create versions of the Stars program to print a triangle pattern.
 */
public class Lab3d
{
    public static void main(){
        for (int rows=9;rows>=0;rows--){ //For loop gives number of lines.
            for (int spaces=rows;spaces>=1;spaces--){ //For loop prints spaces.
                System.out.print(" ");
            }
            for (int stars=9-rows;stars>=0;stars--){ //For loop prints stars.
                System.out.print("*");
            }
            System.out.println();
        }
    }
}