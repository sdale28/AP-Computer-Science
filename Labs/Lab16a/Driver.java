/**
 * @author Sam Dale 
 * @version 1/30/2014
 * AP Computer Science
 *
 * Lab16a: Practice using bit-masking techniques using the examples of files being readable (r),
 * writable (w), and executable (x). Make three files (creating a File class first) and give them
 * the different user capabilities of r, w, and x. Then modify these and add w, x, and r, respecitively.
 * Also, practice using the Date class and Thread.sleep();
 */
import java.util.*;
public class Driver
{
    public static void main() throws InterruptedException //Throwing this exception allows the Thread.sleep to be used.
    {
        File file1=new File("File 1",new Date(),new Date(),File.READ);
        System.out.println(file1);
        File file2=new File("File 2",new Date(),new Date(),File.WRITE);
        System.out.println(file2);
        File file3=new File("File 3",new Date(),new Date(),File.EXECUTE);
        System.out.println(file3);
        System.out.println();
        
        System.out.println("Modified: ");
        
        Thread.sleep(1000);
        file1.setProtectionMask(File.WRITE,new Date());
        System.out.println(file1);
        
        Thread.sleep(1000);
        file2.setProtectionMask(File.EXECUTE,new Date());
        System.out.println(file2);
        
        Thread.sleep(1000);
        file3.setProtectionMask(File.READ,new Date());
        System.out.println(file3);
    }
}