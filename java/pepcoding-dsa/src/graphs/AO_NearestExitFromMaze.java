package graphs;

import java.util.ArrayDeque;
import java.util.Queue;

// Leetcode 1926
public class AO_NearestExitFromMaze {
    public class Pair {
        int row;
        int col;
        int level;

        Pair(int row, int col, int level) {
            this.row = row;
            this.col = col;
            this.level = level;
        }
    }
    public int nearestExit(char[][] maze, int[] entrance) {
        int rows = maze.length;
        int cols = maze[0].length;

        int minSteps = 0;
        Queue<Pair> queue = new ArrayDeque<>();
        queue.offer(new Pair(entrance[0], entrance[1], 0));

        boolean[][] visited = new boolean[maze.length][maze[0].length];

        while(!queue.isEmpty()) {
            Pair p = queue.poll();
            if (visited[p.row][p.col]) {
                continue;
            }
            visited[p.row][p.col] = true;

            // work
            if ((p.row == 0 || p.row == rows-1 || p.col == 0 || p.col == cols-1)
                    && !(p.row == entrance[0] && p.col == entrance[1])) {
                return p.level;
            }

            // add
            // up
            int i = p.row;
            int j = p.col;
            if (j-1 >= 0 && maze[i][j-1] == '.') {
                if (!visited[i][j-1]) {
                    queue.add(new Pair(i, j-1, p.level+1));
                }
            }

            // down
            if (j+1 < cols && maze[i][j+1] == '.') {
                if (!visited[i][j+1]) {
                    queue.add(new Pair(i, j+1, p.level+1));
                }
            }

            // left
            if (i-1 >= 0 && maze[i-1][j] == '.') {
                if (!visited[i-1][j]) {
                    queue.add(new Pair(i-1, j, p.level+1));
                }
            }

            // right
            if (i+1 < rows && maze[i+1][j] == '.') {
                if (!visited[i+1][j]) {
                    queue.add(new Pair(i+1, j, p.level+1));
                }
            }
        }
        return -1;
    }
}
