package patterns;

import java.util.Scanner;

/**

 *	*	*	*	*
    *	*	*	*
        *	*	*
            *	*
                *

 */

public class Pattern4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int i=1; i<=n; i++) {
            for (int k=1; k<i; k++) {
                System.out.print("\t");
            }
            for (int j=1; j<=n-i+1; j++) {
                System.out.print("*\t");
            }
            System.out.println();
        }
    }
}
