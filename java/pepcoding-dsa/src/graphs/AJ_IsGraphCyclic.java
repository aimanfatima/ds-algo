package graphs;

import java.util.ArrayDeque;
import java.util.Queue;

public class AJ_IsGraphCyclic {
    public static class Pair {
        int vertex;
        String path;

        Pair(int vertex, String path) {
            this.vertex = vertex;
            this.path = path;
        }
    }
    public static void main(String[] args) {
        int n = 7;

        // a graph with no cycle - should return false
//        int[][] graph = {
//            {1, 3},
//            {0},
//            {3},
//            {0, 2, 4},
//            {3, 6},
//            {6},
//            {4, 5}
//        };

        // a graph WITH cycle - should return true
        int[][] graph = {
                {1, 3},
                {0, 2},
                {1, 3},
                {0, 2, 4},
                {3, 5, 6},
                {4, 6},
                {4, 5}
        };

        boolean[] visited = new boolean[n];

        System.out.println(isGraphCyclic(graph, visited, 0));
    }

    private static boolean isGraphCyclic(int[][] graph, boolean[] visited, int source) {
        Queue<Pair> queue = new ArrayDeque<>();
        Pair startNode = new Pair(source, String.valueOf(source));

        queue.offer(startNode);

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            if (visited[pair.vertex]) {
                System.out.println("Cycle Found - " + pair.path);
                return true;
            }
            visited[pair.vertex] = true;
            for (int nbr: graph[pair.vertex]) {
                if (!visited[nbr]) {
                    queue.offer(new Pair(nbr, pair.path + nbr));
                }
            }
        }

        return false;
    }
}
