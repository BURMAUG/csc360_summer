package csc360_summer.assignment4.part2;


import java.util.ArrayList;

public class ScoreComparator implements java.util.Comparator<Player> {
    @Override
    public int compare(Player player1, Player player2) {
        if(player1.score > player2.score)
            return 1;
        else if (player1.score < player2.score)
            return -1;
        else
            return 0;
    }
}
