package patterns;

/*

1
1   1
1   2   1
1   3   3   1
1   4   6   4   1
1   5   10  10  5   1
1   6   15  77  15  6  1

Hint - something related to permutation and combination
 */

public class Pattern13 {
    public static void main(String[] args) {
        int n = 7;

        for (int i=0; i<n; i++) {
            int val = 1;
            for (int j=0; j<=i; j++) {
                System.out.print(val + "\t");
                val = (val * (i-j))/(j+1);
            }
            System.out.println();
        }
    }
}
