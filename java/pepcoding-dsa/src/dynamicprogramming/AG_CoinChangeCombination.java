package dynamicprogramming;

public class AG_CoinChangeCombination {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        System.out.println(change(5, coins));
    }

    public static int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        dp[0] = 1;

        for (int coin = 0; coin < coins.length; coin++) {
            int coinValue = coins[coin];
            for (int i=coinValue; i<=amount ; i++) {
                if (dp[i-coinValue]>0) {
                    dp[i] += dp[i-coinValue];
                }
            }
        }

        return dp[amount];
    }
}
