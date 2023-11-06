package stacks;

import java.util.Scanner;
import java.util.Stack;

public class StockSpanProblem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] arr = new int[n];

        for (int i=0; i<n; i++) {
            arr[i] = scanner.nextInt();
        }

        stockSpan(arr);
    }

    private static void stockSpan(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[arr.length];

        res[0] = 1;
        stack.push(0);

        for (int i=1; i<arr.length; i++) {
            while (stack.size() > 0 && arr[stack.peek()] < arr[i]) {
                stack.pop();
            }
            if (stack.size() > 0) {
                res[i] = i-stack.peek();
            } else {
                res[i] = i+1;
            }
            stack.push(i);
        }

        for (int i=0; i<arr.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
