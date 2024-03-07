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

public class AN_DijkstrasAlgorithm {
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
        int psf;
        int wsf;

        Pair(int vertex, int psf, int wsf) {
            this.vertex = vertex;
            this.psf = psf;
            this.wsf = wsf;
        }

        @Override
        public int compareTo(Pair o) {
            return this.wsf - o.wsf;
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

        int source = scanner.nextInt();
        boolean[] visited = new boolean[n];
        printShortestPathToAllOtherEdges(graph, source, visited);
    }

    private static void printShortestPathToAllOtherEdges(ArrayList<ArrayList<Edge>> graph, int source, boolean[] visited) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.offer(new Pair(source, source, 0));

        while (!pq.isEmpty()) {
            Pair p = pq.poll();

            if (visited[p.vertex]) {
                continue;
            }
            visited[p.vertex] = true;
            System.out.println(p.vertex + " via " + p.psf + " @ " + p.wsf);

            for (Edge edge: graph.get(p.vertex)) {
                if (!visited[edge.nbr]) {
                    pq.offer(new Pair(edge.nbr, p.psf + edge.nbr, p.wsf + edge.weight));
                }
            }
        }
    }
}
