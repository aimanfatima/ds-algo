package dynamicprogramming;

public class AC_ClimbStairsWithJumps {
    public static void main(String[] args) {
        int n = 6;
        int[] steps = {3, 3, 0, 2, 2, 3};
        System.out.println(countPathsTabulation(n, steps));
    }

    private static int countPathsTabulation(int n, int[] steps) {
        int[] dp = new int[n+1];
        dp[n] = 1;

        for (int i=n-1; i >=0 ; i--) {
            for (int step = 1; step <=steps[i]; step++) {
                if (i+step <= n) {
                    dp[i] += dp[i+step];
                }
            }
        }

        return dp[0];
    }
}
