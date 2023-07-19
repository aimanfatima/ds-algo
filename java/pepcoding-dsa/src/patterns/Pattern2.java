package patterns;

import java.util.Scanner;

/**

 Print this pattern -
 * * * * * *
 * * * * *
 * * * *
 * * *
 * *
 *

 */

public class Pattern2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int i=1; i<=n; i++) {
            for (int j=n; j>=i; j--) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
