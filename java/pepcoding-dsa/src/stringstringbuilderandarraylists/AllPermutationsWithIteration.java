package stringstringbuilderandarraylists;

import java.util.Scanner;

public class AllPermutationsWithIteration {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        printAllPermutations(str);
    }

    private static void printAllPermutations(String str) {
        int totalPermutations = fact(str.length());
        for (int i=0; i<totalPermutations; i++) {
            StringBuilder sb = new StringBuilder(str);
            int dividend = i;

            for (int divisor = str.length(); divisor >= 1; divisor--) {
                int remainder = dividend % divisor;
                dividend = dividend/divisor;
                System.out.print(sb.charAt(remainder));
                sb.deleteCharAt(remainder);
            }
            System.out.println();
        }
    }

    private static int fact(int n) {
        int result = 1;
        for (int i=1; i<=n; i++) {
            result = result*i;
        }
        return result;
    }
}
