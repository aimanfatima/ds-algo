package patterns;

/*

Print arrow -
n = 7

            *
            *   *
            *   *   *
*   *   *   *   *   *   *
            *   *   *
            *   *
            *

 */

public class Pattern17 {
    public static void main(String[] args) {
        int n = 7;
        int sp = n/2;
        int st = 1;

        for (int i=1; i<=n; i++) {
            for (int j=1; j<=sp; j++) {
                System.out.print(" \t");
            }
            for (int j=1; j<=st; j++) {
                if (j<=st/2 && i!=(n/2) +1) {
                    System.out.print(" \t");
                } else {
                    System.out.print("*\t");
                }
            }
            if (i<=n/2) {
                sp--;
                st+=2;
            } else {
                sp++;
                st-=2;
            }
            System.out.println();
        }
    }
}
