package patterns;

/**
 DIAGONAL
                *
            *
        *
    *
 *

 */

public class pattern8 {
    public static void main(String[] args) {
        int n = 5;

        for (int i=1; i<=n; i++) {
            for (int j=1; j<=n-i+1; j++) {
                if (j==n-i+1) {
                    System.out.print("*");
                } else {
                    System.out.print(" \t");
                }
            }
            System.out.println();
        }
    }
}
