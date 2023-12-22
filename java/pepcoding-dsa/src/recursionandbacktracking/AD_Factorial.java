package recursionandbacktracking;

import java.util.Scanner;

public class AD_Factorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(factorial(n));
    }

    private static int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        return n * factorial(n-1);
    }
}
