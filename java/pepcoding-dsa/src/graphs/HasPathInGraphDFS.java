package graphs;

import java.util.ArrayList;
import java.util.Scanner;

public class HasPathInGraphDFS {
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
    /**
     * Try with input -
     *
     * 7
     * 8
     * 0 1 10
     * 1 2 10
     * 2 3 10
     * 0 3 10
     * 3 4 10
     * 4 5 10
     * 5 6 10
     * 4 6 10
     *
     * 0
     * 6
     *
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int vertices = scanner.nextInt();
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>(vertices);

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

        for (int i=0; i<graph.size(); i++) {
            System.out.println(graph.get(i));
        }
        
        int source = scanner.nextInt();
        int destination = scanner.nextInt();

        boolean[] visited = new boolean[vertices];
        boolean hasPath = hasPath(graph, source, destination, visited);
        System.out.println(hasPath);
    }

    private static boolean hasPath(ArrayList<ArrayList<Edge>> graph, int source, int destination, boolean[] visited) {
        if (source == destination) {
            return true;
        }

        visited[source] = true;

        for (Edge edge : graph.get(source)) {
            if (!visited[edge.neighbour]) {
                if (hasPath(graph, edge.neighbour, destination, visited)) {
                    return true;
                }
            }
        }

        return false;
    }
}
