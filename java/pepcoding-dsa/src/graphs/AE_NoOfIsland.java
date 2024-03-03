package graphs;

public class AE_NoOfIsland {
    public static void main(String[] args) {
        int[][] grid = {{1,1,0,0,0},
                {1,1,0,0,0},
                {0,0,1,0,0},
                {0,0,0,1,1}};
        System.out.println(numIslands(grid));
    }

    public static int numIslands(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        boolean[][] visited = new boolean[rows][cols];
        int count = 0;

        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    count++;
                    drawTree(grid, i, j, visited);
                }
            }
        }

        return count;
    }

    public static void drawTree(int[][] grid, int i, int j, boolean[][] visited) {
        if (i<0 || j<0 || i>grid.length-1 || j>grid[0].length-1 || grid[i][j]==0 || visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        drawTree(grid, i-1, j, visited);
        drawTree(grid, i, j-1, visited);
        drawTree(grid, i, j+1, visited);
        drawTree(grid, i+1, j, visited);
    }
}
