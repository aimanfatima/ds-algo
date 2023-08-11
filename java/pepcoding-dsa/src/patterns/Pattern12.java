package patterns;

/*

Fibonacci sequence triangle

0
1   1
2   3   5
8   13  21  34
 */

import java.util.Scanner;

public class Pattern12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int first = 0;
        int second = 1;

        for (int i=1; i<=n; i++) {
            for (int j=1; j<=i; j++) {
                System.out.print(first + "\t");
                int temp = second;
                second = first + second;
                first = temp;
            }
            System.out.println();
        }
    }
}
