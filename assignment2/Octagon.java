package csc360_summer.assignment2;

public class Octagon extends GeometricObject implements Cloneable, Comparable<Octagon>{
    // was cloned or not cloned
    private boolean wasCloned  = false;//Checker to know if cloned
    private double side;//side of the octagon
    private  double area;//area of the octagon

    public Octagon(String color, boolean filled, double side) {
        super(color, filled);
        this.side = side;
    }

    public boolean WasCloned() {
        return wasCloned;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public double setArea()
    {
        try {
        if(area <= 0)
            throw new ArithmeticException("Zero can't be allowed");
        }catch(ArithmeticException ex)
        {
            ex.getMessage();
        }
        return  area;
    }

    @Override
    public double getArea() {
        return (2 + 4 / java.lang.Math.sqrt(2)) * java.lang.Math.pow(side, 2);
    }

    @Override
    public double getPerimeter() {
        return 8*side;
    }

    @Override
    public int compareTo(Octagon o) {
        if (area > o.area)
            return 1;
        else if (area < o.area)
            return -1;
        else
            return 0;
    }
    @Override
    public Object clone()
    {
        try{
            wasCloned = true; //if clone was done
            return super.clone();
        }catch (CloneNotSupportedException ex)
        {
            return null;
        }
    }

    @Override
    public String toString() {
        return "Octagon{" +
                " wasCloned = " + wasCloned +
                ", side = " + side + ", Perimeter = " + getPerimeter() +
                ", Area = " + getArea() +
                '}';
    }
}

/**
 *
 * Octagon1: Octagon{ wasCloned = false, side = 5.0, Perimeter = 40.0, Area = 120.71067811865474}
 * Octagon2: Octagon{ wasCloned = true, side = 5.0, Perimeter = 40.0, Area = 120.71067811865474}
 * oct1.compareTo(oct2): 0
 *
 ***/