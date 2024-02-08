package priorityqueue;
import java.util.PriorityQueue;

public class KLargestElements {
    public static void main(String[] args) {
        // o/p : 18 17, 7
        // space complexity k
        // TC : n log k
        int[] arr = {2, 10, 5, 17, 7, 18, 6, 4};
        int k = 3;

        // create a PQ with priority given to minimum no.
        // Why? We want to give highest priority to a number which is the weakest
        // because that number will be dropped if some better candidate is there
        PriorityQueue<Integer> pq = new PriorityQueue<>();


        for (int i=0; i<k; i++) {
            pq.add(arr[i]);
        }

        for (int i=k; i<arr.length; i++) {
            if (arr[i] > pq.peek()) {
                pq.remove();
                pq.add(arr[i]);
            }
        }

        while (pq.size()>0) {
            System.out.println(pq.peek());
            pq.remove();
        }
    }
}
