/**
 * @author Sam Dale
 * @version 2/20/14
 * AP Computer Science
 *
 * Lab14: Learn how to use Abstract Classes and the properties of Inheritance.
 * Lab15: Adding to Lab14, learn how to override methods.
 * Lab16: Investigate using ArrayLists that contain different lengths of objects.
 * Lab17: Work with Polymorphism, learning how dynamic binding selects overridden
 *        methods at run time.
 */
import java.util.*;
public class Driver
{
    public static void main(String args[])
    {
        Dog dog=new Dog(Animal.FEMALE,"Short","Spot",12);
        Cat cat=new Cat(Animal.MALE,"Long","Twinkles");
        Robin robin=new Robin(Animal.FEMALE,!Bird.CANFLY,"Tweeter");
        Crow crow=new Crow(Animal.MALE,Bird.CANFLY,"McCaw");

        Animal animal=new Cat(Animal.FEMALE,"furry","Fuzzy");
        System.out.println(animal.toString());
        System.out.println();

        Mammal mammal=new Dog(Animal.MALE,"furry","Spot",20);
        System.out.println(mammal.speak());
    }
}