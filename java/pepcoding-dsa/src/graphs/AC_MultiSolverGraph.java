package graphs;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class AC_MultiSolverGraph {
    public static class Edge {
        int source;
        int neighbour;
        int weight;

        Edge(int source, int neighbour, int weight) {
            this.source = source;
            this.neighbour = neighbour;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "source=" + source +
                    ", destination=" + neighbour +
                    ", weight=" + weight +
                    '}';
        }

    }

    static class Pair implements Comparable<Pair> {
        int weight;
        String path;

        Pair(int weight, String path) {
            this.weight = weight;
            this.path = path;
        }

        public int compareTo(Pair o) {
            return this.weight - o.weight;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int vertices = scanner.nextInt();
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();

        for (int i=0; i<vertices; i++) {
            graph.add(new ArrayList<>());
        }

        int edges = scanner.nextInt();

        for (int i=0; i<edges; i++) {
            int source = scanner.nextInt();
            int neighbour = scanner.nextInt();
            int weight = scanner.nextInt();

            graph.get(source).add(new Edge(source, neighbour, weight));
            graph.get(neighbour).add(new Edge(neighbour, source, weight));
        }

        int source = scanner.nextInt();
        int destination = scanner.nextInt();

        int weight = scanner.nextInt();
        int k = scanner.nextInt();

        boolean[] visited = new boolean[vertices];
        multiSolver(graph, source, destination, visited, "" + source, weight, 0, k);

        System.out.println("smallestPath = " + smallestPath + " @ weight = " + smallestPathWeight);
        System.out.println("largestPath = " + largestPath + " @ weight = " + largestPathWeight);
        System.out.println("ceilPath = " + ceilPath + " @ weight = " + ceilPathWeight);
        System.out.println("floorPath = " + floorPath + " @ weight = " + floorPathWeight);
        System.out.println("kLargestPath = " + pq.peek().path + " @ weight = " + pq.peek().weight);

    }

    static String smallestPath;
    static int smallestPathWeight = Integer.MAX_VALUE;

    static String largestPath;
    static int largestPathWeight = Integer.MIN_VALUE;

    static String ceilPath;
    static int ceilPathWeight = Integer.MAX_VALUE;

    static String floorPath;
    static int floorPathWeight = Integer.MIN_VALUE;

    static PriorityQueue<Pair> pq = new PriorityQueue<>();

    private static void multiSolver(ArrayList<ArrayList<Edge>> graph, int source, int destination, boolean[] visited, String psf, int weight, int wsf, int k) {
        if (source == destination) {
            System.out.println(psf);

            if (wsf < smallestPathWeight) {
                smallestPathWeight = wsf;
                smallestPath = psf;
            }

            if (wsf > largestPathWeight) {
                largestPathWeight = wsf;
                largestPath = psf;
            }

            if (wsf < ceilPathWeight && wsf > weight) {
                ceilPath = psf;
                ceilPathWeight = wsf;
            }

            if (wsf > floorPathWeight && wsf < weight) {
                floorPath = psf;
                floorPathWeight = wsf;
            }

            if (pq.size() < k) {
                pq.add(new Pair(wsf, psf));
            } else {
                if (pq.peek().weight < wsf) {
                    pq.remove();
                    pq.add(new Pair(wsf, psf));
                }
            }

            return;
        }
        visited[source] = true;

        for (Edge edge: graph.get(source)) {
            if (!visited[edge.neighbour]) {
                multiSolver(graph, edge.neighbour, destination, visited, psf + edge.source, weight, wsf + edge.weight, k);
            }
        }
        visited[source] = false;
    }
}
