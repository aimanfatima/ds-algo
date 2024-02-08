package priorityqueue;
import java.util.PriorityQueue;

public class KLargestElements {
    public static void main(String[] args) {
        // o/p : 18 17, 7
        // space complexity k
        // TC : n log k
        int[] arr = {2, 10, 5, 17, 7, 18, 6, 4};
        int k = 3;
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
