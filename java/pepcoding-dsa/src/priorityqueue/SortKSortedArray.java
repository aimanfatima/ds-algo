package priorityqueue;

import java.util.PriorityQueue;

public class SortKSortedArray {

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 4, 6, 7, 5, 8, 9};
        int k = 2;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i=0; i<arr.length; i++) {
            if (i < k) {
                pq.add(arr[i]);
            } else {
                if (arr[i] > pq.peek()) {
                    System.out.println(pq.peek());
                    pq.remove();
                    pq.add(arr[i]);
                } else {
                    System.out.println(arr[i]);
                }
            }
        }
        while (pq.size() > 0) {
            System.out.println(pq.peek());
            pq.remove();
        }
    }
}
