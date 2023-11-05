package stacks;

import java.util.Stack;

public class BalancedBrackets {
    public static void main(String[] args) {
        String input = "";
        Stack<Character> st = new Stack<>();
        boolean isValid = true;

        for (int i=0; i<input.length(); i++) {
            if (input.charAt(i) == '('
                    || input.charAt(i) == '['
                    || input.charAt(i) == '{') {
                st.push(input.charAt(i));
            } else if (input.charAt(i) == ')') {
                if (st.size() > 0 && st.peek() == '(') {
                    st.pop();
                } else {
                    isValid = false;
                    break;
                }
            } else if (input.charAt(i) == ']') {
                if (st.size() > 0 && st.peek() == '[') {
                    st.pop();
                } else {
                    isValid = false;
                    break;
                }
            } else if (input.charAt(i) == '}') {
                if (st.size() > 0 && st.peek() == '{') {
                    st.pop();
                } else {
                    isValid = false;
                    break;
                }
            }
        }

        if (isValid && st.size() != 0) {
            System.out.println("false");
        } else {
            System.out.println("true");
        }
    }
}
