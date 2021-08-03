package csc360_summer.assignment4.part2;

import java.io.*;

public class Reading {
    public static void main(String[] args) throws IOException {
        try(
                BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream("/Users/dj/IdeaProjects/Summer/src/csc360_summer/assignment4/part2/players.txt"));
                DataOutputStream outputStream = new DataOutputStream(new FileOutputStream("players.dat"))
                ){
            while (inputStream.read() != -1)
            {
                outputStream.writeUTF(inputStream.toString());
                outputStream.writeUTF(inputStream.toString());
                outputStream.writeDouble(Double.parseDouble(String.valueOf(inputStream.read())));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        try (
                BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream("/Users/dj/IdeaProjects/Summer/players.dat"))
               )
        {
            while (inputStream.available() != 0)
            {
                System.out.println(inputStream.read() + " " + inputStream.read() + " " + inputStream.read());
            }
        }
    }
}
