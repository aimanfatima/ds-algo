package dynamicprogramming;

public class AA_Fibonacci {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(fibonacciMemoized(n, new int[n+1]));
    }

    private static int fibonacciMemoized(int n, int[] qb) {
        if (n==1 || n==0) {
            return n;
        }

        if (qb[n] != 0) {
            return qb[n];
        }

        int fibn = fibonacciMemoized(n-1, qb) + fibonacciMemoized(n-2, qb);
        qb[n] = fibn;
        return fibn;
    }
}
