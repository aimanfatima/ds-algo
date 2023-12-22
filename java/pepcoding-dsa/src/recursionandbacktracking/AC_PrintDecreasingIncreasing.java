package recursionandbacktracking;

import java.util.Scanner;

public class AC_PrintDecreasingIncreasing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        printDescreasingIncreasing(n);
    }

    private static void printDescreasingIncreasing(int n) {
        if (n == 0) {
            return;
        }

        System.out.print(n + " ");
        printDescreasingIncreasing(n-1);
        System.out.print(n + " ");
    }
}
