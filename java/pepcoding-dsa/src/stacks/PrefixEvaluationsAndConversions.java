package stacks;

import java.util.Scanner;
import java.util.Stack;

public class PrefixEvaluationsAndConversions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String prefixExpression = scanner.nextLine();

        Stack<Integer> evaluationStack = new Stack<>();
        Stack<String> infixStack = new Stack<>();
        Stack<String> postfixStack = new Stack<>();

        for (int i=prefixExpression.length()-1; i>=0; i--) {
            char ch = prefixExpression.charAt(i);
            if (Character.isDigit(ch)) {
                evaluationStack.push(ch - '0');
                infixStack.push(String.valueOf(ch));
                postfixStack.push(String.valueOf(ch));
            } else {
                evaluationStack.push(performPopOperation(evaluationStack.pop(), evaluationStack.pop(), ch));
                infixStack.push(performPopOperationForInfix(infixStack.pop(), infixStack.pop(), ch));
                postfixStack.push(performPopOperationForPostfix(postfixStack.pop(), postfixStack.pop(), ch));
            }
        }

        System.out.println(evaluationStack.peek());
        System.out.println(infixStack.peek());
        System.out.println(postfixStack.peek());
    }

    private static String performPopOperationForPostfix(String val1, String val2, char op) {
        return val1 + val2 + op;
    }

    private static String performPopOperationForInfix(String val1, String val2, char op) {
        return val1 + op + val2;
    }

    private static Integer performPopOperation(Integer val1, Integer val2, char ch) {
        int result = 0;
        if (ch == '+') {
            result = val1 + val2;
        } else if (ch == '-') {
            result = val1 - val2;
        } else if (ch == '*') {
            result = val1 * val2;
        } else if (ch == '/') {
            result = val1 / val2;
        }
        return result;
    }
}
