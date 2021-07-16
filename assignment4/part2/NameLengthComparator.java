package csc360_summer.assignment4.part2;

import java.util.PriorityQueue;

public class NameLengthComparator implements java.util.Comparator<Player>{
    @Override
    public int compare(Player player_name1, Player player_name2) {
       int len =  player_name1.fName.length() + player_name1.lName.length();
       int len2 =  player_name2.fName.length() + player_name2.lName.length();
        if (len > len2)
            return 1;
        else if (len < len2)
            return -1;
        else
            return 0;
    }
}
