package graphs;

import java.util.ArrayList;
import java.util.Scanner;

public class AQ_DetectCycleInDirectedGraph {
    public static class Edge {
        int nbr;
        int weight;

        Edge (int nbr, int weight) {
            this.nbr = nbr;
            this.weight = weight;
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

        boolean isCyclic = false;
        boolean[] visited = new boolean[n];
        for (int src = 0; src < n; src++) {
            boolean[] pathVisited = new boolean[n];
            if (!visited[src]) {
                if (isComponentCyclic(graph, src, visited, pathVisited)) {
                    isCyclic = true;
                }
            }
        }
        System.out.println(isCyclic);
    }

    private static boolean isComponentCyclic(ArrayList<ArrayList<Edge>> graph, int source, boolean[] visited, boolean[] pathVisited) {
        visited[source] = true;
        pathVisited[source] = true;
        for (Edge edge: graph.get(source)) {
            if (pathVisited[edge.nbr]) {
                return true;
            }
            if (!visited[edge.nbr]) {
                if (isComponentCyclic(graph, edge.nbr, visited, pathVisited)) {
                    return true;
                }
            }
        }
        pathVisited[source] = false;
        return false;
    }
}
