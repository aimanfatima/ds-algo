package recursionandbacktracking;

import java.util.Scanner;

public class AA_PrintDecreasing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        printDecreasing(n);
    }

    private static void printDecreasing(int n) {
        if (n == 0) {
            return;
        }
        System.out.print(n + " ");
        printDecreasing(n-1);
    }
}
