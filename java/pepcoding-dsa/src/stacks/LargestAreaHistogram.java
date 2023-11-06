package stacks;

import java.util.Scanner;
import java.util.Stack;

public class LargestAreaHistogram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i=0; i<n; i++) {
            arr[i] = scanner.nextInt();
        }

        int maxArea = largestAreaHistogram(arr);
        System.out.println(maxArea);
    }

    private static int largestAreaHistogram(int[] arr) {
        int n = arr.length;
        int maxArea = 0;
        int[] res = new int[arr.length];

        int[] nextSmallestElementIndexOnLeft = calculateNextSmallestElementIndexOnLeft(arr);
        int[] nextSmallestElementIndexOnRight = calculateNextSmallestElementIndexOnRight(arr);

        for (int i=0; i<n; i++) {
            // System.out.println("[" + (nextSmallestElementIndexOnLeft[i]) + ", " + (nextSmallestElementIndexOnRight[i]) + "]");
            res[i] = ((nextSmallestElementIndexOnRight[i]-1) - (nextSmallestElementIndexOnLeft[i]+1) + 1) * arr[i];
            if (res[i] > maxArea) {
                maxArea = res[i];
            }
        }

        return maxArea;
    }

    private static int[] calculateNextSmallestElementIndexOnLeft(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        res[0] = -1;

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (int i=1; i<n; i++) {
            while (stack.size() > 0 && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            if (stack.size() == 0) {
                res[i] = -1;
            } else {
                res[i] = stack.peek();
            }
            stack.push(i);
        }
        return res;
    }

    private static int[] calculateNextSmallestElementIndexOnRight(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        res[n-1] = n;

        Stack<Integer> stack = new Stack<>();
        stack.push(n-1);

        for (int i=n-2; i>=0; i--) {
            while (stack.size()>0 && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            if (stack.size() == 0) {
                res[i] = n;
            } else {
                res[i] = stack.peek();
            }
            stack.push(i);
        }
        return res;
    }
}
