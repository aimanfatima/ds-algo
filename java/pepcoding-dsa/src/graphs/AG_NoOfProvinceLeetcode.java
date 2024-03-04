package graphs;

public class AG_NoOfProvinceLeetcode {
    public static void main(String[] args) {
        int[][] isConnected = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };

        System.out.println(findCircleNum(isConnected));
    }

    private static int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];

        int count = 0;

        for (int i=0; i<n; i++) {
            if (!visited[i]) {
                count++;
                dfs(isConnected, i, visited);
            }
        }

        return count;
    }

    public static void dfs(int[][] graph, int src, boolean[] visited) {
        visited[src] = true;
        for (int j=0; j<graph[src].length; j++) {
            if (src!=j && graph[src][j] ==1 && !visited[j]) {
                dfs(graph, j, visited);
            }
        }
    }
}
