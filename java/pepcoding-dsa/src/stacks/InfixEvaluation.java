package stacks;

import java.util.Scanner;
import java.util.Stack;

public class InfixEvaluation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Stack<Integer> operand = new Stack<>();
        Stack<Character> operator = new Stack<>();

        for (int i=0; i<input.length(); i++) {
            char ch = input.charAt(i);
            if (ch == '(') {
                operator.push(ch);
            } else if (Character.isDigit(ch)) {
                operand.push(Character.getNumericValue(ch));
            } else if (ch == ')') {
                while (operator.peek() != '(') {
                    char op = operator.pop();
                    int v2 = operand.pop();
                    int v1 = operand.pop();
                    operand.push(operation(v1, v2, op));
                }
                operator.pop();
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                while (operator.size() > 0
                        && operator.peek() != '('
                        && (precedence(operator.peek()) >= precedence(ch))) {
                    char op = operator.pop();
                    int v2 = operand.pop();
                    int v1 = operand.pop();
                    operand.push(operation(v1, v2, op));
                }
                operator.push(ch);
            }
        }
        while (operator.size() > 0) {
            char op = operator.pop();
            int v2 = operand.pop();
            int v1 = operand.pop();
            operand.push(operation(v1, v2, op));
        }
        System.out.println(operand.peek());
    }

    public static int precedence(char ch) {
        if (ch == '*' || ch == '/') {
            return 2;
        } else if (ch == '+' || ch == '-') {
            return 1;
        }
        return 0;
    }

    public static int operation(int v1, int v2, char op) {
        int result;
        if (op == '+') {
            result = v1 + v2;
        } else if (op == '-') {
            result = v1 - v2;
        } else if (op == '*') {
            result = v1 * v2;
        } else {
            result = v1 / v2;
        }
        return result;
    }
}
