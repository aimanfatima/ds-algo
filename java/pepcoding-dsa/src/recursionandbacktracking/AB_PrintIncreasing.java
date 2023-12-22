package recursionandbacktracking;

import java.util.Scanner;

public class AB_PrintIncreasing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        printIncreasing(n);
    }

    private static void printIncreasing(int n) {
        if (n == 0) {
            return;
        }
        printIncreasing(n-1);
        System.out.print(n + " ");
    }
}
