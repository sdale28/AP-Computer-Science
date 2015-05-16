/**
 * @author Sam Dale
 * @version 1/24/14
 * AP Computer Science
 *
 * Lab14: Learn how to use Abstract Classes and the properties of Inheritance.
 * Lab15: Adding to Lab14, learn how to override methods.
 * Lab16: Investigate using ArrayLists that contain different lengths of objects.
 */
import java.util.*;
public class Driver
{
    public static void main(String args[])
    {
        ArrayList <Animal> list=new ArrayList <Animal>();
        list.add(new Dog(Animal.MALE,"Short","Spot",12));
        list.add(new Dog(Animal.FEMALE,"Long","Dalaila",22));
        list.add(new Cat(Animal.MALE,"Fuzzy","Twinkles"));
        list.add(new Cat(Animal.FEMALE,"Soft","Mittens"));

        for (int i=0;i<list.size();i++)
            System.out.println(list.get(i));
        System.out.println();

        for (Animal tmp: list)
            if (tmp instanceof Dog)
            {
                Dog tmpDog=(Dog) tmp;
                System.out.println(tmpDog.getName()+": "+tmpDog.digBones());
            }
    }
}