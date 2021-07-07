package csc360_summer.assignment2;

/**
 *
 * @author Burmau Garba
 * @instructor Rasib Kahn
 *
 * **/


import java.util.*;

public class Laptop implements Comparable<Laptop>{
    private static  final  Random random = new Random();
    /** Constant **/
    private static final double CPU_MAX = 3.0, RAM_MAX = 32.0,
                   HDD_MAX = 2048, SCREEN_MAX = 17.0,
                   WEIGHT_MAX = 6.0, BATTERY_MAX = 9.0,
                   PRICE_MAX = 2000;

    /** Variable Declaration **/
    private double cpu, ram,
                   hdd,screen_size,
                   weight,battery_life,
                   price, score, graphics;

    public Laptop() {
    }

    public Laptop(double cpu,
                  double ram,
                  double hdd,
                  double screen_size,
                  double weight,
                  double battery_life,
                  double price,
                  double graphics) {
        this.cpu = cpu;
        this.ram = ram;
        this.hdd = hdd;
        this.screen_size = screen_size;
        this.weight = weight;
        this.battery_life = battery_life;
        this.price = price;
        this.graphics = graphics;

        score = ((2 * cpu)/ CPU_MAX ) + ( (1 * hdd) / HDD_MAX ) + graphics + ( 1 * screen_size/ SCREEN_MAX )
                + (1 * weight / WEIGHT_MAX) + (1 * battery_life / BATTERY_MAX) + (1 * price / PRICE_MAX);

    }

    public double getScore() {
        return  score= ((2 * cpu)/ CPU_MAX ) +
                ( (1 * hdd) / HDD_MAX ) + graphics +
                ( 1 * screen_size/ SCREEN_MAX ) +
                (1 * weight / WEIGHT_MAX) +
                (1 * battery_life / BATTERY_MAX) +
                (1 * price / PRICE_MAX);
    }

    //Random Laptop creator
//    public List<Laptop> randomLaptopCreator()
//    {
//        Random random = new Random();
//        //generate 5 random laptops
//        List<Laptop> laptops = new ArrayList<>(5);
//        for (int i = 0; i < 5; i++) {
//            laptops.add(i, new Laptop(makeCPU(), make_ram(), make_hdd(), makeScreenSize(), makeWeight(), make_battery_life(), make_price(), make_graphics()));
//        }
//        return laptops;
//    }

    public static int make_graphics(){
        return random.nextInt( 1-0 + 1 );
    }

    public static double make_price()
    {
        return random.nextInt((int) (PRICE_MAX - 200 + 1)) + 200 ;
    }

    public static double make_battery_life()
    {
        return random.nextInt((int) BATTERY_MAX + 1);
    }

    public static double makeWeight()
    {
        return random.nextInt((int) (WEIGHT_MAX -1 +  1)) + 1;
    }

    public static double makeScreenSize()
    {
        return random.nextInt((int) (SCREEN_MAX -1 +  1)) + 1;
    }

    public static double makeCPU() {
        return random.nextInt((int) (CPU_MAX - 1 + 1)) + 1;
    }

    public static double make_ram(){
        return random.nextInt((int)RAM_MAX+1);
    }

    public static double make_hdd()
    {
        return random.nextInt((int)HDD_MAX + 1 );
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "cpu= " + cpu +
                ", ram=" + ram +
                ", hdd=" + hdd +
                ", screen_size=" + screen_size +
                ", weight=" + weight +
                ", battery_life=" + battery_life +
                ", price=" + price +
                ", score=" + score +
                ", graphics=" + graphics +
                '}';
    }

    public static Laptop[] randomLaptopCreator()
    {

        Laptop[] laptops = new Laptop[5];
        laptops[0] = new Laptop(makeCPU(), make_ram(), make_hdd(), makeScreenSize(), makeWeight(), make_battery_life(), make_price(), make_graphics());
        laptops[1] = new Laptop(makeCPU(), make_ram(), make_hdd(), makeScreenSize(), makeWeight(), make_battery_life(), make_price(), make_graphics());
        laptops[2] = new Laptop(makeCPU(), make_ram(), make_hdd(), makeScreenSize(), makeWeight(), make_battery_life(), make_price(), make_graphics());
        laptops[3] = new Laptop(makeCPU(), make_ram(), make_hdd(), makeScreenSize(), makeWeight(), make_battery_life(), make_price(), make_graphics());
        laptops[4] = new Laptop(makeCPU(), make_ram(), make_hdd(), makeScreenSize(), makeWeight(), make_battery_life(), make_price(), make_graphics());
        for (int i = 0; i < laptops.length; i++) {
            for (int j = i+1; j < laptops.length; j++)
                laptops[i].compareTo(laptops[j]);
            Arrays.sort(laptops); //sorting according to the laptop score
        }
        return laptops;
    }

    @Override
    public int compareTo(Laptop o) {
        if (getScore() > o.getScore())
            return 1;
        else if (getScore() < o.getScore())
            return -1;
        else
            return 0;
    }

}
