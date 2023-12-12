package stacks;

import java.util.Scanner;
import java.util.Stack;

public class PostfixEvaluationsAndConversions {

    /**
     *
     * @param args
     * Given - a postfixExpression
     * you need to evaluate the expression and print the answer
     * Also, you need to convert the expression to infix and prefix
     * and print them as well
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String postfixExpression = scanner.nextLine();
        Stack<Integer> evaluationStack = new Stack<>();
        Stack<String> infixStack = new Stack<>();
        Stack<String> prefixStack = new Stack<>();

        for (int i=0; i<postfixExpression.length(); i++) {
            char ch = postfixExpression.charAt(i);
            if (Character.isDigit(ch)) {
                evaluationStack.push(ch - '0');
                infixStack.push(String.valueOf(ch));
                prefixStack.push(String.valueOf(ch));
            } else {
                int val1 = evaluationStack.pop();
                int val2 = evaluationStack.pop();
                int result = operation(val2, val1, ch);
                String infixResult = infixOperation(infixStack.pop(), infixStack.pop(), ch);
                String prefixResult = prefixOperation(prefixStack.pop(), prefixStack.pop(), ch);
                evaluationStack.push(result);
                infixStack.push(infixResult);
                prefixStack.push(prefixResult);
            }
        }

        System.out.println(evaluationStack.peek());
        System.out.println(infixStack.peek());
        System.out.println(prefixStack.peek());
    }

    private static String prefixOperation(String val2, String val1, char op) {
        return op + val1 + val2;
    }

    private static String infixOperation(String val2, String val1, char op) {
        return val1 + op + val2;
    }

    private static int operation(int val1, int val2, char ch) {
        int result = 0;
        if (ch == '+') {
            result = val1 + val2;
        } else if (ch == '-') {
            result = val1 - val2;
        } else if (ch == '/') {
            result = val1 / val2;
        } else if (ch == '*') {
            result = val1 * val2;
        }
        return result;
    }
}
