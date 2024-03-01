package graphs;

import java.util.ArrayList;
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
//        int k = scanner.nextInt();

        boolean[] visited = new boolean[vertices];
        int smallestPath = getSmallestPath(graph, source, destination, visited);
        System.out.println(smallestPath);
        int largestPath = getLargestPath(graph, source, destination, visited);
        System.out.println(largestPath);
        findCeilOfWeightW(graph, source, destination, visited, weight); // just greater than the weight
//        findFloorOfWeightW(); // just less than the weight
//        findKthLargestPath();
    }

    private static void findCeilOfWeightW(ArrayList<ArrayList<Edge>> graph, int source, int destination, boolean[] visited, int weight) {

    }

    private static int getSmallestPath(ArrayList<ArrayList<Edge>> graph, int source, int destination, boolean[] visited) {
        if (source == destination) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        visited[source] = true;
        for (Edge edge: graph.get(source)) {
            if (!visited[edge.neighbour]) {
                int neighbourPathWeight = getSmallestPath(graph, edge.neighbour, destination, visited);
                if (neighbourPathWeight != -1) {
                    min = Math.min(min, neighbourPathWeight);
                }
            }
        }
        visited[source] = false;
        if (min != Integer.MAX_VALUE) {
            return min + graph.get(source).get(0).weight;
        } else {
            return -1;
        }
    }

    private static int getLargestPath(ArrayList<ArrayList<Edge>> graph, int source, int destination, boolean[] visited) {
        if (source == destination) {
            return 0;
        }
        int min = Integer.MIN_VALUE;
        visited[source] = true;
        for (Edge edge: graph.get(source)) {
            if (!visited[edge.neighbour]) {
                int neighbourPathWeight = getLargestPath(graph, edge.neighbour, destination, visited);
                if (neighbourPathWeight != -1) {
                    min = Math.max(min, neighbourPathWeight);
                }
            }
        }
        visited[source] = false;
        if (min != Integer.MIN_VALUE) {
            return min + graph.get(source).get(0).weight;
        } else {
            return -1;
        }
    }



}
