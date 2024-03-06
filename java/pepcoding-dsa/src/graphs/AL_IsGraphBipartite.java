package graphs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class AL_IsGraphBipartite {
    public static class Pair {
        int vertex;
        int level;

        Pair(int vertex, int level) {
            this.vertex = vertex;
            this.level = level;
        }
    }
    public static void main(String[] args) {
//        int n = 3;
//        int[][] graph = {
//                {1, 2},
//                {0, 2},
//                {0, 1}
//        };

        int n = 4;
        int[][] graph = {
                {1, 3},
                {0, 2},
                {1, 3},
                {0, 2}
        };

        int[] visited = new int[n];
        Arrays.fill(visited, -1);
        boolean isBipartite = true;
        for (int source = 0; source < n; source++) {
            if (visited[source] == -1) {
                boolean isComponentBipartite = isComponentBipartite(graph, source, visited);
                if (!isComponentBipartite) {
                    isBipartite = false;
                    break;
                }
            }
        }

        System.out.println(isBipartite);
    }

    private static boolean isComponentBipartite(int[][] graph, int source, int[] visited) {
        Queue<Pair> queue = new ArrayDeque<>();
        queue.offer(new Pair(source, 0));

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            if (visited[pair.vertex] != -1) {
                // means that we found a cycle,
                // now all we need to check is
                // if the level at which it was found previously is same as this one
                if (pair.level != visited[pair.vertex]) {
                    return false;
                }
            } else {
                visited[pair.vertex] = pair.level;
            }

            for (int nbr: graph[pair.vertex]) {
                if (visited[nbr] == -1) {
                    queue.offer(new Pair(nbr, pair.level + 1));
                }
            }
        }
        return true;
    }
}
