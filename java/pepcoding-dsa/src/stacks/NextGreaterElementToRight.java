package stacks;

import java.util.Scanner;
import java.util.Stack;

public class NextGreaterElementToRight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i=0; i<n; i++) {
            arr[i] = scanner.nextInt();
        }

        int[] res = new int[n];
        res[n-1] = -1;
        Stack<Integer> stack = new Stack();
        stack.push(arr[n-1]);
        for (int i=n-2; i>=0; i--) {
            while (stack.size()>0 && arr[i] >= stack.peek()) {
                stack.pop();
            }
            if (stack.size() == 0) {
                res[i] = -1;
            } else {
                res[i] = stack.peek();
            }
            stack.push(arr[i]);
        }

        for (int i=0; i<n; i++) {
            System.out.println(res[i]);
        }
    }
}
