package csc360_summer;
/****
 *
 * NAME: BURMAU GARBA
 * ASSIGNMENT: 2
 *
 **/

import java.io.FileNotFoundException;

public class GarbaBurmauA1P2 {
    public static void main(String[] args) throws FileNotFoundException
    {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        //GET THE FILE PATH OF THE FILE FROM THE USER
        System.out.print("ENTER THE FILE PATH HERE: ");
        String path = scanner.nextLine();
        //Declaring variable
        int countParsable = 0, count_not_parsable = 0;
        String n = null;
        double average = 0;
        java.io.File file = new java.io.File(path);
        //end of variable declarations

        //CHECK IF THE FILE EXIST
        if (!file.exists())
        {
            System.out.println("Cannot find the file: " + path);
            System.exit(1);//exit the program
        }

        //Read the file
        try(java.util.Scanner input = new java.util.Scanner(file))
        {
            //loop through the file checking for digit
            do
            {
                try{
                     n = input.nextLine();
                    int d = Integer.parseInt(n); //take string from n and parse to integer
                    countParsable++;//increase the number of correct data
                    average += d; //make addition to calculate average
                }catch (NumberFormatException ex)
                {
                    count_not_parsable++;//count the number of non countable data
                    System.out.println("cannot parse " + n + " as an integer." );
                }
            }while (input.hasNext());
            System.out.println("Number of parsable lines: " + countParsable);
            System.out.println( "Average value: "  + average / (countParsable + count_not_parsable) );
            System.out.println("Number of non-parsable lines: " + count_not_parsable);
        }
    }
}
