package dynamicprogramming;

public class AF_Goldmine {
    public static void main(String[] args) {
        int[][] mine = {
                {0, 1, 4, 2, 8, 2},
                {4, 3, 6, 5, 0, 4},
                {1, 2, 4, 1, 4, 6},
                {2, 0, 7, 3, 2, 2},
                {3, 1, 5, 9, 2, 4},
                {2, 7, 0, 8, 5, 1}
        };

        System.out.println(maxGold(mine));
    }

    private static int maxGold(int[][] mine) {
        int rows = mine.length;
        int columns = mine[0].length;
        int[][] dp = new int[rows][columns];

        int maxGold = 0;
        for (int column = 0; column < columns ; column++) {
            for (int row = 0; row < rows; row++) {
                if (column == 0) {
                    dp[row][column] = mine[row][column];
                } else if (row == 0) {
                    dp[row][column] = mine[row][column] + Math.max(dp[row][column-1], dp[row+1][column-1]);
                } else if (row == rows-1) {
                    dp[row][column] = mine[row][column] + Math.max(dp[row][column-1], dp[row-1][column-1]);
                } else {
                    dp[row][column] = mine[row][column] + Math.max(dp[row][column-1], Math.max(dp[row-1][column-1], dp[row+1][column-1]));
                }
                if (column == columns-1) {
                    maxGold = Math.max(maxGold, dp[row][column]);
                }
            }
        }
        return maxGold;

    }
}
