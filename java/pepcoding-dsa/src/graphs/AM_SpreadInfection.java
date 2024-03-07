package graphs;

import java.util.ArrayDeque;
import java.util.Queue;

public class AM_SpreadInfection {
    public static class Pair {
        int vertex;
        int level;

        Pair(int vertex, int level) {
            this.vertex = vertex;
            this.level = level;
        }
    }
    public static void main(String[] args) {
        // Given a graph representing people and their connectivity
        // You are also given a source person who got infected initially at t=1,
        // and you're given a time t
        // You are required to calculate how many people will get infected in time t;
        // if the infection spreads to the neighbours in 1 unit of time

        int n = 7;

        int[][] graph = {
                {1, 3},
                {0, 2},
                {1, 3},
                {0, 2},
                {3, 5, 6},
                {4, 6},
                {4, 6}
        };

        int infectedSource = 6;
        int t = 3;

        boolean[] visited = new boolean[n];

        System.out.println(noOfInfectedPeopleInTimet(graph, infectedSource, t, visited));
    }

    private static int noOfInfectedPeopleInTimet(int[][] graph, int infectedSource, int t, boolean[] visited) {
        int count = 0;

        Queue<Pair> queue = new ArrayDeque<>();
        queue.offer(new Pair(infectedSource, 0));

        while (!queue.isEmpty()) {
            // remove
            Pair pair = queue.poll();

            // work
            if (pair.level > t) {
                return count;
            }

            // mark
            if (!visited[pair.vertex]) {
                visited[pair.vertex] = true;
                count++;
            } else {
                continue;
            }

            // add
            for (int nbr: graph[pair.vertex]) {
                if (!visited[nbr]) {
                    queue.add(new Pair(nbr, pair.level + 1));
                }
            }
        }

        return count;
    }
}
