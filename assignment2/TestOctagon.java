package csc360_summer.assignment2;

public class TestOctagon {
    public static void main(String[] args) {
        GeometricObject object = new Octagon("RED", true,5);
        object.getArea();
        object.getPerimeter();
        System.out.println("Octagon1: " + object);
        GeometricObject object1 = (GeometricObject) ((Octagon) object).clone();
        System.out.println("Octagon2: " + object1);
        //comparing all the objects
        System.out.println("oct1.compareTo(oct2): " +((Octagon) object).compareTo((Octagon)object1));
        //System.out.println(object == object1);
    }
}
