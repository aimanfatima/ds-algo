package stacks;

import java.util.Stack;

public class CelebrityProblem {
    public static void main(String[] args) {
        int n = 4;
        int[][] matrix = {
                {0, 1, 1, 1},
                {1, 0, 1, 0},
                {0, 0, 0, 0},
                {1, 1, 1, 0}
        };
        Stack<Integer> stack = new Stack<>();
        for (int i=0; i<n; i++) {
            stack.push(i);
        }

        while (stack.size()>1) {
            int person1 = stack.pop();
            int person2 = stack.pop();

            if (matrix[person1][person2] == 1) {
                stack.push(person2);
            } else {
                stack.push(person1);
            }
        }
        int potentialCelebrity = stack.peek();
        boolean isTrueCelebrity = true;

        for (int i=0; i<n; i++) {
            if (i != potentialCelebrity && (matrix[potentialCelebrity][i] != 0 || matrix[i][potentialCelebrity] != 1)) {
                System.out.println(i);
                isTrueCelebrity = false;
            }
        }
        if (isTrueCelebrity) {
            System.out.println("Celebrity is = " + potentialCelebrity);
        } else {
            System.out.println("No celebrity found");
        }
    }
}
