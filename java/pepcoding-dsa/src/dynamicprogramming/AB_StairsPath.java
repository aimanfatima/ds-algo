package dynamicprogramming;

public class AB_StairsPath {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(countPathsMemoized(n, new int[n+1]));
        System.out.println(countPathsTabulation(n));
    }

    private static int countPathsTabulation(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;

        for (int i=1; i < n+1; i++) {
            if (i == 1) {
                dp[i] = dp[i-1];
            } else if (i == 2) {
                dp[i] = dp[i-1] + dp[i-2];
            } else {
                dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
            }
        }

        return dp[n];
    }

    private static int countPathsMemoized(int n, int[] qb) {
        if (n < 0) {
            return 0;
        }

        if (n == 0) {
            return 1;
        }

        if (qb[n] != 0) {
            return qb[n];
        }
        int pathsFromN = countPathsMemoized(n-1, qb) + countPathsMemoized(n-2, qb) + countPathsMemoized(n-3,qb);
        qb[n] = pathsFromN;
        return pathsFromN;
    }
}
