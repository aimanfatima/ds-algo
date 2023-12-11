package stacks;

import java.util.Scanner;
import java.util.Stack;

public class InfixToPrePostFixConversions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String infixExpression = scanner.nextLine();

        Stack<String> prefixStack = new Stack<>();
        Stack<String> postfixStack = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for (int i=0; i<infixExpression.length(); i++) {
            char ch = infixExpression.charAt(i);
            if (ch == '(') {
                operators.push(ch);
            } else if (isOperator(ch)) {
                while (operators.size() > 0
                        && operators.peek() != '('
                        && precedence(operators.peek()) >= precedence(ch)) {
                    performPopOperations(prefixStack, postfixStack, operators);
                }
                operators.push(ch);
            } else if (ch == ')') {
                while (operators.peek() != '(') {
                    performPopOperations(prefixStack, postfixStack, operators);
                }
                operators.pop();
            } else {
                prefixStack.push(String.valueOf(ch));
                postfixStack.push(String.valueOf(ch));
            }
        }

        while (operators.size() > 0) {
            performPopOperations(prefixStack, postfixStack, operators);
        }

        System.out.println("Prefix = " + prefixStack.peek());
        System.out.println("Postfix = " + postfixStack.peek());
    }

    private static void performPopOperations(Stack<String> prefixStack, Stack<String> postfixStack, Stack<Character> operators) {
        char operator = operators.pop();

        // for Prefix
        String val1 = prefixStack.pop();
        String val2 = prefixStack.pop();
        prefixStack.push(operator + val2 + val1);

        // for Prefix
        val1 = postfixStack.pop();
        val2 = postfixStack.pop();
        postfixStack.push(val2 + val1 + operator);
    }

    private static int precedence(char ch) {
        if (ch == '*' || ch == '/') {
            return 2;
        } else {
            return 1;
        }
    }

    private static boolean isOperator(char ch) {
        return (ch == '+' || ch == '-' || ch == '*' || ch == '/');
    }
}
