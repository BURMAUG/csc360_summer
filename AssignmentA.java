package csc360_summer;
/****
 *
 * NAME: BURMAU GARBA
 * ASSIGNMENT: 1
 *
 **/
import java.util.InputMismatchException;
import java.util.Scanner;

public class AssignmentA
{
    public static void main(String[] args) throws Exception
    {
        Scanner scan = new Scanner(System.in);
        int result = 0;
        //flag to control the habit of the loop
        boolean flag = true;
        //numbers for value
        int number1 = 0;
        int number2 = 0;
        //read the file and make calculations
        do {
            try{
                System.out.print("ENTER AN INTEGER HERE: ");
                number1 = scan.nextInt();//store number
                //CHANGE the flag to false
                flag = false;
            }catch (InputMismatchException ex)
            {
                System.out.println("TRY AGAIN. (" + "INCORRECT INPUT: AN INTEGER IS REQUIRED )"  );
                scan.nextLine();
            }
        }while (flag);

        flag = true;//use the same flag to test for the second number
        do {
            try{
                //getting the second number from user
                System.out.print("ENTER ANOTHER INTEGER HERE: ");
                number2 = scan.nextInt();//store number
                flag = false; //change from true to false
            }catch (InputMismatchException ex)
            {
                System.out.println("TRY AGAIN. (" + "INCORRECT INPUT: AN INTEGER IS REQUIRED )"  );
                scan.nextLine();
            }
        }while (flag);
        //print result
        System.out.println("The sum is " + (number1 + number2));
    }
}
