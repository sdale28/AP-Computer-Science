/**
 * @author Sam Dale 
 * @version 5/27/2014
 * AP Computer Science
 * 
 * p. 311: 5.9:
 * Redesign and implement a version of the PalindromeTester
 * program from Chapter 3 so that it uses dialog boxes to get the 
 * input string, display the results, and ask whther the user wants
 * to test another palindrome.
 */
import javax.swing.JOptionPane;
public class PalindromeTester
{
    public static void main()
    {
        int again=JOptionPane.YES_OPTION;
        while(again==JOptionPane.YES_OPTION)
        {
            String input=JOptionPane.showInputDialog("String to test for being palindromic: ");
            if (input!=null)
            {
                String result="Result: Palindromic.";
                for (int i=0;i<input.length()/2;i++)
                    if (input.charAt(i)!=input.charAt(input.length()-i-1))
                        result="Result: Not a palindrome.";
                JOptionPane.showMessageDialog(null, result);
                again=JOptionPane.showConfirmDialog(null, "Do Another?");
            }
            else
                again=JOptionPane.NO_OPTION;
        }
    }
}