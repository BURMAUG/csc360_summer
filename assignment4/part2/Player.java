package csc360_summer.assignment4.part2;


/**
 *
 * @Author: Burmau Garba
 * Instructor: Rasib Khan
 * Assignment: 4
 *
 * **/


public class Player {
    String fName, lName;
    Double score;

    public Player(String fName, String lName, Double score) {
        this.fName = fName;
        this.lName = lName;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Player{" +
                "fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", score=" + score +
                '}';
    }
}
