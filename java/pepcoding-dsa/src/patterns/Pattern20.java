package patterns;

/*

Print a W
n = 5

*               *
*               *
*       *       *
*   *       *   *
*               *

 */

public class Pattern20 {
    public static void main(String[] args) {
        int n = 7;

        for (int i=1; i<=n; i++) {
            for (int j=1; j<=n; j++) {
                if (j==1 || j==n
                        || (i==j && i>=(n/2)+1)
                        || (j==n-i+1 && i>=(n/2)+1)) {
                    System.out.print("*\t");
                } else {
                    System.out.print(" \t");
                }
            }
            System.out.println();
        }

    }
}
