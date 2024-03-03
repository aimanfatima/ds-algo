package graphs;

import java.util.ArrayList;

public class AD_GetConnectedComponentsOfAGraph {
    static class Edge {
        int source;
        int neighbour;

        Edge(int src, int nbr) {
            this.source = src;
            this.neighbour = nbr;
        }
    }
    public static void main(String[] args) {
        int n = 3;
        int[][] edges = {
                {0, 1},
                {0, 2}
        };
        System.out.println(countComponents(n, edges));
    }
    public static int countComponents(int n, int[][] edges) {
        // Create an adjacency List
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        for (int i=0; i<n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i=0; i<edges.length; i++) {
            int src = edges[i][0];
            int nbr = edges[i][1];
            graph.get(src).add(new Edge(src, nbr));
            graph.get(nbr).add(new Edge(nbr, src));
        }

        // mark a vertex visit after we visit them
        boolean[] visited = new boolean[n];
        int count = 0;
        for (int i=0; i<n; i++) {
            if (!visited[i]) {
                count++;
                // this recursive is just to update the visited array,
                // so that we know when to update the count
                countComponentsRecursion(graph, i, visited);
            }
        }

        return count;
    }

    public static void countComponentsRecursion(ArrayList<ArrayList<Edge>> graph, int source, boolean[] visited) {
        visited[source] = true;
        for (Edge edge : graph.get(source)) {
            if (!visited[edge.neighbour]) {
                countComponentsRecursion(graph, edge.neighbour, visited);
            }
        }
    }
}
