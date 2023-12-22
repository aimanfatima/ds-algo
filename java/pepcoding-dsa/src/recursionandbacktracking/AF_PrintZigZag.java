package recursionandbacktracking;

/**
 * To illustrate the concept of left recursion call, right recursion call
 * and pre area, in area, post area
 *
 * Use of trees to dry run and find the output
 */
public class AF_PrintZigZag {
    public static void main(String[] args) {
        int n = 3;
        printZigZag(n);
    }

    private static void printZigZag(int n) {
        if (n == 0) {
            return;
        }
        System.out.print(n + " "); // pre - area
        printZigZag(n-1); // left recursive call
        System.out.print(n + " "); // in - area
        printZigZag(n-1); // right recursive call
        System.out.print(n + " "); // post - area
    }
}
