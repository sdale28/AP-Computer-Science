/**
 * @author Sam Dale
 * @version 11/1/13
 * AP Computer Science
 * 
 * Lab8c: Pig Latin
 * write a pig latin translator for the sentence "Are you going to a game?" The output 
 * should be "Are ou-yay oing-gay o-tay a ame-gay?" Pig latin translation only occurs on words 
 * that begin with a consonant. Tokenize the original string into an array of words. Ten, for each
 * word, translate it and concatenate it onto a final String called pigLatin.
 */
import java.util.*;
public class Lab8c
{
    public static void main()
    {
        System.out.println("Pig Latin");
        System.out.println("Enter a sentence to have it translated to Pig Latin.");
        boolean run=true;
        while (run)
        {
            System.out.println();
            System.out.print("Sentence (enter 0 to end): ");
            Scanner scan=new Scanner(System.in);
            String input=scan.nextLine();
            if (input.charAt(0)=='0')
            {
                run=false;
                System.out.println("Program ended.");
            }
            else
            {
                StringTokenizer tokens=new StringTokenizer(input," ?.!,");
                String currentToken="";
                String pigLatin="";
                while(tokens.hasMoreTokens())
                {
                    currentToken=tokens.nextToken();
            
                    if (currentToken.toLowerCase().charAt(0)!='a' && currentToken.toLowerCase().charAt(0)!='e' && currentToken.toLowerCase().charAt(0)!='i' && currentToken.toLowerCase().charAt(0)!='o' && currentToken.toLowerCase().charAt(0)!='u')
                        pigLatin=pigLatin.concat(currentToken.substring(1)+"-"+currentToken.charAt(0)+"ay");
                    else
                        pigLatin=pigLatin.concat(currentToken);
            
                    if (tokens.hasMoreTokens()==true)
                        pigLatin=pigLatin.concat(" ");
                }
        
                if (input.charAt(input.length()-1)=='.' || input.charAt(input.length()-1)=='?' || input.charAt(input.length()-1)=='!')
                    pigLatin=(pigLatin+input.charAt(input.length()-1));
        
                System.out.println("Translation: "+pigLatin);
            }
        }
    }
}