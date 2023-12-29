package dynamicprogramming;

public class AD_ClimbStairsMinMoves {
    public static void main(String[] args) {
        int n = 6;
        int[] steps = {4, 2, 0, 2, 2, 3};
        System.out.println(climbStairsMinMoves(n, steps));
    }

    private static int climbStairsMinMoves(int n, int[] steps) {
        Integer[] dp = new Integer[n+1];
        dp[n] = 0;

        for (int i=n-1; i>=0 ; i--) {
            if (steps[i] > 0) {
                int minMoves = Integer.MAX_VALUE;
                for (int step = 1; step <= steps[i] && i+step <= n; step++) {
                    if (dp[i+step] != null) {
                        minMoves = Math.min(minMoves, dp[i+step]);
                    }
                }
                if (minMoves != Integer.MAX_VALUE) {
                    dp[i] = minMoves + 1;
                }
            }
            System.out.println(dp[i]);
        }
        return dp[0];
    }
}
