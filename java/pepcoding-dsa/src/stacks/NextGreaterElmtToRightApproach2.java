package stacks;

import java.util.Scanner;
import java.util.Stack;

public class NextGreaterElmtToRightApproach2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        int[] nge = new int[n];

        for (int i=0; i<n; i++) {
            arr[i] = scanner.nextInt();
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (int i=1; i<n; i++) {
            while (stack.size()>0 && arr[stack.peek()] <= arr[i]) {
                nge[stack.peek()] = arr[i];
                stack.pop();
            }
            stack.push(i);
        }
        while (stack.size() > 0) {
            nge[stack.peek()] = -1;
            stack.pop();
        }

        for (int i=0; i<n; i++) {
            System.out.println(nge[i]);
        }
    }
}
