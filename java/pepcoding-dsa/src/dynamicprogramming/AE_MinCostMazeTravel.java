package dynamicprogramming;

public class AE_MinCostMazeTravel {
    public static void main(String[] args) {
        int[][] maze = {
                {2, 1, 1, 8},
                {1, 3, 9, 3},
                {0, 7, 1, 6},
                {1, 2, 5, 0},
                {0, 4, 8, 0}
        };

        System.out.println(minCost(maze));
    }

    private static int minCost(int[][] maze) {
        int rows = maze.length;
        int columns = maze[0].length;
        int[][] dp = new int[rows][columns];
        for (int i=0; i<rows; i++) {
            for (int j=0; j<columns; j++) {
                if (i==0 && j==0) {
                    dp[i][j] = maze[i][j];
                } else if (i == 0) {
                    dp[i][j] = dp[i][j-1] + maze[i][j];
                } else if (j == 0) {
                    dp[i][j] = dp[i-1][j] + maze[i][j];
                } else {
                    dp[i][j] = Math.min(dp[i][j-1], dp[i-1][j]) + maze[i][j];
                }
            }
        }
        return dp[rows-1][columns-1];
    }
}
