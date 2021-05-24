package csc360_summer;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class AssignmentB {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
        //Get the file name from the user.
        String filename = scan.next();
        int result = 0;
        //make file
        java.io.File file = new java.io.File(filename);
        //check if the file exist or not
        if (!file.exists())
        {
            System.out.print("Could not find file: " + filename);
            System.exit(1); //exit because the file doesnt exist
        }
        //read the file and make calculations
        try(java.io.PrintWriter write= new java.io.PrintWriter(file);
            Scanner input = new Scanner(file))
        {
            while (input.hasNext())
            {
                int number = input.nextInt();
                result += number;
            }
        }
        System.out.println(result);
    }
}
