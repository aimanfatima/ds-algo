package patterns;

/*
        1
    2   3   2
3   4   5   4   3
    2   3   2
        1

 */

public class Pattern15 {
    public static void main(String[] args) {
        int n = 5;
        int sp = n/2;
        int num = 1;

        int val = 1;

        for (int i=1; i<=n; i++) {
            for (int j=1; j<=sp; j++) {
                System.out.print(" \t");
            }
            int printVal = val;
            for (int j=1; j<=num; j++) {
                System.out.print(printVal + "\t");
                if (j<=num/2) {
                    printVal++;
                } else {
                    printVal--;
                }
            }
            if (i<=n/2) {
                sp--;
                num += 2;
                val ++;
            } else {
                sp++;
                num -= 2;
                val--;
            }
            System.out.println();
        }
    }
}
