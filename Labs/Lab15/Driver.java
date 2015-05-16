/**
 * @author Sam Dale 
 * @version 1/24/14
 * AP Computer Science
 * 
 * Lab14: Learn how to use Abstract Classes and the properties of Inheritance. 
 * Lab15: Adding to Lab14, learn how to override methods.
 */
import java.util.*;
public class Driver
{
    public static void main()
    {
        Cat cat=new Cat(Animal.FEMALE,"Long","Mittens");
        System.out.println(cat);
        System.out.println(cat.speak());
        
        Dog dog=new Dog(Animal.MALE,"Short","Spot");
        System.out.println(dog);
        System.out.println(dog.speak());
        
        Robin robin=new Robin(Animal.FEMALE,!Bird.CANFLY,"Tweeter"); //Cannot fly, because !Bird.CANFLY.
        System.out.println(robin);
        System.out.println(robin.speak());
        
        Crow crow=new Crow(Animal.MALE,Bird.CANFLY,"McCaw");
        System.out.println(crow);
        System.out.println(crow.speak());
    }
}