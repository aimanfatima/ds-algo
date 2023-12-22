package stacks;

import java.io.*;
import java.util.*;

/**
 * Time complexity - O(1)
 * Space complexity - O(1)
 */
public class MinimumStackII {
    public static class MinStack {
        Stack<Integer> allData;
        int min;

        public MinStack() {
            allData = new Stack<>();
            min = -1;
        }

        int size() {
            return allData.size();
        }

        void push(int val) {
            if (allData.size() == 0) {
                allData.push(val);
                min = val;
            } else {
                if (val >= min) {
                    allData.push(val);
                } else {
                    allData.push(val + (val - min));
                    min = val;
                }
            }
        }

        int pop() {
            if (allData.peek() >= min) {
                return allData.pop();
            } else {
                int oldMin = min;
                min = 2 * min - allData.pop();
                return oldMin;
            }
        }

        int top() {
            if (allData.peek() >= min) {
                return allData.peek();
            } else {
                return min;
            }
        }

        int min(){
            return min;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        MinimumStackII.MinStack st = new MinimumStackII.MinStack();

        String str = br.readLine();
        while(str.equals("quit") == false){
            if(str.startsWith("push")){
                int val = Integer.parseInt(str.split(" ")[1]);
                st.push(val);
            } else if(str.startsWith("pop")){
                int val = st.pop();
                if(val != -1){
                    System.out.println(val);
                }
            } else if(str.startsWith("top")){
                int val = st.top();
                if(val != -1){
                    System.out.println(val);
                }
            } else if(str.startsWith("size")){
                System.out.println(st.size());
            } else if(str.startsWith("min")){
                int val = st.min();
                if(val != -1){
                    System.out.println(val);
                }
            }
            str = br.readLine();
        }
    }
}
