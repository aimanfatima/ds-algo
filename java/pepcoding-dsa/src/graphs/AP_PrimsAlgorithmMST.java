package graphs;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 *
 7
 8
 0 1 10
 0 1 40
 1 2 10
 2 3 10
 3 4 2
 4 5 3
 5 6 3
 4 6 8
 0
 */

public class AP_PrimsAlgorithmMST {
    public static class Edge {
        int nbr;
        int weight;

        Edge (int nbr, int weight) {
            this.nbr = nbr;
            this.weight = weight;
        }
    }

    public static class Pair implements Comparable<Pair> {
        int vertex;
        int acquiringVertex;
        int weight;

        Pair(int vertex, int acquiringVertex, int weight) {
            this.vertex = vertex;
            this.acquiringVertex = acquiringVertex;
            this.weight = weight;
        }

        @Override
        public int compareTo(Pair o) {
            return this.weight - o.weight;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        for (int i=0; i<n; i++) {
            graph.add(new ArrayList<>());
        }

        int edges = scanner.nextInt();

        for (int i=0; i<edges; i++) {
            int source = scanner.nextInt();
            int nbr = scanner.nextInt();
            int weight = scanner.nextInt();

            graph.get(source).add(new Edge(nbr, weight));
            graph.get(nbr).add(new Edge(source, weight));
        }

        int source = 0;
        boolean[] visited = new boolean[n];
        printMSTUsingPrimsAlgorithm(graph, source, visited);
    }

    private static void printMSTUsingPrimsAlgorithm(ArrayList<ArrayList<Edge>> graph, int source, boolean[] visited) {
        // Add first vtx to the PQ
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.offer(new Pair(source, -1, 0));

        while (!pq.isEmpty()) {
            // remove
            Pair pair = pq.poll();

            // mark*
            if (visited[pair.vertex]) {
                continue;
            }
            visited[pair.vertex] = true;

            // work
            if (pair.acquiringVertex != -1) {
                System.out.println(pair.vertex  + " via " + pair.acquiringVertex + " @ " + pair.weight);
            }

            // add *
            for (Edge edge : graph.get(pair.vertex)) {
                if (!visited[edge.nbr]) {
                    pq.offer(new Pair(edge.nbr, pair.vertex, edge.weight));
                }
            }
        }
    }
}
