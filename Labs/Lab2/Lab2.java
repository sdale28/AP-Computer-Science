/**
 * @author Sam Dale
 * @version 9/11/13
 * AP Computer Science
 * Lab2: Practice using methods by writing out the lyrics of a repetitive song.
 */
public class Lab2
{
   public static void main(){
   System.out.println("There was an old lady who swallowed a fly.");
   printRefrain();
   System.out.println("There was an old lady who swallowed a spider.");
   System.out.println("That wriggled and iggled and jiggled inside her.");
   printSpiderFly();
   printRefrain();
   System.out.println("There was an old lady who swallowed a bird.");
   System.out.println("How absurd to swallow a bird.");
   printBirdSpider();
   printSpiderFly();
   printRefrain();
   System.out.println("There was an old lady who swallowed a cat,");
   System.out.println("Imagine that to swallow a cat.");
   printCatBird();
   printBirdSpider();
   printSpiderFly();
   printRefrain();
   System.out.println("There was an old lady who swallowed a dog.");
   System.out.println("What a hog to swallow a dog.");
   System.out.println("She swallowed the dog to catch the cat,");
   printCatBird();
   printBirdSpider();
   printSpiderFly();
   printRefrain();
   System.out.println("There was an old lady who swallowed a horse.");
   System.out.println("She died of course.");
   }
   
   public static void printRefrain(){
   System.out.println("I don't know why she swallowed that fly,");
   System.out.println("Perhaps she'll die.");
   System.out.println();
   }
   
   public static void printSpiderFly(){
   System.out.println("She swallowed the spider to catch the fly,");
   }
    
   public static void printBirdSpider(){
   System.out.println("She swallowed the bird to catch the spider,");
   }
   
   public static void printCatBird(){
   System.out.println("She swallowed the cat to catch the bird,");
   }
}
