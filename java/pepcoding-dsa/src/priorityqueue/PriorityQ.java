package priorityqueue;
import java.util.*;



public class PriorityQ {
    public static void main(String[] args) {
        // Note : if you wanna create a pq which gives higer priority to larger values then use -
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        // PriorityQueue<Integer> pq = new PriorityQueue<>();

        int[] ranks = {22, 1, 56, 23, 100, 0, 3};

        // n log(n) complexity
        for (int rank: ranks) {
            pq.add(rank);
        }

        // n log n complexity
        while (pq.size() > 0) {
            System.out.println(pq.peek());
            pq.remove();
        }
    }
}
