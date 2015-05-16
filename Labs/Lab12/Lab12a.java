/**
 * @author Sam Dale 
 * @version 12/16/13
 * AP Computer Science
 * 
 * Lab12a: 
 * Experiment with dividing by zero with intgers and floats. Catch the exception for divide-by-zero error
 * with integers. Experiment with dividing by zero with doubles. Use the table in the Liang handout as a reference.
 */
public class Lab12a
{
    public static void main()
    {
        System.out.println("Integers: ");
        try
        {
            int one=1;
            int zero=0;
            int divide=one/zero;
            System.out.println(divide);
        }
        catch (ArithmeticException e)
        {
            System.out.println(e);
        }
        System.out.println();
        
        System.out.println("Floats: ");
        double one=1.0;
        double zero=0.0;
        double divide=one/zero;
        System.out.println(divide);
    }
}