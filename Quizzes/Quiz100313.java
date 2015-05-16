/**
 * @author Sam Dale
 * @version 10/3/13
 * AP Computer Science
 *
 * A quiz on data types and operators.
 */
public class Quiz100313
{
    public static void main(String args[])
    {
        int length=25;
        int width=42;
        double price=32.00;
        double total=(length*width)/9.00*price; //The length*width of the room is the area, but in square feet, so I divide by 9 to get the square yard equivalent.
        System.out.println("The price of carpeting the room is: $" + Math.floor(total*100)/100); //Math.floor gives the value of the double to the nearest integer, so to get two decimals, I had to use Math.floor and then divide by 100.
    }
}