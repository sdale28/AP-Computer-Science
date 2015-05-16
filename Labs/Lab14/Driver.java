/**
 * @author Sam Dale 
 * @version 1/22/14
 * AP Computer Science
 * 
 * Lab14: Learn how to use Abstract Classes and the properties of inheritance. 
 */
public class Driver
{
    public static void main(String args[])
    {
        Cat cat=new Cat(true,"Long","Mittens");
        System.out.println(cat);
        Dog dog=new Dog(false,"Short","Spot");
        System.out.println(dog);
        Robin robin=new Robin(true,false,"Tweeter");
        System.out.println(robin);
        Crow crow=new Crow(false,true,"McCaw");
        System.out.println(crow);
    }
}