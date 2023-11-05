package stacks;

import java.util.Scanner;
import java.util.Stack;

public class DuplicateBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Stack<Character> st = new Stack<>();
        boolean isDuplicate = false;
        for (int i=0; i<input.length(); i++) {
            if (input.charAt(i) == ')') {
                if (st.peek() == '(') {
                    isDuplicate = true;
                } else {
                    while (st.peek() != '(') {
                        st.pop();
                    }
                }
                st.pop();
            } else {
                st.push(input.charAt(i));
            }
        }
        System.out.println(isDuplicate);
    }
}
