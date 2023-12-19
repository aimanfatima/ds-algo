package stacks;

import java.io.*;

public class CustomStack {

    public static class Stack {
        int[] data;
        int topOfStack;

        public Stack(int cap) {
            data = new int[cap];
            topOfStack = -1;
        }

        int size() {
            return topOfStack + 1;
        }

        void display() {
            for (int i=topOfStack; i>=0; i--) {
                System.out.print(data[i] + " ");
            }
            System.out.println();
        }

        void push(int val) {
            if (topOfStack == data.length - 1) {
                System.out.println("Stack overflow");
                return;
            }
            topOfStack = topOfStack + 1;
            data[topOfStack] = val;
        }

        int pop() {
            if (topOfStack == -1) {
                System.out.println("Stack underflow");
                return -1;
            }
            int poppedValue = data[topOfStack];
            data[topOfStack] = 0;
            topOfStack = topOfStack - 1;
            return poppedValue;
        }

        int top() {
            if (topOfStack == -1) {
                System.out.println("Stack underflow");
                return -1;
            }
            return data[topOfStack];
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack st = new Stack(n);

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
            } else if(str.startsWith("display")){
                st.display();
            }
            str = br.readLine();
        }
    }
}