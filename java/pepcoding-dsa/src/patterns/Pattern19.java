package patterns;

/*

SWASTIK

* * *   *
    *   *
* * * * *
*   *
*   * * *

 */

public class Pattern19 {
    public static void main(String[] args) {
        int n = 9;
        int half = (n/2) + 1;

        for (int i=1; i<=n; i++) {
            for (int j=1; j<=n; j++) {
                if (i==(n/2)+1
                        || j==(n/2)+1
                        || (i==1 && j<=half)
                        || (i==n && j>half)
                        || (j==1 && i>half)
                        || (j==n && i<=half)) {
                    System.out.print("*\t");
                } else {
                    System.out.print(" \t");
                }
            }
            System.out.println();
        }

    }
}
