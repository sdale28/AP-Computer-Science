/**
 * @author Sam Dale 
 * @version 9/30/13
 * AP Computer Science
 * 
 * Lab 3a: Read an integer value and print the sum of all even integers between 2 and the input value,
 * inclusive. Print an error message if the input value is less than 2. Prompt the user accordingly.
 */
import java.util.*;
public class Lab3a
{
    public static void main(){
        System.out.println("Add all positive even integers less than or equal to an integer.");
        System.out.println("Enter 0 to end program.");
        boolean run=true;
        while (run){ //Prompts user again until sentinel (0) entered.
            Scanner scan=new Scanner(System.in);
            System.out.print("Enter an integer: ");
            int input=scan.nextInt();
            if (input>=2)
            {            
                int sum=0;
                System.out.print("Sum = ");
                
                for (int i=2;i<=input;i+=2){
                    if (i<input-1)
                        System.out.print(i + " + ");
                    else
                        System.out.print(i + " =");
                    
                    sum+=i;
                }
                    
                System.out.println(" "+sum);
            }
        
            else if (input<2 && input!=0)
                System.out.println("Error: you inputed an integer less than two.");
            
            else if (input==0)
            {    
                System.out.println("Program ended.");
                run=false; //End program at a set sentinel (0). 
            }
        }
    }
}