package csc360_summer.assignment4;

public class PowersUsername {

    //PART 1
    public static double powers1(double b, int n){
        boolean flag = true;
        double val = b;
        do {
            try{
                if (n < 0)
                    throw new ArithmeticException("n must be greater than or equal to zero");
                for(int i=1; i < n; i++)
                     b *= val;
                flag = false;
            }catch (ArithmeticException ex)
            {
                ex.getMessage();
            }
        }while (flag);
        return b;
    }
    //PART 2
    public static double powers2(double b, int n)
    {
        if (n == 0)
            return 1;
        else
            return b * powers2(b, n-1);
    }

    //PART 3
    public static void powers3(){

    }

    public static void main(String[] args) {
        double b = 1.001;
        int i = 1000;
        System.out.println(powers2(b, i));
    }

}
