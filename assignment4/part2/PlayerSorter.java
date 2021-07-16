package csc360_summer.assignment4.part2;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class PlayerSorter {

    public static void removeAndPrintQueues(PriorityQueue<Player> pq)
    {
        while(pq.size() > 0)
            System.out.println(pq.remove());
    }

    public static void main(String[] args) throws FileNotFoundException {
        //store the players in an arraylist after reading from the file
        ArrayList<Player> players = new ArrayList<>();
        //let me make a priorityQue
        PriorityQueue<Player> playerNameLenPQ = new PriorityQueue<>(new NameLengthComparator());
        PriorityQueue<Player> playerScorePQ = new PriorityQueue<>(new ScoreComparator());

        //how do i read the data from the file efficiently?
        //use of data input stream
        File file = new File("/Users/dj/IdeaProjects/Summer/src/csc360_summer/assignment4/part2/players.txt");

        try (
                Scanner scanner = new Scanner(file)
        ) {
            //Loop through the file and add the players to the player arraylist
            while (scanner.hasNext()) {
                String first_name  = scanner.next();//store the first name if the file here
                String last_name  = scanner.next();// store last name here
                double score = scanner.nextDouble();//player score
                players.add(new Player(first_name,last_name, score));
            }
        }

        //Populate both priority queues with the players
        for (Player i :
                players) {
            playerNameLenPQ.offer(i);
            playerScorePQ.offer(i);
        }

        System.out.println("__________________________Name Comparator_________________________________");
        removeAndPrintQueues(playerNameLenPQ);
        System.out.println();
        System.out.println();
        System.out.println("__________________________Score Comparator_________________________________");
        System.out.println();
        System.out.println();
        removeAndPrintQueues(playerScorePQ);
    }
}
