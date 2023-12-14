package stacks;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

// Important Question - Stack
public class MergeOverlappingIntervals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] times = new int[n][2];

        for (int i=0; i<n; i++) {
            times[i][0] = scanner.nextInt();
            times[i][1] = scanner.nextInt();
        }

        // Step - 1 Make an array of Pair
        Pair[] arr = new Pair[n];
        for (int i=0; i<n; i++) {
            arr[i] = new Pair(times[i][0], times[i][1]);
        }

        // Step - 2 Sort the array based on startTime
        Arrays.sort(arr);

        // Use stack to merge the time intervals
        System.out.println("\nresult");
        Stack<Pair> stack = new Stack<>();
        stack.push(arr[0]);
        for (int i=1; i<n; i++) {
            int startTime = arr[i].startTime;
            int endTime = arr[i].endTime;

            Pair topStackValue = stack.peek();

            if (startTime > topStackValue.endTime) {
                stack.push(new Pair(startTime, endTime));
            } else {
                topStackValue.endTime = Math.max(topStackValue.endTime, arr[i].endTime);
            }
        }

        while (stack.size() > 0) {
            System.out.println(stack.peek().startTime+ " " +stack.peek().endTime);
            stack.pop();
        }
    }

    public static class Pair implements Comparable<Pair> {
        int startTime;
        int endTime;

        Pair(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        /**
         * this > other - return +ve value
         * this == other - return 0
         * this < other - return -ve value
         */
        public int compareTo(Pair other) {
            if (this.startTime != other.startTime) {
                return this.startTime - other.startTime;
            } else {
                return this.endTime - other.endTime;
            }
        }
    }
}
