package stacks;

import java.util.Scanner;
import java.util.Stack;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i=0; i<n; i++) {
            arr[i] = scanner.nextInt();
        }
        int k = scanner.nextInt();

        int[] res = slidingWindowMax(arr, k);

        System.out.println(res);
    }

    private static int[] slidingWindowMax(int[] arr, int k) {
        int n = arr.length;
        int[] res = new int[n-k+1];

        int[] nextGreaterElement = findNextGreaterElementArray(arr);

        int j=0;
        for (int i=0; i<n-k+1; i++) {
            if (j < i) {
                j = i;
            }
            while (nextGreaterElement[j] < i+k) {
                j = nextGreaterElement[j];
            }
            res[i] = arr[j];
        }

        return res;
    }

    private static int[] findNextGreaterElementArray(int[] arr) {
        int n = arr.length;
        int[] nge = new int[arr.length];

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (int i=1; i<n; i++) {
            while (stack.size() > 0 && arr[stack.peek()] <= arr[i]) {
                nge[stack.peek()] = i;
                stack.pop();
            }
            stack.push(i);
        }

        while(stack.size() > 0) {
            nge[stack.peek()] = -1;
            stack.pop();
        }

        return nge;
    }
}
