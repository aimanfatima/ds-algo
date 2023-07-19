package patterns;

/**
 PRINT DIAGONAL
 *
    *
        *
            *
                *

 */

public class Pattern7 {
    public static void main(String[] args) {
        int n = 5;

        for (int i=1; i<=n; i++) {
            for (int j=1; j<=i; j++) {
                if (j==i) {
                    System.out.print("*");
                } else {
                    System.out.print(" \t");
                }
            }
            System.out.println();
        }
    }
}
