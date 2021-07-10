package csc360_summer.assignment4;

public class PowersUsername {
    private static int multiplication = 0;

    //PART 1
    public static double powers1(double b, int n){
        boolean flag = true;
        double val = b;
        do {
                for(int i=0; i < n; i++) {
                    b *= val;
                    flag = false;
                    multiplication++;
                }
        }while (flag);
//        System.out.println(multiplication);
        return b;
    }
    //PART 2
    public static double powers2(double b, int n)
    {
        if (n == 0)
            return 1;
        else {
            multiplication++;
            return b * powers2(b, n - 1);
        }
    }

    //PART 3
    public static double powers3(double b, int n) {
        int v =0;
        if (n == 0)
            return 1;
        else
            //return b * powers3(b, n-1);
            if (n % 2 == 0)
            {
                multiplication++;
                return powers3(b, n/2) * powers3(b , n/2);
            }else
               return b * powers3(b, n/2) * powers3(b, n/2);
    }

    //PART 4
    public static double multPow(double a, double b, int n)
    {
        return multPow(a, b, 0, n);
    }
    //helper method for multPow()
    public static double multPow(double a, double b, int base, int nth)
    {
        if (nth <= base)
            return a;
        return
                multPow(a, b,base+1, nth-1);
    }


    public static void main(String[] args) {
        double b = 1.001;
        int i = 1000;
        System.out.println(powers2(b, i) + " \nMultiplication= " + multiplication);
        System.out.println();
        System.out.println(powers1(b, i) + "\nMultiplication= " + (multiplication-1000));
        System.out.println(multPow(4,1.001,1000));

    }

}
