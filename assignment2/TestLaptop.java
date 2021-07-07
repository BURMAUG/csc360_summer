package csc360_summer.assignment2;
/**
 *
 * @author Burmau Garba
 * @instructor Rasib Kahn
 *
 **/
public class TestLaptop {
    public static void main(String[] args) {
        //make a Laptop
        //Create an array of laptops that contains 5 randomly generated laptops
        Laptop[] laptops = Laptop.randomLaptopCreator();
        for (Laptop i :
                laptops) {
            System.out.println(i.toString());
        }
    }

}
