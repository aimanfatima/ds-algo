package graphs;

import java.util.ArrayDeque;
import java.util.Queue;

public class AI_BreadthFirstSearch {
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
        int[][] graph = {
                {1, 3},
                {0, 2},
                {1, 3},
                {0, 2, 4},
                {3, 5, 6},
                {4, 6},
                {4, 5}
        };

        int source = 2;
        Pair pair = new Pair(source, String.valueOf(source));
        Queue<Pair> queue = new ArrayDeque<>();
        queue.offer(pair);

        boolean[] visited = new boolean[n];

        while (!queue.isEmpty()) {
            Pair element = queue.poll();
            // ????
//            if (visited[element.vertex]) {
//                continue;
//            }
            visited[element.vertex] = true;
            System.out.println(element.path);
            for (int nbr: graph[element.vertex]) {
                if (!visited[nbr]) {
                    queue.offer(new Pair(nbr, element.path+nbr));
                }
            }
        }

    }
}
