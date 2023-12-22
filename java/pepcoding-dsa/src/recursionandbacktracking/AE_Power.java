package recursionandbacktracking;

import java.util.Scanner;

public class AE_Power {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int n = scanner.nextInt();
        System.out.println(power(x, n));
        System.out.println(powerLogarithmic(x, n));
    }

    // Solves in Linear O(n)
    private static int power(int x, int n) {
        if (n == 0) {
            return 1;
        }
        return x * power(x, n-1);
    }

    // solves in log n
    private static int powerLogarithmic(int x, int n) {
        if (n == 0) {
            return 1;
        }

        int xn2 = powerLogarithmic(x, n/2);
        if (n%2 == 0) {
            return xn2 * xn2;
        } else {
            return x * xn2 * xn2;
        }
    }
}
