package patterns;

/*

1                       1
1   2               2   1
1   2   3       3   2   1
1   2   3   4   3   2   1

 */

public class Pattern16 {
    public static void main(String[] args) {
        int n = 4;
        int sp = (n*2) - 1;

        for (int i=1; i<=n; i++) {
            int val = 1;
            for (int j=1; j<=sp; j++) {
                if (j<=i) {
                    System.out.print(val + "\t");
                    if (!(i==n && j==n))
                        val++;
                } else if (j>sp-i) {
                    val--;
                    System.out.print(val + "\t");
                } else {
                    System.out.print(" \t");
                }
            }
            System.out.println();
        }
    }
}
